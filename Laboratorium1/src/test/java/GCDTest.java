import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GCDTest {

    @Test
    public void testGCD2prime() {
        // Test 1: gcd of two prime numbers
        assertEquals(1, GCD.gcd(7, 11));
    }

    @Test
    public void testGCD2even() {
        // Test 2: gcd of two even numbers
        assertEquals(4, GCD.gcd(16, 20));
    }

    @Test
    public void testGCD2odd() {
        // Test 3: gcd of two odd numbers
        assertEquals(3, GCD.gcd(15, 21));
    }

    @Test
    public void testGCD1num1zero() {
        // Test 4: gcd of a number and 0
        assertEquals(8, GCD.gcd(8, 0));
    }

    @Test
    public void testGCD2same() {
        // Test 5: gcd of a number and itself
        assertEquals(12, GCD.gcd(12, 12));
    }

    @Test
    public void testGCD2multi() {
        // Test 6: gcd of two numbers where one is a multiple of the other
        assertEquals(6, GCD.gcd(18, 12));
    }

    @Test
    public void testGCD2negative() {
        // Test 7: gcd of two negative numbers
        assertEquals(3, GCD.gcd(-15, -21));
    }

    @Test
    public void testGCD1negative() {
        // Test 8: gcd of two numbers where one is negative
        assertEquals(2, GCD.gcd(-10, 6));
    }

    @Test
    public void testGCD2large() {
        // Test 9: gcd of two large numbers
        assertEquals(1000, GCD.gcd(1000, 1000));

    }

    @Test
    public void testGCone() {
        // Test 10: gcd of two numbers where one is 1
        assertEquals(1, GCD.gcd(27, 1));
    }

}
