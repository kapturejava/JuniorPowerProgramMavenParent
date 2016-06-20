package be.kapture.checkers;

import org.junit.Test;

import static be.kapture.checkers.BoardLocation.MAXIMUM_COORDINATE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by thiboya on 20/06/2016.
 */
public class BoardLocationTest {


    @Test(expected = IllegalArgumentException.class)
    public void create_XTooLow(){
        new BoardLocation(-1,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_YTooLow(){
        new BoardLocation(0,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_XTooHigh(){
        new BoardLocation(MAXIMUM_COORDINATE+1,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_YTooHigh(){
        new BoardLocation(0,MAXIMUM_COORDINATE+1);
    }


    @Test
    public void create(){

        BoardLocation boardLocation = new BoardLocation(0, 7);
        assertThat(boardLocation.getX(), is(0));
        assertThat(boardLocation.getY(), is(7));
    }
}