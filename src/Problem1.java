import java.util.HashSet;

public class Problem1 {
    //*********** https://projecteuler.net/problem=1 **********//
    //Find the sum of all the multiples of 3, and of 5, below 1000.
    public static int sumThreeFive(){ // COMPLEXITY 3N
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
}
