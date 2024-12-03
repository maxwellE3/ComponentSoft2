import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the kernel methods.
 */
public abstract class ChordTestKernel {

    /**
     * Invokes the appropriate {@code Chord} construcotr for the implementation
     * under test and returns the result.
     *
     * @return the new chord
     * @ensures constructorTest = 0
     */
    protected abstract Chord constructorTest();

    /**
     * Tests removeLast method with one note.
     */
    @Test
    public final void testRemoveLastSing() {
        Chord newChord = this.constructorTest();
        newChord.addNote('c');
        Chord testChord = new Chord1L();
        testChord.addNote('c');
        char removed = newChord.removeLast();
        char testNote = testChord.removeLast();

        assertEquals(testNote, removed);
        assertEquals(testChord, newChord);
    }

    /**
     * Tests removeLast method with multiple notes.
     */
    @Test
    public final void testRemoveLastMult() {
        Chord newChord = this.constructorTest();
        newChord.addNote('c');
        newChord.addNote('a');
        newChord.addNote('f');
        Chord testChord = this.constructorTest();
        testChord.addNote('c');
        testChord.addNote('a');
        testChord.addNote('f');
        char removed = newChord.removeLast();
        char testNote = testChord.removeLast();

        assertEquals(testNote, removed);
        assertEquals(testChord, newChord);
    }

    /**
     * Tests isEmpty method with an empty chord.
     */
    @Test
    public final void testIsEmptyEmpty() {
        Chord newChord = this.constructorTest();
        Chord testChord = this.constructorTest();

        assertEquals(true, newChord.isEmpty());
        assertEquals(testChord, newChord);
    }

    /**
     * Tests isEmpty method with a non-empty chord.
     */
    @Test
    public final void testIsEmptyNonEmpty() {
        Chord newChord = this.constructorTest();
        newChord.addNote('a');
        Chord testChord = this.constructorTest();
        testChord.addNote('a');

        assertEquals(false, newChord.isEmpty());
        assertEquals(testChord, newChord);
    }

}
