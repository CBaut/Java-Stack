import java.util.HashMap;
public class HashmatiqueTest {
    public static void main(String[] args) {
//         A band from Teignmouth, Devon has contracted your company to organize their song list. Part of this is that they don't want to use song numbers in storing the lyrics until they are certain of the order. They insist that you be able to immediately retrieve the lyrics based on the song name, and your PM has asked you to implement this.

// To demonstrate to the band how it would work, use a HashMap with the track titles as keys and some sample lyrics as the values. Add at least 4 songs to your trackList HashMap and then pull one out by its name. They also want to be able to see all the tracks with the lyrics immediately following them.

// Create a trackList of type HashMap
Hashmatique test1 = new Hashmatique();
HashMap<String, String> get = test1.createTrackList();
System.out.println(get);
// Add in at least 4 songs that are stored by title

// Pull out one of the songs by its track title

// Print out all the track names and lyrics in the format Track: Lyrics
    }
}