package be.kapture.checkers;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static be.kapture.checkers.BoardLocation.MAXIMUM_COORDINATE;
import static be.kapture.checkers.Colour.BLACK;
import static be.kapture.checkers.Colour.WHITE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

/**
 * Created by thiboya on 20/06/2016.
 */
public class CheckersBoardTest {


    private CheckersBoard checkersBoard;

    @Before
    public void setUp() throws Exception {
        checkersBoard = new CheckersBoard(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPawn_NotOnSameColor(){
        checkersBoard.addPawn(new BoardLocation(0, 0), BLACK);
        checkersBoard.addPawn(new BoardLocation(0, 1), BLACK);
    }


    @Test
    public void nrOfPawns(){
        checkersBoard.addPawn(new BoardLocation(0, 0), BLACK);
        checkersBoard.addPawn(new BoardLocation(1, 1), BLACK);

        assertThat(checkersBoard.getNrOfPawns(), is(2));
    }

    @Test
    public void nrOfPawns_TwiceTheSame(){
        checkersBoard.addPawn(new BoardLocation(0, 0), BLACK);
        checkersBoard.addPawn(new BoardLocation(0, 0), BLACK);

        assertThat(checkersBoard.getNrOfPawns(), is(1));
    }

    @Test
    public void canTake(){
        BoardLocation pawnLocation = new BoardLocation(2, 2);
        checkersBoard.addPawn(pawnLocation, BLACK);

        BoardLocation lowerLeft = new BoardLocation(1, 1);
        checkersBoard.addPawn(lowerLeft, WHITE);
        BoardLocation upperRight = new BoardLocation(3, 3);
        checkersBoard.addPawn(upperRight, WHITE);
        BoardLocation lowerRight = new BoardLocation(1, 3);
        checkersBoard.addPawn(lowerRight, WHITE);
        BoardLocation upperLeft = new BoardLocation(3, 1);
        checkersBoard.addPawn(upperLeft, WHITE);

        assertThat(checkersBoard.canTake(BLACK, pawnLocation),
                containsInAnyOrder(lowerLeft, upperRight, lowerRight, upperLeft));
    }

    @Test
    public void canTake_LowerBorder() {
        BoardLocation pawnLocation = new BoardLocation(0, 0);
        checkersBoard.addPawn(pawnLocation, BLACK);

        BoardLocation upperRight = new BoardLocation(1, 1);
        checkersBoard.addPawn(upperRight, WHITE);

        assertThat(checkersBoard.canTake(BLACK, pawnLocation), containsInAnyOrder( upperRight));

    }

    @Test
    public void canTake_UpperBorder() {
        BoardLocation pawnLocation = new BoardLocation(MAXIMUM_COORDINATE, MAXIMUM_COORDINATE);
        checkersBoard.addPawn(pawnLocation, BLACK);

        BoardLocation upperRight = new BoardLocation(MAXIMUM_COORDINATE-1, MAXIMUM_COORDINATE-1);
        checkersBoard.addPawn(upperRight, WHITE);

        assertThat(checkersBoard.canTake(BLACK, pawnLocation), containsInAnyOrder( upperRight));

    }


        @Test
    public void possibleMoves(){

    }

}