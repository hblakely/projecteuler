import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem17 {
    /*
    Number letter counts
    Problem 17
    If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are
    3 + 3 + 5 + 4 + 4 = 19 letters used in total.

    If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many
    letters would be used?


    NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains
    23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing
    out numbers is in compliance with British usage.
     */

    private static String[] ones =
            {"","one","two","three","four","five","six","seven","eight","nine", "ten","eleven",
                    "twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};

    private static String[] tys =
            {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

    public static int numberLetterCounts(int num){
        if(num<0 || num >1000) // currently only supporting 1-1000
            return 0; // Maybe I'll handle negative ints later.

        int count = 0; // count of chars for each number  1...num (inclusive)
        for(int i = 1; i<=num; i++){
            count+=getCountForNum(i);
        }

        return count;
    }
    private static int getCountForNum(int num){
        String numberWords = "";
        int thousands = num/1000;
        num=num%1000;
        int hundreds = num/100;
        num=num%100;
        int tens = num/10;
        num=num%10;
        int digit = num;
        int combined = tens*10+digit;

        if(thousands>=1) {
            numberWords += ones[thousands];
            numberWords += "thousand";
        }

        if(hundreds>=1){
            numberWords += ones[hundreds];
            numberWords += "hundred";
        }

        if((thousands>=1 || hundreds >=1) && (combined>=1))
            numberWords+="and";

        if(tens>1) {
            numberWords += tys[tens];
            numberWords += ones[digit];
        }
        else
            numberWords+=ones[combined];

        return numberWords.length();
    }

    public static void main(String[] args){
        System.out.println
                ("Combined length of words representing each number from 1 to 1000: "+
                        numberLetterCounts(1000)); // 21124
    }


}
