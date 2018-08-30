package model;

import java.util.Random;

public class Jabuka extends Voce {
	private String naziv = "Jabuka";
	private String sorta;
	private final double PROCENAT_TRULOSTI = 0.2;
	private boolean trula = new Random().nextDouble() <= PROCENAT_TRULOSTI;
	
	public Jabuka(int tezina, String sorta) {
		super(tezina);
		this.sorta = sorta;
	}

	@Override
	public void setNaziv(String naziv) {
		super.setNaziv(naziv);
	}
	
	@Override
	public void setTrula(boolean trula) {
		super.setTrula(trula);
	}
	
	public boolean isTrula() {
		return this.trula;
	}
}
