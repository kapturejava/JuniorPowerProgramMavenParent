package be.kapture.checkers;

import static be.kapture.checkers.enums.Color.BLACK;
import static be.kapture.checkers.enums.Color.WHITE;
import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import be.kapture.checkers.CustomExceptions.LocationOccupiedException;
import be.kapture.checkers.enums.Color;

public class CheckersBoard {

    private PawnColorDTO blackPawns;
    private PawnColorDTO whitePawns;

    public CheckersBoard() {
        blackPawns = new PawnColorDTO(BLACK, new ArrayList<PawnLocation>());
        whitePawns = new PawnColorDTO(WHITE, new ArrayList<PawnLocation>());
    }

    /**
     * 
     * @param color
     * @param pawns
     */
    public void addPawns(PawnLocation pawn, Color color) {
        try {
            if (isLocationValidToAddPawn(pawn, color)) {
                if (color == BLACK) {
                    blackPawns.addPawnLocation(pawn);
                } else if (color == WHITE) {
                    whitePawns.addPawnLocation(pawn);
                }
            }
        } catch (LocationOccupiedException ex) {
            throw ex;
        }
    }

    private boolean isLocationValidToAddPawn(PawnLocation pawn, Color color) {
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
        List<PawnLocation> pawnLocations = null;
        if (color == BLACK) {
            pawnLocations = blackPawns.getPawnLocations();
        } else if (color == WHITE) {
            pawnLocations = whitePawns.getPawnLocations();
        }
        if (pawnLocations != null) {
            for (PawnLocation location : pawnLocations) {
                if (location.equals(pawnLocation)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param location
     * @return
     */
    public List<PawnLocation> getManMoves(PawnLocation location, Color color) {
        requireNonNull(location);
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

    public void movePawn(Move move) {
        List<PawnLocation> moves = getManMoves(move.getOldPawnLocation(), move.getColor());

    }

    public List<PawnLocation> getPawnsByColor(Color color) {
        if (color == BLACK) {
            return blackPawns.getPawnLocations();
        }
        return whitePawns.getPawnLocations();
    }

}
