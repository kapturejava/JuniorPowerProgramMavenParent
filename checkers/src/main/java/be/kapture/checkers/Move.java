package be.kapture.checkers;

import be.kapture.checkers.enums.Color;

public class Move {
    private Color color;
    private PawnLocation direction;
    private PawnLocation oldPawnLocation;

    public Move(Color color, PawnLocation direction, PawnLocation oldPawnLocation) {
        this.color = color;
        this.direction = direction;
        this.oldPawnLocation = oldPawnLocation;
    }

    public Color getColor() {
        return color;
    }

    public PawnLocation getDirection() {
        return direction;
    }

    public PawnLocation getOldPawnLocation() {
        return oldPawnLocation;
    }

}
