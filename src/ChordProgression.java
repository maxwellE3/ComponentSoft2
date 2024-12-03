import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplewriter.SimpleWriter;

/**
 * Creates chord progressions.
 */
public class ChordProgression {

    /**
     * Current chord being worked on.
     */
    private Chord currC;

    /**
     * Chord Progression.
     */
    private Queue<Chord> currPro;

    /**
     * IDK.
     */
    public void chordProgression() {
        this.currPro = new Queue1L<>();
    }

    /**
     * Creates the users curr chord.
     *
     * @param in
     * @param out
     * @return current Chord
     */
    public Chord createChord(SimpleReader in, SimpleWriter out) {
        this.currC = new Chord1L();

        out.print(
                "Enter a note from a-g to be added to your chord or 0 to quit: ");
        String userString = in.nextLine();
        char userChar = userString.charAt(0);
        this.currC.addNote(userChar);
        while (userChar != '0') {
            out.print(
                    "Enter a note from a-g to be added to your chord or 0 to quit: ");
            userString = in.nextLine();
            userChar = userString.charAt(0);
            this.currC.addNote(userChar);
        }

        return this.currC;
    }

    /**
     * IDK.
     *
     * @param c
     */
    public void addToProg(Chord c) {
        this.currPro.enqueue(c);
    }

}
