package ar.com.ninjacryptocurrencies.bean;

import java.io.Serializable;

/**
 * Taller NinjaBean
 */
public class TallerNinjaBean implements Serializable{
    private String documento;
    private Boolean comprarBitcoin;
    private Boolean comprarEthereum;

    public TallerNinjaBean(){
        super();
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Boolean getComprarBitcoin() {
        return comprarBitcoin;
    }

    public void setComprarBitcoin(Boolean comprarBitcoin) {
        this.comprarBitcoin = comprarBitcoin;
    }

    public Boolean getComprarEthereum() {
        return comprarEthereum;
    }

    public void setComprarEthereum(Boolean comprarEthereum) {
        this.comprarEthereum = comprarEthereum;
    }

    @Override
    public String toString() {
        return "DOCUMENTO: " + documento + " - Compra BTC: " + this.comprarBitcoin + " - Compra ETH: " + this.comprarEthereum;
    }
}
