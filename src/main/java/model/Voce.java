package model;

public abstract class Voce {
    private String naziv;
    private int tezina;
    private boolean trula;

    public Voce(int tezina) {
        this.tezina = tezina; 
    }
    
    public void setTrula(boolean trula) {
    	this.trula = trula;
    }
    public void setNaziv(String naziv) {
    	this.naziv = naziv;
    }
    

	public String getNaziv() {
        return naziv;
    }

    public int getTezina() {
        return tezina;
    }
}
