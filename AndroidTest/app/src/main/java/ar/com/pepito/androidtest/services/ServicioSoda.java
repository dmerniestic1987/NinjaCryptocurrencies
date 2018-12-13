package ar.com.pepito.androidtest.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/*
Este servicio va a consultar a la base de datos para ver cuántas sodas
quedan en el depósito
 */
public class ServicioSoda extends Service {
    private static final String TAG = "ServicioSoda";

    public ServicioSoda() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
