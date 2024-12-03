import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code Chord}'s constructor and kernel methods.
 *
 * @author Max Emerine
 *
 */
public abstract class ChordTestAbstract {

    /**
     * Invokes the appropriate {@code Chord} construcotr for the implementation
     * under test and returns the result.
     *
     * @return the new chord
     * @ensures constructorTest = 0
     */
    protected abstract Chord constructorTest();

    /**
     * Tests the no-argument constructor.
     */
    @Test
    public final void testConstructor() {
        Chord newChord = new Chord1L();
        Chord testChord = new Chord1L();

        assertEquals(testChord, newChord);
    }

    /**
     * Tests Standard Methods.
     */

    /**
     * Tests newInstance method with empty chord.
     */
    @Test
    public final void testNewInstanceEmpty() {
        Chord newChord = this.constructorTest();
        Chord testChord = newChord.newInstance();

        assertEquals(testChord, newChord);
    }

    /**
     * Tests newInstance method with non-empty chord.
     */
    @Test
    public final void testNewInstanceNonEmpty() {
        Chord newChord = this.constructorTest();
        newChord.addNote('c');
        Chord testChord = newChord.newInstance();

        while (!newChord.isEmpty()) {
            newChord.removeLast();
        }

        assertEquals(testChord, newChord);
    }

    /**
     * Tests clear method.
     */
    @Test
    public final void testClear() {
        Chord newChord = this.constructorTest();
        newChord.addNote('c');
        newChord.clear();
        Chord testChord = newChord.newInstance();

        assertEquals(testChord, newChord);
    }

    /**
     * Test transferFrom method with empty chord.
     */
    @Test
    public final void testTransferFromEmpty() {
        Chord newChord = this.constructorTest();
        Chord testChord = this.constructorTest();
        testChord.transferFrom(newChord);

        assertEquals(newChord, testChord);
    }

    /**
     * Test transferFrom method with a non-empty chord.
     */
    @Test
    public final void testTransferFromNonEmpty() {
        Chord newChord = this.constructorTest();
        newChord.addNote('c');
        newChord.addNote('a');
        newChord.addNote('F');
        Chord testChord = this.constructorTest();
        testChord.transferFrom(newChord);

        assertEquals(testChord, newChord);
    }

    /**
     * Tests Kernel Methods.
     */

    /**
     * Tests removeLast method with one note.
     */
    @Test
    public final void testRemoveLastSing() {
        Chord newChord = this.constructorTest();
        newChord.addNote('c');
        Chord testChord = this.constructorTest();
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

    /**
     * Tests Secondary Methods.
     */

    /**
     * Tests getRoot method.
     */
    @Test
    public final void testGetRoot() {
        Chord newChord = this.constructorTest();
        newChord.addNote('c');
        newChord.addNote('a');
        newChord.addNote('b');
        Chord testChord = this.constructorTest();
        testChord.addNote('c');
        testChord.addNote('a');
        testChord.addNote('b');

        assertEquals('c', newChord.getRoot());
        assertEquals(testChord, newChord);
    }

    /**
     * Tests getTriad method with first inversion.
     */
    @Test
    public final void testGetTriadFirstInv() {
        Chord newChord = this.constructorTest();
        newChord.addNote('c');
        newChord.addNote('a');
        newChord.addNote('b');
        Chord testChord = this.constructorTest();
        testChord.addNote('c');
        testChord.addNote('a');
        testChord.addNote('b');

        String newChordTriad = newChord.getTriad(1);
        String testChordTriad = testChord.getTriad(1);

        assertEquals(testChordTriad, newChordTriad);
        assertEquals(testChord, newChord);
    }

    /**
     * Tests getTriad method with second inversion.
     */
    @Test
    public final void testGetTriadSecondInv() {
        Chord newChord = this.constructorTest();
        newChord.addNote('c');
        newChord.addNote('a');
        newChord.addNote('b');
        Chord testChord = this.constructorTest();
        testChord.addNote('c');
        testChord.addNote('a');
        testChord.addNote('b');

        String newChordTriad = newChord.getTriad(2);
        String testChordTriad = testChord.getTriad(2);

        assertEquals(testChordTriad, newChordTriad);
        assertEquals(testChord, newChord);
    }

    /**
     * Tests getTriad method with third inversion.
     */
    @Test
    public final void testGetTriadThirdInv() {
        Chord newChord = this.constructorTest();
        newChord.addNote('c');
        newChord.addNote('a');
        newChord.addNote('b');
        Chord testChord = this.constructorTest();
        testChord.addNote('c');
        testChord.addNote('a');
        testChord.addNote('b');

        String newChordTriad = newChord.getTriad(3);
        String testChordTriad = testChord.getTriad(3);

        assertEquals(testChordTriad, newChordTriad);
        assertEquals(testChord, newChord);
    }

}
