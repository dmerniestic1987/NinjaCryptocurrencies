package ar.com.ninjacryptocurrencies;

import org.junit.Test;
import org.springframework.util.Assert;

import java.util.List;

public class ConfigManagerTest {
    @Test
    public void testCreateList(){
        List lista = ar.com.ninjacryptocurrencies.Config.ConfigManager.generateList();
        Assert.notNull(lista, "Lista nula");
        Assert.notEmpty(lista, "lista vacía");
        Assert.isTrue(lista.size() != 0);
    }


    @Test
    public void testCleanList(){
        List lista = ar.com.ninjacryptocurrencies.Config.ConfigManager.generateList();
        Assert.notNull(lista, "Lista nula");
        Assert.notEmpty(lista, "lista vacía");
        ar.com.ninjacryptocurrencies.Config.ConfigManager.cleanList(lista);
        Assert.isTrue(lista.isEmpty());
    }

    @Test
    public void testQueFalla(){
        Assert.doesNotContain("Estoy buscando la palabra goku", "goku", "la palabra goku existe en la grase");
    }


}
