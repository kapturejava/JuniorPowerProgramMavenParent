package be.kapture.checkers;

public class PawnLocation {
    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 9;

    private int column, row;

    public PawnLocation(int column, int row) {
        if (row < MINIMUM || row > MAXIMUM) {
            throw new IllegalArgumentException("row not correct:" + row);
        }
        if (column < MINIMUM || column > MAXIMUM) {
            throw new IllegalArgumentException("column not correct:" + column);
        }
        if ((column + row) % 2 == 1) {
            throw new IllegalArgumentException("wrong location: " + column + "," + row);
        }
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isOnLeftBorder() {
        return column == MINIMUM;
    }

    public boolean isOnRighttBorder() {
        return column == MAXIMUM;
    }

    public boolean isOnLeftBorderTakes() {
        return column < 2;
    }

    public boolean isOnRighttBorderTakes() {
        return column > 7;
    }

    public boolean isOnLowerBorderTakes() {
        return row < 2;
    }

    public boolean isOnUpperBorderTakes() {
        return row > 7;
    }

    @Override
    public String toString() {
        return "PawnLocation [column=" + column + ", row=" + row + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
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
        PawnLocation other = (PawnLocation) obj;
        if (column != other.column)
            return false;
        if (row != other.row)
            return false;
        return true;
    }

}
