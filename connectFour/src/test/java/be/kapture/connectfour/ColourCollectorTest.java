package be.kapture.connectfour;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.rowset.internal.Row;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static be.kapture.connectfour.Colour.RED;
import static be.kapture.connectfour.Colour.YELLOW;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by UnnameDSoS on 28/07/2016.
 */
public class ColourCollectorTest {

	private GameBoard gameBoard;
	private ColourCollector colourCollector;

	@Before
	public void setup(){
		gameBoard = mock(GameBoard.class);
		colourCollector = new ColourCollector(gameBoard);
	}

	@Test
	public void getRow(){
		List<Colour> colours = asList(RED, YELLOW, RED, RED, YELLOW, RED, RED);
		for (int column=0; column< 7; column++){
			when(gameBoard.getColour(column, 3)).thenReturn(colours.get(column));
		}

		assertThat(colourCollector.getRow(3), is(colours));
	}

	@Test
	public void getColumn(){
		List<Colour> colours = asList(RED, YELLOW, RED, RED, YELLOW, RED);
		for (int row=0; row< 6; row++){
			when(gameBoard.getColour(4,row)).thenReturn(colours.get(row));
		}

		assertThat(colourCollector.getColumn(4), is(colours));
	}

	@Test
	public void getDiagonal0(){
		List<Colour> colours = asList(RED, YELLOW, RED, RED, YELLOW, RED);
		for (int index=0; index< 6; index++){
			when(gameBoard.getColour(index,index)).thenReturn(colours.get(index));
		}
		assertThat(colourCollector.getDiagonalToUpperRight(0), is(colours));
	}

	@Test
	public void getDiagonal_Minus2(){
		List<Colour> colours = asList(RED, YELLOW, RED, RED);
		for (int index=0; index< 6-2; index++){
			when(gameBoard.getColour(index,index+2)).thenReturn(colours.get(index));
		}
		assertThat(colourCollector.getDiagonalToUpperRight(-2), is(colours));
	}

	@Test
	public void getDiagonal_Plus2(){
		List<Colour> colours = asList(RED, YELLOW, RED, RED, YELLOW);
		for (int index=0; index< 6-2+1; index++){
			when(gameBoard.getColour(index+2,index)).thenReturn(colours.get(index));
		}
		assertThat(colourCollector.getDiagonalToUpperRight(2), is(colours));
	}



}