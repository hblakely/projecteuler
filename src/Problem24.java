import java.util.*;

public class Problem24 {
    /*
    Lexicographic permutations

    A permutation is an ordered arrangement of objects. For example, 3124 is one possible
    permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically
    or alphabetically, we call it lexicographic order. The lexicographic permutations of
    0, 1 and 2 are:

    012   021   102   120   201   210

    What is the millionth lexicographic permutation of the digits
    0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
     */
    // First thoughts: There are millions of permutations of 0-9.
    // I'm not sure how I'd use recursion to return exactly the millionth permutation in lexicographic
    // order without first going through all of the permutations.
    // How to iterate through permutations lexicographically seems to be the question to answer.

    public static String permuteDigits() {
        // Initialize the permutation with the lowest possible value
        int[] permutation = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<int[]> permutations = new ArrayList<>();
        while (true) {
            int[] p = permutation.clone();  // get current permutation
            permutations.add(p);            // add current permutation to list

            // Find the rightmost element that is smaller than its successor
            int i = permutation.length - 2;
            while (i >= 0 && permutation[i] > permutation[i + 1])
                i--;
            // If no such element exists, this is the last permutation
            if (i < 0)
                break;

            // Find the successor to the right of the pivot
            int j = permutation.length - 1;
            while (permutation[j] < permutation[i])
                j--;

            // Swap the pivot with its successor
            int temp = permutation[i];
            permutation[i] = permutation[j];
            permutation[j] = temp;

            // Reverse the suffix
            for (int k = i + 1, l = permutation.length - 1; k < l; k++, l--) {
                temp = permutation[k];
                permutation[k] = permutation[l];
                permutation[l] = temp;
            }
        }
        String s =  "";
        permutation = permutations.get(999999); // 1 millionth permutation.
        for(int i = 0; i<permutation.length; i++) // build return string
            s+=""+permutation[i];

        return s;
    }

    public static void main(String[] args) {
        System.out.println(permuteDigits());
    }


    /*
    CHATGPT:

    I asked ChatGPT What is the 1000000th permutation of the digits 0123456789 in lexicographic order?

    The first $9!=362,!880$ permutations start with 0, the next $8!=40,!320$ start with 1, etc. Therefore,
    the 1000000th permutation starts with 2. The first $7!=5040$ permutations starting with 2 are 2 followed by
    the permutations of 01345678. The next $6!=720$ permutations starting with 2 are 3 followed by the permutations
    of 0145678. Therefore, the 1000000th permutation starts with 23. Continuing in this manner, we find that the
    1000000th permutation is [\boxed{2783915460}.]

    The answer was correct. This is a little intimidating.

    ##############################################################################################################
    Then I asked it to write a program that would generate permutations of the digits 0123456789 in lexicographic
    order:

    One way to generate permutations of digits in lexicographic order is to use a recursive algorithm.
    Here is some pseudocode for such an algorithm:

    function permute(digits):
        if the length of digits is 1:
            output digits
        else:
            for each digit in digits:
                create a list of all the digits except the current one
                permute the list of remaining digits
                output the current digit followed by the permuted list of remaining digits


    For example, to generate the permutations of 0123, we would start by calling permute([0, 1, 2, 3]).
    This would loop through the digits 0, 1, 2, and 3. For each digit, it would create a list of the remaining
    digits (e.g., for the digit 0, it would create the list [1, 2, 3]), and then call permute on this list.
    The recursive call to permute would eventually reach a point where the length of the list is 1, at which
    point it would output the single digit. The original call to permute would then output the current digit
    followed by the permuted list of remaining digits.

    This algorithm will generate the permutations in lexicographic order because it always outputs the current
    digit before the permuted list of remaining digits. The lexicographic order is determined by the order in
    which the digits are listed, and this algorithm always lists the current digit first.
     */

}
