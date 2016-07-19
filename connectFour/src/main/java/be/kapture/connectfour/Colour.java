package be.kapture.connectfour;

/**
 * Created by UnnameDSoS on 14/07/2016.
 */
public enum Colour {
	RED, YELLOW;

     Colour other(){
         if (this != RED){
             return RED;
         }
         return YELLOW;
     }
}
