import static Helper.IsPrime.isPrime;
/*
    public static boolean isPrime(long l){
        boolean isPrime = true;
        if(l==1)return false;
        // I used to go from factor->l/2, but found that factor->sqrt(l) worked.
        for (long factor=2; factor<Math.floor(Math.sqrt(l)); factor++){
            if(l%factor==0&&l!=factor)
                return false;
        }
        return isPrime;
    }
 */
public class Problem7 {
    /*
        By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
        What is the 10 001st prime number?
     */
    //*********** https://projecteuler.net/problem=7 **********//
    public static long nthPrime(int nth){
        if(nth<1)  // invalid input
            return -1;
        int count = 0;
        for(int i = 2; i<=Long.MAX_VALUE; i++) // Loop til can't. Increment count when found. Compare to nth. return.
            if(isPrime(i) && ++count == nth) return i;
        return -1; // We know something wrong happened if we get -1 as a result.
    }
    //*********** https://projecteuler.net/problem=7 **********//

    public static void main(String[] args){
        System.out.println("\nThe 10,001st prime is:\t"+nthPrime(10001));
    }
}
