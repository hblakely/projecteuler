import java.util.Arrays;
import java.util.Collections;

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
    private static long greatestCommonFactor(long a, long b){ // Iterative solution
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
    private static long greatestCommonFactorRecursive(long a, long b){ // Looks almost exactly like the iterative.
        if(b!=0)return greatestCommonFactor(b,a % b);
        else return a;
    }

    //*********** https://projecteuler.net/problem=5 **********//
}
