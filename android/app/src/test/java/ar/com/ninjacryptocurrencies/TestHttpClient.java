package ar.com.ninjacryptocurrencies;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import ar.com.ninjacryptocurrencies.bean.Ticker;

public class TestHttpClient {
    
    @Test
    public void testGetHttpRestClient(){
        final String url ="https://api.coinmarketcap.com/v1/ticker/?limit=100";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<Ticker []> responseEntity = restTemplate.getForEntity(url, Ticker[].class);
        Ticker [] arrayTicker = responseEntity.getBody();

        Assert.assertNotNull(arrayTicker);
        Assert.assertTrue("No se trajeron los 10 elementos", arrayTicker.length == 100);
    }
}
