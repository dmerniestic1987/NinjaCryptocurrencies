package ar.com.ninjacryptocurrencies.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import ar.com.ninjacryptocurrencies.R;
import io.fabric.sdk.android.Fabric;

/**
 * Permite realizar los SingIn con Google
 */
public class SingInActivity extends AppCompatActivity {
    private static final String TAG = "SingInActivity";
    private static final int RC_SIGN_IN = 9001;

    private GoogleSignInClient googleSignInCliente;
    private FirebaseAuth firebaseAuth;
    private FirebaseAnalytics firebaseAnalytics;
    private SignInButton singInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        Fabric.with(this, new Crashlytics());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInCliente = GoogleSignIn.getClient(this, gso);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        singInButton = this.findViewById(R.id.signInButton);

        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInWithGoogle();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null){
            initCryptoCurrenciesActivity();
        }
    }
    /**
     * Inicia el Activity de FireBase encargado de realizar la autenticación
     */
    private void signInWithGoogle(){
        Intent signInIntent = googleSignInCliente.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            //El SingIn fue correcto
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                Crashlytics.log("Error en Login: " + result.getStatus().getStatus().toString());
                showErrorDialog(result.getStatus().getStatus().toString());
            }
        }
    }

    /**
     * Autoriza con la cuenta de Google.
     * @param acct
     */
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        firebaseAnalytics.setUserId(user.getUid());
                        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SIGN_UP, null);
                        initCryptoCurrenciesActivity();
                    
                    } else {
                        showErrorDialog(getString(R.string.authentication_failed));
                        firebaseAnalytics.logEvent("sing_up_failed", null);
                    }
                }
            });
    }

    /**
     * Iniciamos la actividad principal
     */
    private void initCryptoCurrenciesActivity(){
        Intent i = new Intent(this, NinjaCryptocurrenciesActivity.class);
        startActivity(i);
    }

    /**
     * Muestra un Dialogo para informar que hubo error.
     * @param msg
     */
    private void showErrorDialog(String msg) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }

        builder.setTitle(getString(R.string.error_login))
                .setMessage(msg)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        signInWithGoogle();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
