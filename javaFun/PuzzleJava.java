import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class PuzzleJava {
    public ArrayList<Integer> sumAllNumbers(int[] array) {
        int sum = 0;
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
            if(array[i] > 10) {
                myArray.add(array[i]);
                System.out.println(myArray);
            }
        }
        return myArray;
    }
}