import static Helper.IsPrime.isPrime;

public class Problem10 {
    /*
    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    Find the sum of all the primes below two million.
     */
    public static long sumOfPrimes(int max) {
        long sum = 0;
        for (int i = 0; i <= max; i++) {
            if(isPrime(i))sum+=i;
        }
        return sum;
    }

    public static void main (String[] args){
        System.out.println("Sum of all primes below two million: "+sumOfPrimes(2000000));
    }
}
