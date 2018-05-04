package be.kapture.musicnotes;

public enum NoteKind {
   C(0), D(2), E(4), F(5), G(7), A(9), B(11);

   private int noteNumber;

    NoteKind(int noteNumber) {
        this.noteNumber = noteNumber;
    }

    public int getNoteNumber() {
        return noteNumber;
    }
}
