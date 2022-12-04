package Helper;

public class IsPrime {
    public static boolean isPrime(long l){
        boolean isPrime = true;
        if(l==1)return false;
        // I used to go from factor->l/2, but found that factor->sqrt(l) worked.
        for (long factor=2; factor<=Math.sqrt(l); factor++){
            if(l%factor==0&&l!=factor)
                return false;
        }
        return isPrime;
    }
}
