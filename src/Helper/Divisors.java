package Helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Divisors {
    public static HashSet<Integer> getDivisors(int num){
        HashSet<Integer> divisors = new HashSet<>();

        if(num>0)
            divisors.add(1);
        if(num%2==0) {
            if(num>2)
                divisors.add(2);
            if(num/2>1)
                divisors.add(num/2);
        }
        for(int i = 3; i<num/2; i++){
            if(num%i==0) {
                divisors.add(i);
                divisors.add(num/i);
            }
        }

        return divisors;
    }
}
