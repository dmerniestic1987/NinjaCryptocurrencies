package ar.com.ninjacryptocurrencies.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.ninjacryptocurrencies.R;

public class CodeFragment extends Fragment implements View.OnClickListener{
    private TextView code_text_link_1;
    private TextView code_git_clone_https;
    private TextView code_git_clone_ssh;
    private ImageView imageGitHub;

    public static CodeFragment newInstance() {
        CodeFragment fragment = new CodeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_code, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onStart() {
        super.onStart();
        code_text_link_1 = this.getActivity().findViewById(R.id.code_text_link_1);
        code_text_link_1.setClickable(true);
        code_text_link_1.setOnClickListener(this);

        code_git_clone_https = this.getActivity().findViewById(R.id.code_git_clone_https);
        code_git_clone_https.setClickable(true);
        code_git_clone_https.setOnClickListener(this);


        code_git_clone_ssh = this.getActivity().findViewById(R.id.code_git_clone_ssh);
        code_git_clone_ssh.setClickable(true);
        code_git_clone_ssh.setOnClickListener(this);

        imageGitHub = this.getActivity().findViewById(R.id.imageGitHub);
        imageGitHub.setClickable(true);
        imageGitHub.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String url = getString(R.string.url_github_ninja_cryptocurrencies);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
