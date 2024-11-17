import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Allows a user to transverse through a chord.
 *
 * @author
 */
public class Chord1L extends ChordSecondary {

    /**
     * Representation of {@code this}.
     *
     * I chose to represent my component, Chord, using a queue because it is
     * easy to input and remove a certain type of variable. Also, I have been
     * wokring with queues for a while now, so I am very familiar with how they
     * function. Queues have the format of first in first out allowing me to
     * keep order within the inputted chord. Another representation that could
     * be useful is stack, however I chose queue due to familiarity.
     */
    private Queue<Character> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Queue1L<>();
    }

    /**
     * No-Argument Constructor.
     */
    public Chord1L() {
        this.createNewRep();
    }

    /**
     * Standard Methods.
     */
    @Override
    public final Chord newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Chord source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Chord1L : ""
                + "Violation of: source is of dynamic type NaturalNumberExample";

        Chord1L localSource = (Chord1L) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /**
     * Kernel Methods.
     */

    @Override
    public final char removeLast() {
        assert this.rep.length() != 0 : "Violation of: this is not empty";

        this.rep.flip();
        char removed = this.rep.dequeue();
        this.rep.flip();

        return removed;
    }

    @Override
    public final void addNote(char note) {
        assert note != '\u0000' : "Violation of: note is not null";

        this.rep.enqueue(note);

    }
}
