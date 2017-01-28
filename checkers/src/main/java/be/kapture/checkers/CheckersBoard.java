package be.kapture.checkers;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

public class CheckersBoard {

    List<PawnLocation> pawns;

    public CheckersBoard() {
        pawns = new ArrayList<PawnLocation>();
    }

    /**
     * 
     * @param color
     * @param pawns
     */
    public void addPawns(PawnLocation pawn, Color color) {
        if (isLocationValidToAddPawn(pawn, color)) {
            pawns.add(pawn);
        }
    }

    private boolean isLocationValidToAddPawn(PawnLocation pawn, Color color) {
        if (!pawns.contains(pawn)) {
            if (color == Color.BLACK && pawn.getRow() < 4) {
                return true;
            } else if (color == Color.WHITE && pawn.getRow() > 5) {
                {
                    return true;
                }
            }
        }

        return false;
    }

    public void replacePawnAtSpecificLocation(PawnLocation pawnLocation) {
        // TODO Auto-generated method stub

    }

    public List<PawnLocation> getPawns() {
        return pawns;
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
