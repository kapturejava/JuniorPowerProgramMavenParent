package be.kapture.checkers;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PawnLocationTest {
	
	@Test(expected= IllegalArgumentException.class)
	public void create_XTooLow(){
		new PawnLocation(-1, 1);
	}
	
	
	@Test(expected= IllegalArgumentException.class)
	public void create_XTooHigh(){
		new PawnLocation(10, 0);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void create_YTooLow(){
		new PawnLocation(1, -1);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void create_YTooHigh(){
		new PawnLocation(0, 10);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void create_WrongBoardLocation(){
		new PawnLocation(0, 1);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void create_WrongBoardLocation1(){
		new PawnLocation(3, 4);
	}
	
	@Test
	public void isOnLeftBorder(){
		assertThat(new PawnLocation(0, 4).isOnLeftBorder(), is(true));
		assertThat(new PawnLocation(2, 4).isOnLeftBorder(), is(false));
	}
	
	@Test
	public void isOnRightBorder(){
		assertThat(new PawnLocation(9, 3).isOnRighttBorder(), is(true));
		assertThat(new PawnLocation(5, 3).isOnRighttBorder(), is(false));

	}


	
	


}
