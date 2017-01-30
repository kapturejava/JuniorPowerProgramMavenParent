package be.kapture.checkers;

public class Move {
    private PawnLocation up;
    private PawnLocation down;
    private PawnLocation left;
    private PawnLocation right;

    public PawnLocation getUp() {
        return up;
    }

    public void setUp(PawnLocation up) {
        this.up = up;
    }

    public PawnLocation getDown() {
        return down;
    }

    public void setDown(PawnLocation down) {
        this.down = down;
    }

    public PawnLocation getLeft() {
        return left;
    }

    public void setLeft(PawnLocation left) {
        this.left = left;
    }

    public PawnLocation getRight() {
        return right;
    }

    public void setRight(PawnLocation right) {
        this.right = right;
    }

}
