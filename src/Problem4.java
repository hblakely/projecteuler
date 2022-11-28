public class Problem4 {
    //*********** https://projecteuler.net/problem=4 **********//
    // Find the largest palindrome made from the product of two 3-digit numbers.
    public static int largestPalindromeProductThreeDigit(){
        int largestPalindrome=0; // if we return 0, no answer is found.
        for (int i=999; i>=100; i--) { // 100-999 (three digit numbers).
            for (int j = i; j>=100; j--) { // initialize j as i to prevent duplicate products.
                int product = i * j; // 993 * 913 = 906609
                // A palindrome is found at i=995, that is smaller than the largest palindrome at i=993
                // Must loop through i-values to find largest palindrome for each i, and compare to the previously found palindrome
                if (isPalindrome(product)&&product>largestPalindrome) { // largest product that is a palindrome for each i value
                    largestPalindrome = product;
                    break; // Prevent unnecessary calculations for the rest of the j values.
                }
            }
        }
        return largestPalindrome;
    }
    private static boolean isPalindrome(int num){
        int reverse=0;
        int number=num;
        while(number!=0){ // repeated integer division by 10 will eventually reduce number to 0.
            int digit = number%10; // number modulo 10 gives right most digit
            reverse = reverse*10+digit; // multiply reverse by 10 to shift digits left by 1 place
            number=number/10; // integer division by 10 pops rightMost digit from num
        }
        if(num==reverse) // a palindrome is a number that is the same as its reversed digits.
            return true;
        return false;
    }
    //*********** https://projecteuler.net/problem=4 **********//
}
