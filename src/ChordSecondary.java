
import java.util.Arrays;

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
        triad[i] = currChar;
        while (currChar != '\0') {
            if (!(Arrays.asList(triad).contains(currChar))) {
                triad[i] = currChar;
                i--;
            }
            tempQueue.enqueue(currChar);
            currChar = this.removeLast();
        }

        // Restore notes from the queue to the chord in original order
        while (!(tempQueue.length() == 0)) {
            this.addNote(tempQueue.dequeue());
        }

        // Arrange the triad based on the specified inversion
        switch (inversion) {
            case 0: // Root position
                return "" + triad[0] + triad[1] + triad[2];
            case 1: // First inversion
                return "" + triad[1] + triad[2] + triad[0];
            case 2: // Second inversion
                return "" + triad[2] + triad[0] + triad[1];
            default:
                throw new IllegalArgumentException(
                        "Invalid inversion. Must be 0, 1, or 2.");
        }
    }

    @Override
    public String toString() {
        Queue<Character> tempQueue = new Queue1L<>();

        String chord = "";
        char currChar = this.removeLast();
        while (currChar != '\0') {
            tempQueue.enqueue(currChar);
        }
        tempQueue.flip();
        while (tempQueue.length() != 0) {
            currChar = tempQueue.dequeue();
            chord += currChar;
            this.addNote(currChar);
        }
        return chord;
    }

    @Override
    public boolean isEqual(String c) {
        Queue<Character> tempQueue = new Queue1L<>();
        Queue<Character> queueC = new Queue1L<>();
        boolean equal = true;

        for (char x : c.toCharArray()) {
            queueC.enqueue(x);
        }

        char currChar = this.removeLast();
        while (currChar != '\0') {
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
        return equal;
    }
}
