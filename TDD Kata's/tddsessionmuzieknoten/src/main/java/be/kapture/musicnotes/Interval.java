package be.kapture.musicnotes;

public class Interval {

    private Note note1;
    private Note note2;

    private Interval(Note note1, Note note2) {
        this.note1 = note1;
        this.note2 = note2;
    }

    public static Interval create(Note note1, Note note2) {
        if (note1.compareTo(note2) > 0) {
            return new Interval(note2, note1);
        }
        return new Interval(note1, note2);
    }

    public String getIntervalKindAndName() {
        if (this.getIntervalKind() == IntervalKind.VERGROOT) {
            return "VERGROTE " + this.getIntervalName().toString();
        }
        return this.getIntervalKind().toString() + "E " + this.getIntervalName().toString();
    }

    public IntervalName getIntervalName() {
        return note1.getIntervalName(note2);
    }

    public IntervalKind getIntervalKind() {
        int diff = note2.fetchNoteNumber() - note1.fetchNoteNumber();

        if (this.getIntervalName() == IntervalName.OCTAAF ||
                this.getIntervalName() == IntervalName.KWART ||
                this.getIntervalName() == IntervalName.KWINT ||
                this.getIntervalName() == IntervalName.PRIME) {
            int rein = 0;
            switch (this.getIntervalName()) {
                case PRIME:
                    rein = 0;
                    break;
                case KWART:
                    rein = 5;
                    break;
                case KWINT:
                    rein = 7;
                    break;
                case OCTAAF:
                    rein = 12;
                    break;
            }
            if (diff <= rein + 1 && diff >= rein - 1) {
                if (diff == rein) {
                    return IntervalKind.REIN;
                }
                if (diff == rein - 1) {
                    return IntervalKind.VERKLEIND;
                }
                if (diff == rein + 1) {
                    return IntervalKind.VERGROOT;
                }
            }
            throw new IllegalArgumentException("no interval in range");
        }

        int klein = 0;
        if (this.getIntervalName() == IntervalName.SECUNDE) {
            klein = 1;
        }
        if (this.getIntervalName() == IntervalName.TERTS) {
            klein = 3;
        }
        if (this.getIntervalName() == IntervalName.SEXT) {
            klein = 8;
        }
        if (this.getIntervalName() == IntervalName.SEPTIEM) {
            klein = 10;
        }

        if (diff <= klein + 2 && diff >= klein - 1) {
            if (diff == klein) {
                return IntervalKind.KLEIN;
            }
            if (diff == klein + 1) {
                return IntervalKind.GROOT;
            }
            if (diff == klein - 1) {
                return IntervalKind.VERKLEIND;
            }
            if (diff == klein + 2) {
                return IntervalKind.VERGROOT;
            }
        }
        throw new IllegalArgumentException("no interval in range");
    }
}
