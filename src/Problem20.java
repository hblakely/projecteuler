import java.math.BigInteger;

public class Problem20 {
    /*
    Factorial digit sum

    n! means n × (n − 1) × ... × 3 × 2 × 1

    For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
    and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

    Find the sum of the digits in the number 100!
     */
    public static int factoralDigitSum(int num){
        BigInteger one = new BigInteger("1");
        BigInteger n = new BigInteger(""+num);
        BigInteger mult = n;
        int sum = 0;

        while (n.intValue() > 1) {
            n=n.subtract(one);
            mult=mult.multiply(n);
        }

        String s = mult.toString();
        for(int i = 0; i<s.length(); i++){
            Integer digit = Integer.valueOf(""+s.charAt(i));
            sum+=digit;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println("Sum of digits of 100! = "+factoralDigitSum(100));
    }
}
