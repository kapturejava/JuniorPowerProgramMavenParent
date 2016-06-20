package be.kapture.checkers;

/**
 * Created by thiboya on 20/06/2016.
 */
public enum Colour {
    BLACK, WHITE;

    public Colour changeColour(){
        if(this == BLACK){
            return WHITE;
        } else {
            return BLACK;
        }
    }
}
