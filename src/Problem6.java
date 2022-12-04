public class Problem6 {
    /*
    The sum of the squares of the first ten natural numbers is,
    1^2 +...+ 10^2 = 385
    The square of the sum of the first ten natural numbers is,
    (1+2+...+10)^2 = 3025
    Hence the difference between the sum of the squares of the first ten natural
    numbers and the square of the sum is 3025-385=2640.

    Find the difference between the sum of the squares of the first one hundred
    natural numbers and the square of the sum.
    (1^2+2^2+...+100^2) - (1+2+...+100)^2 = ?
     */
    public static long sumSquare(int n){
        /*######################## Mathematical PROOFS: ########################*/
        // sumOfNaturalNumbers = n(n+1)/2
        // https://www.trans4mind.com/personal_development/mathematics/series/sumNaturalNumbers.htm
        //
        // sumOfNaturalSquares = (n(n+1)(2n+1))/6
        // https://www.trans4mind.com/personal_development/mathematics/series/sumNaturalSquares.htm
        /*######################################################################*/
        long sum = n*(n+1)/2;
        long squared = (n*(n+1) * (2*n+1)) / 6;
        return (sum*sum)-squared;
    }

    // Brute force came to mind first.
    public static long sumSquareBruteForce(int n){
        long sum = 0, square = 0;
        for(int i = 1; i<=n; i++){  // From 1 to n Natural numbers:
            sum+=i;                 // Add to sum, and square after loop.
            square+=i*i;            // Add the square of i.
        }
        return (sum*sum)-square; // Difference of sum-squared and sum-of-squares.
    }
}
