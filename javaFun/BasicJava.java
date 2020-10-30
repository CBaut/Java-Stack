import java.util.ArrayList;
public class BasicJava {
    public void printBasic(int number) {
        for(int i = 0; i <= number; i++) {
            System.out.println(i);
        }
    }
    public void printOdd(int number) {
        for(int i = 0; i <= number; i++) {
            if(i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
    public void printSum(int number) {
        int sum = 0;
        for(int i = 0; i <= number; i++) {
            sum += i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    }
    public void iterateArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public void findMax(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
    public void getAverage(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum / arr.length);
    }
    public void arrayWithOdds(int number) {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for(int i = 0; i <= number; i++) {
            if(i % 2 != 0) {
                myArray.add(i);
            }
        }
        System.out.println(myArray);
    }
    public void greaterThanY(int[] numbers, int y) {
        int count = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] > y) {
                count++;
            }
        }
        System.out.println(count);
    }
    public void squareTheValues(int[] arr1) {
        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] * arr1[i];
        }
        System.out.println(arr1);
    }
    public void eliminateNegatives(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] < 0) {
                array[i] = 0;
            }
        }
        System.out.println(array);
    }
    public int[] maxMinAverage(int[] array) {
        int max = array[0];
        int min = array[0];
        int sum = 0;
        int avg = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
            if(array[i] < min) {
                min = array[i];
            }
            sum += array[i];
        }
        avg = sum / array.length;
        int[] array1 = {max, min, avg};
        return array1;
    }
    public void shiftValues(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
        System.out.println(array);
    }
}