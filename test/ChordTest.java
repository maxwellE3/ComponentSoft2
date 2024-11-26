import static org.junit.Assert.assertEquals;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * JUnit test fixture for {@code Chord}'s constructor and kernel methods.
 *
 * @author Max Emerine
 *
 */
public abstract class ChordTest {

    /**
     * Invokes the appropriate {@code Chord} construcotr for the implementation
     * under test and returns the result.
     *
     * @return the new chord
     * @ensures constructorTest = 0
     */
    protected abstract Chord constructorTest();

    // /**
    //  * Invokes the appropriate {@code Chord} constructor for the reference
    //  * implementation and returns the result.
    //  *
    //  * @return
    //  */
    // protected abstract Chord constructorRef();

    /**
     * Tests the no-argument constructor.
     */
    public final void testConstructor() {
        Chord newChord = this.constructorTest();
        Queue<Character> refChord = new Queue1L<>();
        assertEquals(refChord, newChord);
    }

}
