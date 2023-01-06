import Helper.Divisors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static Helper.Divisors.*;

public class Problem23 {
    /*
    Non-abundant sums

    Problem 23

    A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
    For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that
    28 is a perfect number.

    A number n is called deficient if the sum of its proper divisors is less than n and it is called
    abundant if this sum exceeds n.

    As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written
    as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers
    greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot
    be reduced any further by analysis even though it is known that the greatest number that cannot be
    expressed as the sum of two abundant numbers is less than this limit.

    Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
     */
    private static List<Integer>abundantNums = new ArrayList<>();
    public static int sumPositiveNonAbundant(){
        int sum = 0;
        for(int i = 1; i<=28123; i++){
            if(isAbundant(i))
                abundantNums.add(i); // Gather abundant numbers

            // Check if any of the previously gathered abundant numbers
            // could be added together to create i
            if(!abundantSum(i))
                sum+=i;
        }
        return sum;
    }
    private static boolean isAbundant(int num){
        HashSet<Integer> divisors = getDivisors(num); // maybe not the most efficient
        int sum = 0;
        for(Integer i : divisors)
            sum+=i;

        if(sum>num)
            return true;

        return false;
    }
    private static boolean abundantSum(int num){ // Maybe not the most efficient
        for(Integer a: abundantNums){
            if(abundantNums.contains(num-a))
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println("Sum of all the positive integers that are not the sum of two abundant numbers: "
                +sumPositiveNonAbundant()); // 4179871
    }

}
