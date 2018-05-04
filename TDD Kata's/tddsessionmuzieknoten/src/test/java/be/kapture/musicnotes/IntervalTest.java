package be.kapture.musicnotes;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class IntervalTest {

    public static final Note C = Note.create("C");

    @Test
    public void getIntervalName() {
        assertThat(Interval.create(C, Note.create("E")).getIntervalName()).isEqualTo(IntervalName.TERTS);
        assertThat(Interval.create(C, Note.create("F")).getIntervalName()).isEqualTo(IntervalName.KWART);
    }

    @Test
    public void getIntervalKind_Natuurlijk_Rein() {

        assertThat(Interval.create(C, Note.create("C1")).getIntervalKind()).isEqualTo(IntervalKind.REIN);
        assertThat(Interval.create(C, Note.create("Ces1")).getIntervalKind()).isEqualTo(IntervalKind.VERKLEIND);
        assertThat(Interval.create(C, Note.create("Cis1")).getIntervalKind()).isEqualTo(IntervalKind.VERGROOT);
        assertThat(Interval.create(Note.create("Cis"), Note.create("C1")).getIntervalKind()).isEqualTo(IntervalKind.VERKLEIND);
        assertThat(Interval.create(Note.create("Cis"), Note.create("Cis1")).getIntervalKind()).isEqualTo(IntervalKind.REIN);

        assertThat(Interval.create(C, Note.create("C")).getIntervalKind()).isEqualTo(IntervalKind.REIN);
        assertThat(Interval.create(C, Note.create("Ces")).getIntervalKind()).isEqualTo(IntervalKind.VERGROOT);
        assertThat(Interval.create(C, Note.create("Cis")).getIntervalKind()).isEqualTo(IntervalKind.VERGROOT);

        assertThat(Interval.create(C, Note.create("F")).getIntervalKind()).isEqualTo(IntervalKind.REIN);
        assertThat(Interval.create(C, Note.create("Fes")).getIntervalKind()).isEqualTo(IntervalKind.VERKLEIND);
        assertThat(Interval.create(C, Note.create("Fis")).getIntervalKind()).isEqualTo(IntervalKind.VERGROOT);
        assertThat(Interval.create(Note.create("Cis"), Note.create("F")).getIntervalKind()).isEqualTo(IntervalKind.VERKLEIND);
        assertThat(Interval.create(Note.create("Cis"), Note.create("Fis")).getIntervalKind()).isEqualTo(IntervalKind.REIN);

        assertThat(Interval.create(C, Note.create("G")).getIntervalKind()).isEqualTo(IntervalKind.REIN);
        assertThat(Interval.create(C, Note.create("Ges")).getIntervalKind()).isEqualTo(IntervalKind.VERKLEIND);
        assertThat(Interval.create(C, Note.create("Gis")).getIntervalKind()).isEqualTo(IntervalKind.VERGROOT);
        assertThat(Interval.create(Note.create("Cis"), Note.create("G")).getIntervalKind()).isEqualTo(IntervalKind.VERKLEIND);
        assertThat(Interval.create(Note.create("Cis"), Note.create("Gis")).getIntervalKind()).isEqualTo(IntervalKind.REIN);
    }

    @Test
    public void getIntervalKind_Nooit_Rein() {
        assertThat(Interval.create(C, Note.create("D")).getIntervalKind()).isEqualTo(IntervalKind.GROOT);
        assertThat(Interval.create(C, Note.create("Des")).getIntervalKind()).isEqualTo(IntervalKind.KLEIN);
        assertThat(Interval.create(C, Note.create("Dis")).getIntervalKind()).isEqualTo(IntervalKind.VERGROOT);
        assertThat(Interval.create(Note.create("Cis"), Note.create("Des")).getIntervalKind()).isEqualTo(IntervalKind.VERKLEIND);

        assertThat(Interval.create(C, Note.create("E")).getIntervalKind()).isEqualTo(IntervalKind.GROOT);
        assertThat(Interval.create(C, Note.create("Es")).getIntervalKind()).isEqualTo(IntervalKind.KLEIN);
        assertThat(Interval.create(C, Note.create("Dis")).getIntervalKind()).isEqualTo(IntervalKind.VERGROOT);
        assertThat(Interval.create(Note.create("Cis"), Note.create("Des")).getIntervalKind()).isEqualTo(IntervalKind.VERKLEIND);

        assertThat(Interval.create(C, Note.create("A")).getIntervalKind()).isEqualTo(IntervalKind.GROOT);
        assertThat(Interval.create(C, Note.create("Aes")).getIntervalKind()).isEqualTo(IntervalKind.KLEIN);
        assertThat(Interval.create(C, Note.create("Ais")).getIntervalKind()).isEqualTo(IntervalKind.VERGROOT);
        assertThat(Interval.create(Note.create("Cis"), Note.create("Aes")).getIntervalKind()).isEqualTo(IntervalKind.VERKLEIND);

        assertThat(Interval.create(C, Note.create("B")).getIntervalKind()).isEqualTo(IntervalKind.GROOT);
        assertThat(Interval.create(C, Note.create("Bes")).getIntervalKind()).isEqualTo(IntervalKind.KLEIN);
        assertThat(Interval.create(C, Note.create("Bis")).getIntervalKind()).isEqualTo(IntervalKind.VERGROOT);
        assertThat(Interval.create(Note.create("Cis"), Note.create("Bes")).getIntervalKind()).isEqualTo(IntervalKind.VERKLEIND);
    }

    @Test
    public void getIntervalKind_Speciaal() {
        assertThat(Interval.create(Note.create("b1"), Note.create("F")).getIntervalKind()).isEqualTo(IntervalKind.VERKLEIND);
        assertThat(Interval.create(Note.create("B"), Note.create("F")).getIntervalKind()).isEqualTo(IntervalKind.VERGROOT);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Interval.create(Note.create("B"), Note.create("Fes")).getIntervalKind())
                .withMessage("no interval in range");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Interval.create(Note.create("Cis"), Note.create("Fes")).getIntervalKind())
                .withMessage("no interval in range");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Interval.create(Note.create("Dis"), Note.create("Fes")).getIntervalKind())
                .withMessage("no interval in range");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Interval.create(Note.create("Ces"), Note.create("Eis")).getIntervalKind())
                .withMessage("no interval in range");
    }

    @Test
    public void getIntervalKindAndName() {
        assertThat(Interval.create(Note.create("b1"), Note.create("F")).getIntervalKindAndName()).isEqualTo("VERKLEINDE KWINT");
        assertThat(Interval.create(Note.create("bes1"), Note.create("F")).getIntervalKindAndName()).isEqualTo("REINE KWINT");
        assertThat(Interval.create(Note.create("bes1"), Note.create("Fis")).getIntervalKindAndName()).isEqualTo("VERGROTE KWINT");

    }
}