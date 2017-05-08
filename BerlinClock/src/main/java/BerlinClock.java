/**
 * Created by vanmoj1 on 28/04/2017.
 */
public class BerlinClock {
    public BerlinClock() {
    }

    public String getBottomHours(int i) {
        return getOnOffBottomRow(i);
    }

    private String getOnOffBottomRow(int i) {
        StringBuffer hours = new StringBuffer("OOOO");
        int begin = 0;
        int end = i % 5;

        for (int z = 0; z < end; z++) {
            hours.replace(z, z + 1, "R");
        }

        return hours.toString();
    }

    private String getOnOffTopRow(int i) {
        StringBuffer hours = new StringBuffer("OOOO");
        int begin = 0;
        int end = i / 5;

        for (int z = 0; z < end; z++) {
            hours.replace(z, z + 1, "R");
        }

        return hours.toString();
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

    public String getTopMinutes(int i) {
        StringBuffer minutes = new StringBuffer("OOOOOOOOOOO");
        int begin = 0;
        int end = i / 5;
        int tens = i - i % 5;

        for (int z = 0; z < end; z++) {
            minutes.replace(z, z + 1, "Y");
        }

        if (tens >= 15) {
            minutes.replace(2, 3, "R");
        }
        if (tens >= 30) {
            minutes.replace(5, 6, "R");
        }
        if (tens >= 45) {
            minutes.replace(8, 9, "R");
        }

        return minutes.toString();
    }

}
