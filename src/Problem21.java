import java.util.HashSet;
import java.util.List;

public class Problem21 {
    /*
    Let d(n) be defined as the sum of proper divisors of n
    (numbers less than n which divide evenly into n).
    If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair
    and each of a and b are called amicable numbers.

    For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
    therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

    Evaluate the sum of all the amicable numbers under 10000.

    Amicable numbers
     */

    public static int sumAmicable(int num){
        int sum = 0;
        HashSet<Integer> unique = new HashSet<>();
        for(int a = 1; a < num; a++) {
            int b = sumDivisors(a); // d(a)
            int c = sumDivisors(b); // d(b)

            if (a!=b && a==c && !unique.contains(a)) {
                sum += b + c;
                unique.add(b);
                unique.add(c);
            }
        }
        return sum;
    }

    private static int sumDivisors(int num){
        int sum = 1;
        for(int i = 2; i<num; i++){
            if(num%i==0){
                sum+=i;
            }
        }
        return sum;
    }

    public static void main(String[] args){ // 31626
        System.out.println("Sum of Amicable Numbers below 10000: "+sumAmicable(10000));
    }
}
