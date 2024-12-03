import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Layered implementation of secondary methods for {@code Chord}.
 */
public abstract class ChordSecondary implements Chord {

    /**
     * Magic Number 3.
     */
    private final int THREE = 3;

    /**
     * Returns the root note of {@code this} without accessing the underlying
     * representation.
     */
    @Override
    public char getRoot() {
        Queue<Character> tempQueue = new Queue1L<>();

        char rootNote = '\0';

        char note = this.removeLast();
        if (note != '\0') {
            rootNote = note;
            tempQueue.enqueue(rootNote);

            note = this.removeLast();
            while (note != '\0') {
                tempQueue.enqueue(note);
                rootNote = note;
                note = this.removeLast();
            }
            while (!(tempQueue.length() == 0)) {
                this.addNote(tempQueue.dequeue());
            }
        }
        return rootNote;
    }

    /**
     * Returns the triad of {@code this} in the specified inversion.
     */
    @Override
    public String getTriad(int inversion) {
        Queue<Character> tempQueue = new Queue1L<>();

        char[] triad = new char[this.THREE];
        int i = 2;
        char currChar = this.removeLast();
        tempQueue.enqueue(currChar);
        triad[i] = currChar;
        i--;
        while (i > -1) {
            currChar = this.removeLast();
            tempQueue.enqueue(currChar);
            boolean contained = false;
            for (int j = 0; j < triad.length && !contained; j++) {
                if (triad[j] == currChar) {
                    contained = true;
                }
            }
            if (!(contained)) {
                triad[i] = currChar;
                i--;
            }
        }

        // Restore notes from the queue to the chord in original order
        while (!(tempQueue.length() == 0)) {
            this.addNote(tempQueue.dequeue());
        }

        // Arrange the triad based on the specified inversion
        switch (inversion) {
            case 1: // Root position
                return "" + triad[0] + triad[1] + triad[2];
            case 2: // First inversion
                return "" + triad[1] + triad[2] + triad[0];
            case 3: // Second inversion
                return "" + triad[2] + triad[0] + triad[1];
            default:
                throw new IllegalArgumentException(
                        "Invalid inversion. Must be 1, 2, or 3.");
        }
    }

    @Override
    public String toString() {
        Queue<Character> tempQueue = new Queue1L<>();

        String chord = "";
        while (this.length() != 0) {
            char currChar = this.removeLast();
            tempQueue.enqueue(currChar);
        }
        tempQueue.flip();
        while (tempQueue.length() != 0) {
            char currChar = tempQueue.dequeue();
            chord += currChar;
            this.addNote(currChar);
        }
        return chord;
    }

    @Override
    public boolean equals(Object c) {
        boolean equal = true;
        if (!(c instanceof String)) {
            equal = false;
        } else {
            String str = (String) c;

            Queue<Character> tempQueue = new Queue1L<>();
            Queue<Character> queueC = new Queue1L<>();

            for (char x : str.toCharArray()) {
                queueC.enqueue(x);
            }

            char currChar = this.removeLast();
            while (!(this.isEmpty())) {
                tempQueue.enqueue(currChar);
                currChar = this.removeLast();
            }
            tempQueue.flip();

            if (tempQueue.length() != queueC.length()) {
                equal = false;
            } else {
                while (queueC.length() != 0 && equal) {
                    char temp1 = tempQueue.dequeue();
                    char temp2 = queueC.dequeue();
                    this.addNote(temp1);
                    if (temp1 != temp2) {
                        equal = false;
                    }
                }
            }
            while (tempQueue.length() != 0) {
                this.addNote(tempQueue.dequeue());
            }
        }
        return equal;
    }
}
