package behaviour;

import exception.PremasenKapacitetException;
import model.Voce;

public interface SkladistenjeVoca {

	int uskladistiVoce(Voce voce) throws PremasenKapacitetException;

	int brojVockiUPosudi();

}
