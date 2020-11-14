import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
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
    public ArrayList<String> shuffleArray(String[] array) {
        ArrayList<String>  myArray = new ArrayList<String>();
        List<String> listString = Arrays.asList(array);
        Collections.shuffle(listString);
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if(array[i].length() > 5) {
                myArray.add(array[i]);
            }
        }
        return myArray;
    }
    public char [] shuffleAlphabet(String letters) {
        char[] alphaArray = letters.toCharArray();
        List<Character> alphaList = new ArrayList<>();
        for (char ch: alphaArray) {
            alphaList.add(ch);
        }
        Collections.shuffle(alphaList);
        System.out.println(alphaList);
        alphaArray = alphaList.toString().toCharArray();
        System.out.println("printing the last item: " + alphaArray[alphaArray.length - 2]);
        System.out.println("printing the first item: " + alphaArray[1]);
        if(alphaArray[1] == 'a' || alphaArray[1] == 'e' || alphaArray[1] == 'i' || alphaArray[1] == 'o' || alphaArray[0] == 'u') {
            System.out.println("here's a message");
        }
        return alphaArray;
    }
    public int[] randGen() {
        int[] intArray = new int[10];
        Random rand = new Random();
        for(int i = 0; i < intArray.length; i++) {
            intArray[i] = rand.nextInt((100 - 55) + 1) + 55;
        }
        return intArray;
    }
    public int[] sortedNums() {
        int[] intArray = randGen();
        Arrays.sort(intArray);
        System.out.println(intArray);
        return intArray;
    }
    public String randomString(int len) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }
    public String[] makeTen() {
        String[] strArr = new String[10];
        for(int i = 0; i < strArr.length; i++) {
            strArr[i] = randomString(5);
        }
        return strArr;
    }
}