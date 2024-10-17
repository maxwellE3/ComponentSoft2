import components.queue.Queue;
import components.queue.Queue1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Allows a user to transverse through a chord.
 *
 * @author
 */
public class Chord1L {

    /**
     * Removes the last note in a chord.
     *
     * @param q
     *
     * @return removed
     */
    public static char removeLast(Queue<Character> q) {
        q.flip();
        char removed = q.dequeue();
        q.flip();

        return removed;
    }

    /**
     * Gets the root node of the given chord.
     *
     * @param q
     *
     * @return root
     */
    public static char getRoot(Queue<Character> q) {
        char root = q.front();
        return root;
    }

    /**
     * Add the user given note to the chord.
     *
     * @param q
     * @param note
     */
    public static void addNote(Queue<Character> q, char note) {
        q.enqueue(note);
    }

    /**
     * Gets the triad of the given chord.
     *
     * @param q
     *
     * @return triad
     */
    public static String getTriad(Queue<Character> q) {
        String triad = "";
        for (char y : q) {
            String currChar = y + "";
            if (!(triad.contains(currChar))) {
                triad += y;
            }
        }
        return triad;
    }

    /**
     * Main Method.
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        Queue<Character> aMaj = new Queue1L<>();

        //Build an A major guitar chord based off the bar chord.
        aMaj.enqueue('a');
        aMaj.enqueue('C');
        aMaj.enqueue('e');
        aMaj.enqueue('C');
        aMaj.enqueue('e');
        aMaj.enqueue('a');

        //removes the last note in the chord, a, leaving you still with an A major.
        char removed = removeLast(aMaj);

        //prints out the new chord
        for (char y : aMaj) {
            out.print(y);
        }
        out.println();
        //prints out the removed note form the chord
        out.println("Removed: " + removed);

        //gets the root of the chord to show the user what chord is being used.
        char root = getRoot(aMaj);
        out.println("Root: " + root);

        //adds the note, a, to the chord
        char addedNote = 'a';
        addNote(aMaj, addedNote);

        //prints out the new chord
        for (char y : aMaj) {
            out.print(y);
        }
        out.println();

        String triad = getTriad(aMaj);
        out.println(triad);

        out.close();
    }
}
