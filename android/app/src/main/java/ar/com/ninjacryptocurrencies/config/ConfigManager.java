package ar.com.ninjacryptocurrencies.Config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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

    public static List generateList(){
        List lista = new ArrayList();
        lista.add("Mates");
        lista.add("Manteca");
        lista.add(1988);
        lista.add(new BigDecimal(192.3));

        return lista;
    }

    public static void cleanList(List lista){
        if (lista != null)
            lista.clear();
    }


}
