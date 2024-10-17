/**
 *
 * {@code ChordKernel} enhanced with secondary methods.
 */
public interface Chord extends ChordKernel {
    /**
     * Returns the root note of {@code this}.
     *
     * @return Returns the root note.
     */
    char getRoot();

    /**
     * Gets the triad of {@code this} in the form of the inputed
     * {@code inversion}.
     *
     * @param inversion
     *            int representing which inversion of a triad to return.
     * @return Returns a string of 3 notes.
     */
    String getTriad(int inversion);
}
