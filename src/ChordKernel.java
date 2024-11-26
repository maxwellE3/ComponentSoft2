import components.standard.Standard;

/**
 * Chord kernel components with primary methods.
 */
public interface ChordKernel extends Standard<Chord> {

    /**
     * Removes the last note of {@code this} and then returns it.
     *
     * @updates this
     *
     * @return Returns the removes note.
     *
     * @ensures |this| = |#this| - 1
     */
    char removeLast();

    /**
     * Adds {@code note} to the end of the chord.
     *
     * @updates this
     *
     * @param note
     *            User given note.
     *
     * @ensures |this| = |#this| + 1
     */
    void addNote(char note);
}
