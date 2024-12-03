import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * IDK.
 */
public class ChordUsingTriads {

    /**
     * Shows how the chord component allows a user to easily manage chords.
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        Chord userChord = new Chord1L();

        out.print("Enter a note to add to your chord: ");
        String userString = in.nextLine();
        char userNote = userString.charAt(0);

        while (userNote != '0') {
            userChord.addNote(userNote);
            out.print("Enter a note to add to your chord: ");
            userString = in.nextLine();
            userNote = userString.charAt(0);
        }

        String chord = userChord.toString();
        out.println(chord);

        String triad = userChord.getTriad(3);
        out.println(triad);

        in.close();
        out.close();

    }
}
