public class FizzBuzz {
    public String fizzBuzz(int number) {
        String string = "";
        if(number % 3 == 0) {
            string = "Fizz";
            if(number % 5 == 0) {
                string += "Buzz";
            }
        } else if(number % 5 == 0) {
            string = "Buzz";
        } else {
            return String.format("%", number);
        }
        return string;
    }
}