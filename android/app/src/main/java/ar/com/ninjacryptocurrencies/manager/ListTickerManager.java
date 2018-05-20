package ar.com.ninjacryptocurrencies.manager;

import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.map.ListOrderedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ar.com.ninjacryptocurrencies.bean.Ticker;

/**
 * Administra la lista de los tickers
 * Created by dmernies on 14/3/18.
 */

public class ListTickerManager {
    private OrderedMap<String, Ticker> mapTicker;
    private static ListTickerManager instance = null;

    private ListTickerManager(){
        super();
        this.mapTicker = new ListOrderedMap<>();
    }

    /**
     * Creates an unique instance of ListTickerManager
     * @return instance ListTickerManager
     */
    public static ListTickerManager getInstance(){
        if (instance == null){
            instance = new ListTickerManager();
        }

        return instance;
    }
    public synchronized void addOrUpdateAll(Ticker [] arrayTicker){
        for (int i = 0; i < arrayTicker.length; i++){
            this.mapTicker.put(arrayTicker[i].getId(), arrayTicker[i]);
        }
    }

    public void clearTickers(){
        this.mapTicker.clear();
    }

    public void addTicker(Ticker ticker){
        this.mapTicker.put(ticker.getId(), ticker);
    }


    public Ticker getTickerById(String id){
        return this.mapTicker.get(id);
    }

    public Map<String, Ticker> getMapTicker() {
        return mapTicker;
    }

    public void setMapTicker(OrderedMap<String, Ticker> mapTicker) {
        this.mapTicker = mapTicker;
    }

    public List<Ticker> getListTicker(){
        ArrayList<Ticker> list = new ArrayList<>();
        list.addAll(this.getMapTicker().values());
        return list;
    }
}
