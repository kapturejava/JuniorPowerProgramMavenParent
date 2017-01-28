package be.kapture.checkers;

import static be.kapture.checkers.Color.BLACK;
import static be.kapture.checkers.Color.WHITE;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CheckersBoardTest {
    private CheckersBoard checkersBoard;

    @Before
    public void setup() {
        checkersBoard = new CheckersBoard();
        checkersBoard.addPawns(new PawnLocation(3, 3), BLACK);
        checkersBoard.addPawns(new PawnLocation(3, 3), BLACK);
        checkersBoard.addPawns(new PawnLocation(5, 3), WHITE);
        checkersBoard.addPawns(new PawnLocation(5, 7), WHITE);
        checkersBoard.addPawns(new PawnLocation(7, 7), BLACK);
        checkersBoard.addPawns(new PawnLocation(4, 4), BLACK);
        checkersBoard.addPawns(new PawnLocation(5, 5), WHITE);
    }

    @Test
    public void getManMoves() {
        assertThat(checkersBoard.getManMoves(new PawnLocation(3, 5), WHITE), contains(new PawnLocation(2, 6), new PawnLocation(4, 6)));

        assertThat(checkersBoard.getManMoves(new PawnLocation(3, 5), BLACK), contains(new PawnLocation(2, 4), new PawnLocation(4, 4)));

    }

    @Test
    public void getManMoves_LeftBorder() {
        assertThat(checkersBoard.getManMoves(new PawnLocation(0, 4), WHITE), contains(new PawnLocation(1, 5)));

        assertThat(checkersBoard.getManMoves(new PawnLocation(0, 4), BLACK), contains(new PawnLocation(1, 3)));

    }

    @Test
    public void getManMoves_Right() {
        assertThat(checkersBoard.getManMoves(new PawnLocation(9, 3), WHITE), contains(new PawnLocation(8, 4)));

        assertThat(checkersBoard.getManMoves(new PawnLocation(9, 3), BLACK), contains(new PawnLocation(8, 2)));

    }

    @Test
    public void getManTakes() {
        assertThat(checkersBoard.getManTakes(new PawnLocation(3, 5)),
                contains(new PawnLocation(1, 7), new PawnLocation(5, 7), new PawnLocation(5, 3), new PawnLocation(1, 3)));
    }

    @Test
    public void getManTakes_Upper() {
        assertThat(checkersBoard.getManTakes(new PawnLocation(3, 9)), contains(new PawnLocation(5, 7), new PawnLocation(1, 7)));

        assertThat(checkersBoard.getManTakes(new PawnLocation(2, 8)), contains(new PawnLocation(4, 6), new PawnLocation(0, 6)));

    }

    @Test
    public void getManTakes_Lower() {
        assertThat(checkersBoard.getManTakes(new PawnLocation(2, 0)), contains(new PawnLocation(0, 2), new PawnLocation(4, 2)));

        assertThat(checkersBoard.getManTakes(new PawnLocation(3, 1)), contains(new PawnLocation(1, 3), new PawnLocation(5, 3)));

    }

    @Test
    public void getManTakes_Left() {
        assertThat(checkersBoard.getManTakes(new PawnLocation(0, 4)), contains(new PawnLocation(2, 6), new PawnLocation(2, 2)));

        assertThat(checkersBoard.getManTakes(new PawnLocation(1, 3)), contains(new PawnLocation(3, 5), new PawnLocation(3, 1)));

    }

    @Test
    public void getManTakes_Right() {
        assertThat(checkersBoard.getManTakes(new PawnLocation(9, 3)), contains(new PawnLocation(7, 5), new PawnLocation(7, 1)));

        assertThat(checkersBoard.getManTakes(new PawnLocation(8, 2)), contains(new PawnLocation(6, 4), new PawnLocation(6, 0)));

    }

    @Test
    public void addPawnsToBoardOnValidLocation() {
        assertThat(checkersBoard.getPawns(), contains(new PawnLocation(3, 3), new PawnLocation(5, 7)));

    }

    @Test
    public void movePawnOnCheckersboard() {
        List<PawnLocation> pawnLocations = checkersBoard.getManMoves(checkersBoard.getPawns().get(0), BLACK);
        checkersBoard.replacePawnAtSpecificLocation(checkersBoard.getPawns().get(0));

        assertThat(checkersBoard.getPawns(), contains(new PawnLocation(2, 4), new PawnLocation(5, 7)));
    }

    @Test(expected = NullPointerException.class)
    public void getManTakes_NullLocation() {
        checkersBoard.getManTakes(null);
    }

    @Test(expected = NullPointerException.class)
    public void getMoves_NullLocation() {
        checkersBoard.getManMoves(null, WHITE);
    }

    @Test(expected = NullPointerException.class)
    public void getMoves_NulColor() {
        checkersBoard.getManMoves(new PawnLocation(3, 3), null);
    }

}
