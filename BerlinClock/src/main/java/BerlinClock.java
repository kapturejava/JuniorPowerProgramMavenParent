/**
 * Created by vanmoj1 on 28/04/2017.
 */
public class BerlinClock {
    public BerlinClock() {
    }

    public String getBottomHours(int i) {
        i = i % 10;

        if (i == 1) {
            return "ROOO";
        } else if (i == 2) {
            return "RROO";
        } else if (i == 3) {
            return "RRRO";
        } else if (i == 4) {
            return "RRRR";
        }
        return "OOOO";
    }

    private String getOnOffTopRow(int i) {
        if (i <= 10) {
            if (i == 0) {
                return "OOOO";
            }
            return "ROOO";
        } else if (10 < i && i <= 15) {
            return "RROO";
        } else if (15 < i && i <= 20) {
            return "RRRO";
        } else {
            return "RRRR";
        }
    }

    public String getSeconds(int number) {
        if (number % 2 == 0)
            return "Y";
        else
            return "O";
    }

    public String getTopHours(int i) {
        return getOnOffTopRow(i);
    }
}
