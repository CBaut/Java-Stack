public class PuzzleJavaTest {
    public static void main(String[] args) {
        // [x] Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)
        PuzzleJava test1 = new PuzzleJava();
        int[] myArray = {3, 5, 1, 2, 7, 9, 8, 13, 25, 32};
        test1.sumAllNumbers(myArray);
        System.out.println(test1);

        // [x] Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.
        PuzzleJava test2 = new PuzzleJava();
        String[] myArray2 = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        test2.shuffleArray(myArray2);
        System.out.println(test2);

        // [x] Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and, after shuffling, display the last letter from the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.

        // To shuffle a collection, you can use the shuffle method of the Collections class.
        PuzzleJava test3 = new  PuzzleJava();
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        char[] returned = test3.shuffleAlphabet(alphabets);
        System.out.println("printing what got returned");
        for(int i = 0; i < returned.length; i++) {
            System.out.println(returned[i]);
        }
        // [x] Generate and return an array with 10 random numbers between 55-100.
        PuzzleJava test4 = new PuzzleJava();
        int[] randomNums = test4.randGen();
        System.out.println(randomNums);
        for(int i = 0; i < randomNums.length; i++) {
            System.out.println(randomNums[i]);
        }
        // To get a random integer, you can use the nextInt method of the Random class.
        // [x] Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.
        PuzzleJava test5 = new PuzzleJava();
        int[] randToSort = test5.sortedNums();
        for(int i = 0; i < randToSort.length; i++) {
            System.out.println(randToSort[i]);
        }
        System.out.println("printing min: " + randToSort[0]);
        System.out.println("printing max: " + randToSort[randToSort.length - 1]);
        // To sort a collection, you can use the sort method of the Collections class.

        // [x] Create a random string that is 5 characters long.
        PuzzleJava test6 = new PuzzleJava();
        String gotcha = test6.randomString(5);
        System.out.println(gotcha);
        // [x] Generate an array with 10 random strings that are each 5 characters long
        PuzzleJava test7 = new PuzzleJava();
        String[] theseStrings = test7.makeTen();
        for(int i = 0; i < theseStrings.length; i++) {
            System.out.println(theseStrings[i]);
        }
    }
}