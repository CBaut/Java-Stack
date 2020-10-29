import java.lang.Math;
public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        // the hypotenuse is teh side across from the right angle
        double c = (legA * legA) + (legB * legB);
        // calculate the value of c given legA and legB
        c = Math.sqrt(c);
        return c;
    }
}