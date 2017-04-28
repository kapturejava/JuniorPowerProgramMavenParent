/**
 * Created by vanmoj1 on 28/04/2017.
 */
public class BerlinClock {
    public BerlinClock() {
    }

    public String getSeconds(int number) {
        if (number % 2 == 0) return "Y";
        else return "O";
    }
}
