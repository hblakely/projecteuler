import java.math.BigInteger;
import java.util.stream.LongStream;

public class EulerEngine {
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
        int euler1 = Problem1.sumThreeFive();
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
        int euler2 = Problem2.evenFibonacci();
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
        long euler3 = Problem3.largestPrimeFactor();
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nLargest prime factor of 600851475143:\t"+euler3);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 4 (CORRECT: 906609)
        startTime = System.nanoTime();
        int euler4 = Problem4.largestPalindromeProductThreeDigit();
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nThe largest palindrome made from the product of two 3-digit numbers:\t"+euler4);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 5 (CORRECT: 232792560)
        startTime = System.nanoTime();
        long euler5 = Problem5.leastCommonMultiple(LongStream.rangeClosed(1, 20).toArray());
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nThe smallest positive number that is evenly divisible by all of the numbers " +
                "from 1 to 20:\t"+euler5);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 6 (CORRECT: 25164150)
        startTime = System.nanoTime();
        long euler6 = Problem6.sumSquare(100);
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nThe difference between the sum of the squares of the first one " +
                "hundred natural numbers and the square of the sum:\t"+euler6);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 7 (CORRECT: 104743)
        startTime = System.nanoTime();
        long euler7 = Problem7.nthPrime(10001);
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nThe 10,001st prime is:\t"+euler7);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 8 (CORRECT: 23514624000)
        startTime = System.nanoTime();
        BigInteger euler8 = Problem8.largestProdcutAdjacent13();
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Largest product of 13 adjacent integers: "+ euler8);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 9 (Correct: 31875000)
        startTime = System.nanoTime();
        int euler9 = Problem9.productOfPythagoreanTriplet();
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("The product abc of Pythagorean triplet for which a + b + c = 1000: "+euler9);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 10 (Correct: 142913828922)
        startTime = System.nanoTime();
        long euler10 = Problem10.sumOfPrimes(2000000);
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Sum of all primes below two million: "+euler10);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 11 (CORRECT: 70600674)
        startTime = System.nanoTime();
        long euler11 = Problem11.greatestProductOfFourAdjacentNumbers();
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("The greatest product of four adjacent numbers in the same direction: "+euler11);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }

        // 12 (CORRECT: 76576500)
        startTime = System.nanoTime();
        int euler12 = Problem12.highlyDivisibleTriangleNumber(500);
        endTime = System.nanoTime();
        afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("The first triangle number with over 500 divisors: "+euler12);
        if(verbose){
            System.out.println("Runtime:\t\t"+ timeElapsed(startTime,endTime));
            System.out.println("Memory Usage:\t"+ memoryUsed(beforeUsedMem,afterUsedMem)+"\n");
        }
    }

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
