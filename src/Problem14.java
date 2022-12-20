import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem14 {
    /*
    https://projecteuler.net/problem=14
    The following iterative sequence is defined for the set of positive integers:

    n → n/2 (n is even)
    n → 3n + 1 (n is odd)

    Using the rule above and starting with 13, we generate the following sequence:

    13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
    It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
    Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

    Which starting number, under one million, produces the longest chain?
    NOTE: Once the chain starts the terms are allowed to go above one million.
     */


    public static int longestCollatzSequence(){ // 837799 start number, 525 chain size.
        int longestCollatzSequence = 0, startNumber = 0;
        for (int i=1; i<1000000; i++) {
            int chainLength=1;
            long j = i; // j had to be a long to avoid overflow.
            while(j>1){
                j = (j % 2 == 0)? j/2: 3*j+1;
                chainLength++;
            }
            if(chainLength>longestCollatzSequence){
                startNumber = i;
                longestCollatzSequence = chainLength;
            }
        }
        return startNumber;
    }

    public static void main(String[] args){
        System.out.println("Longest Collatz Chain Initiated Under 1 million: "+longestCollatzSequence());
    }

    /*
    Using Memoization with a HashMap slowed us down and increased memory usage massively.
    time with memoization: 2.2-3seconds, memory with memoization: 240+mb
    time without memoisation: 0.6seconds, memory without memoizatin: 0-2mb
    I was originally going to try memo with an int[]. I was unsure at what length
    to initialize the array, because the number can go higher than the starting #.
    Also, I had to change j to a long to avoid an overflow, and initializing an array
    only allowed me to use Integer.MaxValue as its size.

    public static int longestCollatzSequence(){ // 837799 start number, 525 chain size.
        Map<Integer,Integer> memo = new HashMap<>(); // Dynamic Programming Memoization.
        int longestCollatzSequence = 0, startNumber = 0;
        for (int i=1; i<1000000; i++) {
            int chainLength=1;
            long j = i; // j had to be a long to avoid overflow.
            while(j>1){
                if(memo.get(j)==null) {
                    j = (j % 2 == 0)? j/2: 3*j+1;
                    chainLength++;
                }else{
                    chainLength = chainLength+memo.get(j)-1;
                    break;
                }
            }
            memo.put(i,chainLength);
            if(chainLength>longestCollatzSequence){
                startNumber = i;
                longestCollatzSequence = chainLength;
            }
        }
        return startNumber;
    }
     */
}
