package ar.com.criptocurrencies.Config;

import java.util.Locale;

/**
 * Manages general cofirutaion of the App
 * Created by dmernies on 12/3/18.
 */

public class ConfigManager {
    private static Locale LOCALE_APP = new Locale("es", "ES");

    public static Locale getLocale(){
        return LOCALE_APP;
    }
}
