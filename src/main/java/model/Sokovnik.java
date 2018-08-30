package model;

import exception.PremasenKapacitetException;
import org.apache.log4j.Logger;

import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;

import java.util.List;

public class Sokovnik {

	private final static Logger logger = Logger.getLogger(Sokovnik.class);
	private final int KAPACITET_POSUDE_KG = 30;

	private static Sokovnik sokovnik;
	private Posuda posudaZaVoce;
	private Cediljka cediljkaZaVoce;

	private Sokovnik() {
		posudaZaVoce = new Posuda(KAPACITET_POSUDE_KG);
		cediljkaZaVoce = new Cediljka();
	}

	public static Sokovnik getSokovnik() {
		if (sokovnik == null) {
			return new Sokovnik();
		}
		return sokovnik;
	}

	public void cediVoce() {
		if (posudaZaVoce.brojVockiUPosudi() == 0) {
			logger.info("Posuda je prazna");
			return;
		}

		logger.debug("Dodato svo voce iz posude");
		logger.debug("Cedim voce...");

		double dobijenoSoka = cediljkaZaVoce.cediVoce(posudaZaVoce.getVoce());
		posudaZaVoce.setTrenutniKapacitet();
		posudaZaVoce.setVoce();
		logger.info("Dobijeno soka :" + dobijenoSoka);
		
	}

	public void dodajVoce(List<Voce> voce) {
		logger.debug("Dodajem voce...");
		int dodatoVoca = 0;
		for (Voce v : voce) {
			try {
				if (v instanceof Jabuka) {
					Jabuka vj = (Jabuka) v;
					if (vj.isTrula()) {
						logger.warn("Jabuka je trula");
						continue;
					}
				}
				posudaZaVoce.uskladistiVoce(v);
				dodatoVoca++;
			} catch (PremasenKapacitetException e) {
				logger.warn("Premasen kapacitet posude");
				System.exit(1);;
			}
		}
		logger.info("Dodato vocki: " + dodatoVoca);
	}

}
