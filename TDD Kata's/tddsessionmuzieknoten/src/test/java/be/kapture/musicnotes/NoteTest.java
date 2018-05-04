package be.kapture.musicnotes;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class NoteTest {

    @Test
    public void Note_Create_Simple() {
        assertThatNullPointerException().isThrownBy(() -> Note.create(null));
        assertThatIllegalArgumentException().isThrownBy(() -> Note.create("")).withMessage("no valid input");
        assertThatIllegalArgumentException().isThrownBy(() -> Note.create("1")).withMessage("no valid input");
        assertThatIllegalArgumentException().isThrownBy(() -> Note.create("C-5")).withMessage("no valid input");
        assertThatIllegalArgumentException().isThrownBy(() -> Note.create("C0")).withMessage("no valid input");

        assertThat(Note.create("C10").getNoteKind()).isEqualTo(NoteKind.C);


        assertThat(Note.create("C").getNoteKind()).isEqualTo(NoteKind.C);
        assertThat(Note.create("D").getNoteKind()).isEqualTo(NoteKind.D);

        assertThat(Note.create("Ces2").getOctaveNr()).isEqualTo(2);
        assertThat(Note.create("Es1").getNoteKind()).isEqualTo(NoteKind.E);
    }

    @Test
    public void Note_Create_Sign() {

        assertThat(Note.create("C").getSign()).isEqualTo(Sign.NATURAL);
        assertThat(Note.create("Cis").getSign()).isEqualTo(Sign.SHARP);
        assertThat(Note.create("Ces").getSign()).isEqualTo(Sign.FLAT);
        assertThat(Note.create("Es").getSign()).isEqualTo(Sign.FLAT);

        assertThatIllegalArgumentException().isThrownBy(() -> Note.create("Cisis"));
    }


    @Test
    public void Note_Create_Octave() {
        assertThat(Note.create("C").getOctaveNr()).isEqualTo(0);

        assertThat(Note.create("C1").getOctaveNr()).isEqualTo(1);
        assertThat(Note.create("C3").getOctaveNr()).isEqualTo(3);

        assertThat(Note.create("c1").getOctaveNr()).isEqualTo(-1);
        assertThat(Note.create("c3").getOctaveNr()).isEqualTo(-3);
    }


    @Test
    public void getIntervalName() {
        assertThat(Note.create("C").getIntervalName(Note.create("C"))).isEqualTo(IntervalName.PRIME);
        assertThat(Note.create("C").getIntervalName(Note.create("D"))).isEqualTo(IntervalName.SECUNDE);
        assertThat(Note.create("C").getIntervalName(Note.create("E"))).isEqualTo(IntervalName.TERTS);
        assertThat(Note.create("C").getIntervalName(Note.create("F"))).isEqualTo(IntervalName.KWART);
        assertThat(Note.create("C").getIntervalName(Note.create("G"))).isEqualTo(IntervalName.KWINT);
        assertThat(Note.create("C").getIntervalName(Note.create("A"))).isEqualTo(IntervalName.SEXT);
        assertThat(Note.create("C").getIntervalName(Note.create("B"))).isEqualTo(IntervalName.SEPTIEM);
        assertThat(Note.create("C").getIntervalName(Note.create("C1"))).isEqualTo(IntervalName.OCTAAF);

        assertThat(Note.create("D").getIntervalName(Note.create("C1"))).isEqualTo(IntervalName.SEPTIEM);
        assertThat(Note.create("C1").getIntervalName(Note.create("D"))).isEqualTo(IntervalName.SEPTIEM);
    }

    @Test
    public void getIntervalName_TooBig() {
        assertThatIllegalArgumentException().isThrownBy(() -> Note.create("C").getIntervalName(Note.create("D1")));
        assertThatIllegalArgumentException().isThrownBy(() -> Note.create("C").getIntervalName(Note.create("C2")));

    }

    @Test
    public void fetchNoteNumber() {
        assertThat(Note.create("c").fetchNoteNumber()).isEqualTo(0);
        assertThat(Note.create("C").fetchNoteNumber()).isEqualTo(0);
        assertThat(Note.create("C5").fetchNoteNumber()).isEqualTo(60);
        assertThat(Note.create("Aes4").fetchNoteNumber()).isEqualTo(56);
        assertThat(Note.create("dis1").fetchNoteNumber()).isEqualTo(-9);
        assertThat(Note.create("fis2").fetchNoteNumber()).isEqualTo(-18);

    }

}