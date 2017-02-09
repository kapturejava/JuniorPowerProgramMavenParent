package be.kapture.checkers;

import java.util.List;

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

    public boolean existsInMovesList(List<PawnLocation> moves) {
        for (PawnLocation move : moves) {
            if (direction.equals(move)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((direction == null) ? 0 : direction.hashCode());
        result = prime * result + ((oldPawnLocation == null) ? 0 : oldPawnLocation.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Move other = (Move) obj;
        if (color != other.color)
            return false;
        if (direction == null) {
            if (other.direction != null)
                return false;
        } else if (!direction.equals(other.direction))
            return false;
        if (oldPawnLocation == null) {
            if (other.oldPawnLocation != null)
                return false;
        } else if (!oldPawnLocation.equals(other.oldPawnLocation))
            return false;
        return true;
    }

}
