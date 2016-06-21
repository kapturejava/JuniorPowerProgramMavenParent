package be.kapture.checkers;

import java.util.*;

import static be.kapture.checkers.Colour.BLACK;
import static be.kapture.checkers.Colour.WHITE;

/**
 * Created by thiboya on 20/06/2016.
 */
public class CheckersBoard {

    private boolean workingColourBlack = true;
    private final Map<Colour, Set<BoardLocation>> boardLocationsMap;

    public CheckersBoard(boolean workingColourBlack) {
        this.workingColourBlack = workingColourBlack;

        boardLocationsMap = new TreeMap<>();
        boardLocationsMap.put(BLACK, new HashSet<>());
        boardLocationsMap.put(WHITE, new HashSet<>());
    }

    public void addPawn(BoardLocation boardLocation, Colour colour) {
        if (boardLocation.isOnColorBlack() != workingColourBlack) {
            throw new IllegalArgumentException();
        }
        boardLocationsMap.get(colour).add(boardLocation);
    }

    public List<BoardLocation> canTake(Colour colour, BoardLocation boardLocation) {

        List<BoardLocation> possibleTakes = new ArrayList<>();
        List<BoardLocation> diagonalNeighbouringLocations = boardLocation.getDiagonalNeighbouringLocations();
        Set<BoardLocation> enemyBoardLocations = boardLocationsMap.get(colour.changeColour());

        for (BoardLocation diagonalNeighbouringLocation : diagonalNeighbouringLocations) {
            addIfEnemyPawnPresent(enemyBoardLocations, possibleTakes, diagonalNeighbouringLocation);
        }
        /*addIfEnemyPawnPresent(enemyBoardLocations, possibleTakes, new BoardLocation(boardLocation.getX() - 1, boardLocation.getY() - 1));
        addIfEnemyPawnPresent(enemyBoardLocations, possibleTakes, new BoardLocation(boardLocation.getX() - 1, boardLocation.getY() + 1));
        addIfEnemyPawnPresent(enemyBoardLocations, possibleTakes, new BoardLocation(boardLocation.getX() + 1, boardLocation.getY() - 1));
        addIfEnemyPawnPresent(enemyBoardLocations, possibleTakes, new BoardLocation(boardLocation.getX() + 1, boardLocation.getY() + 1));*/

        return possibleTakes;
    }

    public int getNrOfPawns() {//TODO
        return boardLocationsMap.get(BLACK).size() + boardLocationsMap.get(WHITE).size();
    }

    private void addIfEnemyPawnPresent(Set<BoardLocation> colourBoardLocations, List<BoardLocation> possibleTakes, BoardLocation testedLocation) {
        if (colourBoardLocations.contains(testedLocation)) {
            possibleTakes.add(testedLocation);
        }
    }
}
