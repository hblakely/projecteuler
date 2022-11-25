import java.util.HashSet;

public class Euler {
    public static void main(String[] args) {
        // output metrics
        boolean verbose = true;
        // calculate runtime
        long startTime;
        long endTime;
        // calculate memory usage
        long beforeUsedMem;
        long afterUsedMem;

        // Calculating Memory outside of runtime to get better speed estimate.
        // So far it seems that the way I'm tracking memory for each method doesn't work.

        // 1 (CORRECT: 233168)
        beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        int euler1 = sumThreeFive();
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nSum of all multiples of 3 and 5 below 1,000:\t"+euler1);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 2 (CORRECT: 4613732)
        beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        int euler2 = evenFibonacci();
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nSum even Fibonacci below 4,000,000:\t"+euler2);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 3 (CORRECT: 6857)
        beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        long euler3 = largestPrimeFactor();
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nLargest prime factor of 600851475143:\t"+euler3);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 4 (CORRECT: 906609)
        startTime = System.nanoTime();
        int euler4 = largestPalindromeProductThreeDigit();
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nThe largest palindrome made from the product of two 3-digit numbers:\t"+euler4);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 5
        startTime = System.nanoTime();
        int euler5 = smallestDivisibleBy1through20();
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nThe smallest positive number that is evenly divisible by all of the numbers from 1 to 20:\t"+euler5);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }


    }

    //************************************************//
    //********** projecteueler.net problems **********//
    //************************************************//

    //*********** https://projecteuler.net/problem=5 **********//
    // What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
    private static int smallestDivisibleBy1through20(){
        int answer=0;
        // The Least Common Multiple for a set of numbers can be found by
        // multiplying prime factors to the highest power within the set

        return answer;
    }

    //*********** https://projecteuler.net/problem=4 **********//
    // Find the largest palindrome made from the product of two 3-digit numbers.
    private static int largestPalindromeProductThreeDigit(){
        int largestPalindrome=0; // if we return 0, no answer is found.
        for (int i=999; i>=100; i--) { // 100-999 (three digit numbers).
            for (int j = i; j>=100; j--) { // initialize j as i to prevent duplicate products.
                int product = i * j; // 993 * 913 = 906609
                // A palindrome is found at i=995, that is smaller than the largest palindrome at i=993
                // Must loop through i-values to find largest palindrome for each i, and compare to the previously found palindrome
                if (isPalindrome(product)&&product>largestPalindrome) { // largest product that is a palindrome for each i value
                    largestPalindrome = product;
                    break; // Prevent unnecessary calculations for the rest of the j values.
                }
            }
        }
        return largestPalindrome;
    }
    private static boolean isPalindrome(int num){
        int reverse=0;
        int number=num;
        while(number!=0){ // repeated integer division by 10 will eventually reduce number to 0.
            int digit = number%10; // number modulo 10 gives right most digit
            reverse = reverse*10+digit; // multiply reverse by 10 to shift digits left by 1 place
            number=number/10; // integer division by 10 pops rightMost digit from num
        }
        if(num==reverse) // a palindrome is a number that is the same as its reversed digits.
            return true;
        return false;
    }

    //*********** https://projecteuler.net/problem=4 **********//

    //*********** https://projecteuler.net/problem=3 **********//
    //What is the largest prime factor of the number 600851475143 ?
    private static long largestPrimeFactor(){
        // 1 is not a prime, and is always a factor. If we return 1, that means we failed to find a prime factor.
        long largestPrimeFactor = 1;
        long num = 600851475143l;

        // divide num by 2 to work on the left-side factors.
        for(long count = 2; count<num/2; count++){
            if(num%count==0){ // determine if count is a factor of num
                long factor = num/count;
                if (isPrime(factor)){
                    largestPrimeFactor=factor;
                    break;
                }
            }
        }
        return largestPrimeFactor;
    }
    private static boolean isPrime(long l){
        boolean isPrime = true;
        if(l==1)return false;
        for (long factor=2; factor<l/2; factor++){
            if(l%factor==0&&l!=factor)
                return false;
        }
        return isPrime;
    }
    //*********** https://projecteuler.net/problem=3 **********//

    //*********** https://projecteuler.net/problem=2 **********//
    // By considering the terms in the Fibonacci sequence whose values do not exceed four million,
    // find the sum of the even-valued terms.
    private static int evenFibonacci(){
        int previous =1;
        int current=2;
        int sum=0;

        while (current<4000000){ // follow Fibonacci sequence until value >= 4 million.
            if (current%2==0) // if current value is even
                sum+=current;

            current+=previous;
            previous=current-previous;
        }

        return sum;
    }
    //*********** https://projecteuler.net/problem=2 **********//

    //*********** https://projecteuler.net/problem=1 **********//
    //Find the sum of all the multiples of 3, and of 5, below 1000.
    private static int sumThreeFive(){ // COMPLEXITY 3N
        int sum=0;
        // Unique integers (don't want to add common-multiples twice).
        HashSet<Integer> subset = new HashSet<Integer>();
        for (int i = 3; i<1000; i+=3){ // step through with multiples of 3 - Adds N complexity
            subset.add(i);
        }
        for (int i = 5; i<1000; i+=5){ // step through with multiples of 5 - Adds N complexity
            subset.add(i);
        }
        for (Integer i : subset){ // sum values gathered - Adds N complexity
            sum+=i;
        }
        return sum;
    }
    //*********** https://projecteuler.net/problem=1 **********//

    //************************************************//
    //****** END projecteueler.net problems **********//
    //************************************************//

    // HELPER METHODS TO CALCULATE MEMORY AND RUNTIME
    private static String timeElapsed(long startNano, long endNano){
        return String.format("%f",(endNano-startNano)/1000000000.0)+" seconds.";
    }
    private static String memoryUsed(long startBytes, long endBytes){
        long bytesUsed = endBytes-startBytes;
        if(bytesUsed/1048576.0>1.0)
            return String.format("%f",bytesUsed/1048576.0)+" megabytes.";
        if(bytesUsed/1024.0>1.0)
            return String.format("%f",bytesUsed/1024.0)+" kilobytes.";

        return bytesUsed+" bytes.";
    }
}
