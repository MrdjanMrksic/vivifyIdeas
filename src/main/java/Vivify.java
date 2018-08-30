import model.Jabuka;
import java.util.Random;
import model.Sokovnik;
import model.Voce;
import java.util.Arrays;
import java.util.List;

public class Vivify {
    public static void main (String args[]) {
        Sokovnik sokovnik = Sokovnik.getSokovnik();
        final double PROCENAT_DODAVANJA = 0.7;
        List<Voce> raznoVoce = null;
        
        for (int i = 1; i <= 100; i++) {
        	boolean dodavanje = new Random().nextDouble() <= PROCENAT_DODAVANJA;
        	if (dodavanje) {
        		raznoVoce = Arrays.asList(new Jabuka(1, "Green Smith"),
                        				  new Jabuka(2, "Ajdared"),
                        				  new Jabuka(3, "Ajdared"));
        		sokovnik.dodajVoce(raznoVoce);
        	} else {
                sokovnik.cediVoce();
        	}
        }
        
    }
}
