package be.kapture.checkers;

import static be.kapture.checkers.enums.Color.BLACK;
import static be.kapture.checkers.enums.Color.WHITE;
import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.kapture.checkers.CustomExceptions.*;
import be.kapture.checkers.enums.Color;

public class CheckersBoard {

    List<PawnLocation> pawnLocationsBlack;
    List<PawnLocation> pawnLocationsWhite;
    Map<Color, List<PawnLocation>> pawns;

    public CheckersBoard() {
        pawnLocationsBlack = new ArrayList<PawnLocation>();
        pawnLocationsWhite = new ArrayList<PawnLocation>();
        pawns = new HashMap<Color, List<PawnLocation>>();
    }

    /**
     * 
     * @param color
     * @param pawns
     */
    public void addPawns(PawnLocation pawn, Color color) throws LocationOccupiedException {
        try {
            if (isLocationValidToAddPawn(pawn, color)) {
                if (color == BLACK) {
                    pawnLocationsBlack.add(pawn);
                    pawns.put(color, pawnLocationsBlack);
                } else if (color == WHITE) {
                    pawnLocationsWhite.add(pawn);
                    pawns.put(WHITE, pawnLocationsWhite);
                }
            }
        } catch (LocationOccupiedException ex) {
            throw ex;
        }
    }

    private boolean isLocationValidToAddPawn(PawnLocation pawn, Color color) throws LocationOccupiedException {
        if (!isLocationOccupied(pawn, color)) {
            if (color == BLACK && pawn.getRow() > 5) {
                return true;
            } else if (color == WHITE && pawn.getRow() < 4) {
                {
                    return true;
                }
            }
        } else {
            throw new LocationOccupiedException("Location is occupied");
        }

        return false;
    }

    private boolean isLocationOccupied(PawnLocation pawnLocation, Color color) {
        List<PawnLocation> pawnList = null;
        if (color == BLACK) {
            pawnList = pawns.get(BLACK);
        } else if (color == WHITE) {
            pawnList = pawns.get(WHITE);
        }
        if (pawnList != null) {
            for (PawnLocation location : pawnList) {
                if (location.equals(pawnLocation)) {
                    return true;
                }
            }
        }
        return false;
    }

    // public void replacePawnAtSpecificLocation(PawnLocation pawnLocation, PawnLocation pawnLocation2) {
    // for (int index = 0; index < pawns.size(); index++) {
    // if (pawns.get(index) == pawnLocation) {
    // if (!isLocationOccupied(pawnLocation2)) {
    // pawns.set(index, pawnLocation2);
    // }
    // }
    // }
    //
    // }

    public Map<Color, List<PawnLocation>> getPawns() {
        return pawns;
    }

    // public List<PawnLocation> getPawns() {
    // return pawns;
    // }

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

    public void clearBoard() {
        pawns.clear();

    }

}
