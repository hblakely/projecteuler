import java.math.BigInteger;

public class Problem16 {
    /*
    Power digit sum
    Submit

     Show HTML problem content
    Problem 16
    215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

    What is the sum of the digits of the number 21000?
     */
    public static int powerDigitSum(int power){
        int sum = 0;
        BigInteger num = new BigInteger("2").pow(power);
        String chars = num.toString();

        // Had to use Integer.valueOf(""+c) to get the number value,
        // or it would get the ascii int value of the character '1', not the value 1.
        for(char c : chars.toCharArray()){
            Integer i = Integer.valueOf(""+c);
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println("The sum of digits for the number 2^1000: "+powerDigitSum(1000)); // 1366
    }

}
