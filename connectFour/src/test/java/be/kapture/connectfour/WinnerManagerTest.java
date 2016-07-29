package be.kapture.connectfour;

import org.junit.Test;

import static be.kapture.connectfour.Colour.RED;
import static be.kapture.connectfour.Colour.YELLOW;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by UnnameDSoS on 28/07/2016.
 */
public class WinnerManagerTest {
	@Test
	public void hasWon_4Consecutive(){
		WinnerManager winnerManager = new WinnerManager();

		assertThat(winnerManager.hasWon(RED, asList(RED,RED, RED,RED)), is(true));
		assertThat(winnerManager.hasWon(YELLOW, asList(RED,RED, RED,RED)), is(false));
	}

	@Test
	public void hasWon_Discontinued(){
		WinnerManager winnerManager = new WinnerManager();

		assertThat(winnerManager.hasWon(RED, asList(RED,RED, YELLOW,RED, RED)), is(false));
	}

	@Test
	public void hasWon_InCorrectStart(){
		WinnerManager winnerManager = new WinnerManager();

		assertThat(winnerManager.hasWon(RED, asList(YELLOW, RED,RED, RED,RED, YELLOW)), is(true));
		assertThat(winnerManager.hasWon(RED, asList(YELLOW, RED,RED, RED, YELLOW)), is(false));
	}


}