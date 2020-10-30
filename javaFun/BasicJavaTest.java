public class BasicJavaTest {
    public static void main(String[] args) {
        BasicJava test1 = new BasicJava();
        test1.printBasic(255);
        test1.printOdd(255);
        test1.printSum(255);

        BasicJava test2 = new BasicJava();
        int[] myArray = {1, 3, 5, 7, 9, 13};
        test2.iterateArray(myArray);
        int[] myArray2 = {-3, -5, -7};
        test2.findMax(myArray2);
        int[] myArray3 = {2, 10, 3};
        test2.getAverage(myArray3);
        test2.arrayWithOdds(255);
        int[] myArray4 = {1, 3, 5, 7};
        test2.greaterThanY(myArray4, 3);
        int[] myArray5 = {1, 5, 10, -2};
        test2.squareTheValues(myArray5);
        int[] myArray6 = {1, 5, 10, -2};
        test2.eliminateNegatives(myArray6);
        System.out.println(test2.maxMinAverage(myArray6));
        int[] myArray7 = {1, 5, 10, 7, -2};
        test2.shiftValues(myArray7);
    }
}