import java.util.Arrays;
import java.util.Collections;
import java.util.stream.LongStream;

public class Problem5 {
    //*********** https://projecteuler.net/problem=5 **********//
    /* What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
        https://www.calculator.net/lcm-calculator.html#:~:text=What%20is%20the%20Least%20Common,LCM(a%2C%20b).

     */
    public static long leastCommonMultiple(long[] nums){
        // Invalid input
        if(nums.length==0)
                return 0;

        long lcm=nums[0]; // Initialize lcm with num at first index of array
        for(int i = 1; i<nums.length; i++) { // start loop at second index of array
            // We'll use the Greatest Common Divisor method: (a*b)/GCF(a,b)
            //lcm = lcm * nums[i] / greatestCommonFactor(lcm, nums[i]);
            lcm = lcm * nums[i] / greatestCommonFactorRecursive(lcm, nums[i]); // fewer lines of code.
        }
        return lcm; // If array is size one, the value stored at first index will be returned.
    }

    // Euclidean Algorithm
    // GCD of two integers can also divide their difference.
    private static long greatestCommonFactor(long a, long b){
        while(b!=0){
            long c = a;  // c holds a-value before modulo
            a = b;      // a holds b-value before modulo
            // c%b will be 0 if b is a factor of c.
            // If b is not a factor, absolute value of the difference is stored,
            // and used for the next modulo operation, eventually reducing to 0.
            b = c % b; // When c%b == 0, loop breaks, and the answer is stored in a.
        }
        return a;
    }
    private static long greatestCommonFactorRecursive(long a, long b){
        if(b!=0)return greatestCommonFactor(b,a % b);
        else return a;
    }
    //*********** https://projecteuler.net/problem=5 **********//

    public static void main(String[] args){
        System.out.println("\nThe smallest positive number that is evenly divisible by all of the numbers " +
                "from 1 to 20:\t"+leastCommonMultiple(LongStream.rangeClosed(1, 20).toArray()));
    }

    /*******************************************
     * This is how BigInteger handles greatest-common-divisor between two BigIntegers:
     * It's operating using the Euclidean method. I'd be curious to see the comparison between
     * following the euclidean algorithm verbatim like this, compared to the modulo version I
     * had implemented above.
     * ******************************************
     MutableBigInteger hybridGCD(MutableBigInteger b) {
     // Use Euclid's algorithm until the numbers are approximately the
     // same length, then use the binary GCD algorithm to find the GCD.
     MutableBigInteger a = this;
     MutableBigInteger q = new MutableBigInteger();

     while (b.intLen != 0) {
     if (Math.abs(a.intLen - b.intLen) < 2)
     return a.binaryGCD(b);

     MutableBigInteger r = a.divide(b, q);
     a = b;
     b = r;
     }
     return a;
     }*/
}
