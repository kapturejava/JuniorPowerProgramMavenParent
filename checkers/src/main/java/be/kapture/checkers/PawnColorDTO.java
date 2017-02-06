package be.kapture.checkers;

import be.kapture.checkers.enums.Color;

import java.util.List;

/**
 * Created by peeteth on 3/02/2017.
 */
public class PawnColorDTO {

    private Color color;
    private List<PawnLocation> pawnLocations;
    // private List<PawnMoveHistory> pawnMoveHistoryList;

    // @SuppressWarnings
    private PawnColorDTO() {
    } // private default constructor

    /**
     * Stel! We willen ook een List<PawnMoveHistory> aan deze kleur associëren:
     * Ofwel maak je een nieuwe Map<Color,List<PawnMoveHistory>>
     * of
     * Je voegt aan deze DTO een List<PawnMoveHistory> class variable toe en je breidt deze constructor daarmee uit
     * 
     * @param color
     * @param pawnLocations
     */
    public PawnColorDTO(Color color, List<PawnLocation> pawnLocations/* ,List<PawnMoveHistory> historyList */) {
        this.color = color;
        this.pawnLocations = pawnLocations;
    }

    public void addPawnLocation(PawnLocation location) {
        pawnLocations.add(location);
    }

    public Color getColor() {
        return color;
    }

    public List<PawnLocation> getPawnLocations() {
        return pawnLocations;
    }

    // public void setColor(Color color) {
    // this.color = color;
    // }

    // public void setPawnLocations(List<PawnLocation> pawnLocations) {
    // this.pawnLocations = pawnLocations;
    // }
}
