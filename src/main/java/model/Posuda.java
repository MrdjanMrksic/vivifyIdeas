package model;

import behaviour.SkladistenjeVoca;
import exception.PremasenKapacitetException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Posuda implements SkladistenjeVoca {
	private final static Logger logger = Logger.getLogger(Posuda.class);

	private int trenutniKapacitet;
	private int kapacitet;

	private List<Voce> voce;

	public Posuda(int kapacitet) {
		this.kapacitet = kapacitet;
		trenutniKapacitet = 0;
		voce = new ArrayList<>();
	}

	@Override
	public int uskladistiVoce(Voce vocka) throws PremasenKapacitetException {
		
		if (trenutniKapacitet + vocka.getTezina() > kapacitet) {
			logger.warn("Nema dovoljno mesta u posudi");
			throw new PremasenKapacitetException();
		} else {
		voce.add(vocka);
		trenutniKapacitet += vocka.getTezina();
		logger.debug("Trenutni kapacitet je " + trenutniKapacitet);
		}
		
		
		return trenutniKapacitet;
	}

	@Override
	public int brojVockiUPosudi() {
		return voce.size();
	}

	public List<Voce> getVoce() {
		return voce;
	}
	
	public void setVoce() {
		voce.clear();
	}
	public void setTrenutniKapacitet() {
		this.trenutniKapacitet = 0;
	}

}
