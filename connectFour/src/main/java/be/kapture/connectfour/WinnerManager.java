package be.kapture.connectfour;

import java.util.List;



/**
 * Created by UnnameDSoS on 28/07/2016.
 */
public class WinnerManager {
	public boolean hasWon(Colour colourToWin, List<Colour> colours) {
		int counter = 0;
		for (Colour colour : colours) {
			if (colour == colourToWin) {
				counter++;
			}
		}
		if (counter == 4) return true;
		else return false;
	}
}
