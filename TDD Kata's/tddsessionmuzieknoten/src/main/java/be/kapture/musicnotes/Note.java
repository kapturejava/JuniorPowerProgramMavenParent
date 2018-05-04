package be.kapture.musicnotes;

import java.util.Comparator;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isAllLowerCase;

public class Note implements Comparable<Note>{
    private NoteKind noteKind;
    private Sign sign;
    private int octaveNr;

    private Note(NoteKind noteKind, Sign sign, int octaveNr) {
        this.noteKind = noteKind;
        this.sign = sign;
        this.octaveNr = octaveNr;
    }

    public static Note create(String note) {
        Objects.requireNonNull(note);
        if (!note.matches("[a-gA-G](is|es)?([1-9](\\d)*)?")) {
            if (!note.toLowerCase().contains("es")) {
                throw new IllegalArgumentException("no valid input");
            }
        }

        NoteKind noteKind1 = NoteKind.valueOf(note.substring(0,1).toUpperCase());
        Sign sign1 = calculateSign(note);
        int octaveNr1 = calculateOctaveNr(note, note.substring(0, 1), note.substring(note.length() - 1));

        return new Note(noteKind1, sign1, octaveNr1);
    }

    private static int calculateOctaveNr(String note, String noteKindString, String octaveNr) {
        if (note.substring(note.length()-1).matches("\\d")) {
            if (isAllLowerCase(noteKindString)) {
                return Integer.parseInt(octaveNr) * -1;
            } else {
                return Integer.parseInt(octaveNr);
            }
        } else {
            return 0;
        }
    }

    private static Sign calculateSign(String note) {
        if (note.contains("is")) {
            return Sign.SHARP;
        }
        if (note.contains("es") || note.contains("Es")) {
            return Sign.FLAT;
        }
        return Sign.NATURAL;
    }

    public NoteKind getNoteKind() {
        return noteKind;
    }

    public Sign getSign() {
        return sign;
    }

    public int getOctaveNr() {
        return octaveNr;
    }

    public IntervalName getIntervalName(Note otherNote) {
        if (this.compareTo(otherNote)>0){
            return otherNote.getIntervalNameOrdered(this);
        }
        return getIntervalNameOrdered(otherNote);
    }

    public int fetchNoteNumber() {
        int result = 0;
        result += this.getNoteKind().getNoteNumber();
        if (this.getSign() == Sign.SHARP) {result += 1;}
        if (this.getSign() == Sign.FLAT) {result += -1;}
        result += this.getOctaveNr() * 12;

        return result;
    }

    private IntervalName getIntervalNameOrdered(Note biggestNote) {
        assertValidDistance(biggestNote.getOctaveNr(), biggestNote.getNoteKind());

        if (biggestNote.getOctaveNr() == this.getOctaveNr() ) {
            return IntervalName.getIntervalName(biggestNote.getNoteKind().ordinal() - this.getNoteKind().ordinal());
        }
        if (biggestNote.getNoteKind() == this.getNoteKind()) {
            return IntervalName.OCTAAF;
        }
        return IntervalName.getIntervalName(biggestNote.getNoteKind().ordinal() + 7 - getNoteKind().ordinal());
    }

    private void assertValidDistance(int octaveNr, NoteKind noteKind) {
        if (octaveNr > this.getOctaveNr()+1) {
            throw new IllegalArgumentException();
        }
        if (octaveNr == this.getOctaveNr()+1 && noteKind.ordinal() > this.getNoteKind().ordinal()) {
             throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(Note o) {
        return Comparator.comparing(Note::getOctaveNr)
                .thenComparing(Note::getNoteKind)
                .thenComparing(Note::getSign)
                .compare(this, o);
    }
}
