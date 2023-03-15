public class GCD {

    public static int gcd(int a, int b) {
        // Ensure a and b are positive
        a = Math.abs(a);
        b = Math.abs(b);

        // Perform Euclidean algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
