package model;

import behaviour.Cedjenje;

import java.util.List;

public class Cediljka implements Cedjenje {

	@Override
	public double cediVoce(List<Voce> voce) {
		double dobijenoSoka = 0;

		for (Voce v : voce) {
			dobijenoSoka += v.getTezina() * 0.4;
		}

		return dobijenoSoka;
	}
}
