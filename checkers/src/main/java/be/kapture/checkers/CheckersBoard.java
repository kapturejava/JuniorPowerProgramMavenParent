package be.kapture.checkers;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

public class CheckersBoard {

    List<PawnLocation> pawns;

    public CheckersBoard() {
        pawns = new ArrayList<PawnLocation>();
    }

    public List<PawnLocation> getManMoves(PawnLocation location, Color color) {
        // requireNonNull(location);
        requireNonNull(color);

        List<PawnLocation> pawnLocations = new ArrayList<PawnLocation>();
        int nextRow = getNextOrPreviousRowNr(location.getRow(), color);

        if (!location.isOnLeftBorder()) {
            pawnLocations.add(new PawnLocation(location.getColumn() - 1, nextRow));
        }
        if (!location.isOnRighttBorder()) {
            pawnLocations.add(new PawnLocation(location.getColumn() + 1, nextRow));
        }

        return pawnLocations;
    }

    /**
     * 
     * @param pawns
     */
    public void addPawns(PawnLocation pawn) {
        if (pawn.getRow() != 4 && pawn.getRow() != 5) {
            if (!pawns.contains(pawn)) {
                pawns.add(pawn);
            }
        }
    }

    public List<PawnLocation> getPawns() {
        return pawns;
    }

    /**
     * 
     * @param location
     * @return
     */
    public List<PawnLocation> getManMoves(PawnLocation location) {
        throw new UnsupportedOperationException();
    }

    private int getNextOrPreviousRowNr(int rowNr, Color color) {
        if (color == Color.BLACK) {
            return rowNr - 1;
        } else {
            return rowNr + 1;
        }

    }

    public List<PawnLocation> getManTakes(PawnLocation pawnLocation) {
        requireNonNull(pawnLocation);

        List<PawnLocation> pawnLocations = new ArrayList<PawnLocation>();

        if (!pawnLocation.isOnUpperBorderTakes()) {
            if (!pawnLocation.isOnLeftBorderTakes()) {
                pawnLocations.add(new PawnLocation(pawnLocation.getColumn() - 2, pawnLocation.getRow() + 2));
            }
            if (!pawnLocation.isOnRighttBorderTakes()) {
                pawnLocations.add(new PawnLocation(pawnLocation.getColumn() + 2, pawnLocation.getRow() + 2));
            }
        }
        if (!pawnLocation.isOnLowerBorderTakes()) {
            if (!pawnLocation.isOnRighttBorderTakes()) {
                pawnLocations.add(new PawnLocation(pawnLocation.getColumn() + 2, pawnLocation.getRow() - 2));
            }
            if (!pawnLocation.isOnLeftBorderTakes()) {
                pawnLocations.add(new PawnLocation(pawnLocation.getColumn() - 2, pawnLocation.getRow() - 2));
            }
        }

        return pawnLocations;
    }

}
