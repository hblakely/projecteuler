public class Problem3 {
    //*********** https://projecteuler.net/problem=3 **********//
    //What is the largest prime factor of the number 600851475143 ?
    public static long largestPrimeFactor(){
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
}
