import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
    public static void main(String[] args) {
        Hashmatique test1 = new Hashmatique();
        // Create a trackList
        HashMap<String, String> newList = new HashMap<String, String>();
        System.out.println(newList);
        // Add in at least 4 songs that are stored by title
        newList.put("Why", "Why am I like this");
        newList.put("How", "How am I like this");
        newList.put("When", "When am I like this");
        newList.put("Where", "Where am I like this");
        System.out.println(newList);
        // Pull out one of the songs by its track title
        String oneTrack = newList.get("Where");
        System.out.println(oneTrack);
        // Print out all the track names and lyrics in the format Track: Lyrics
        Set<String> keys = newList.keySet();
        for(String key : keys) {
            System.out.println(key + ": " + newList.get(key));
        }
    }
  
}