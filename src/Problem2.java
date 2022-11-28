public class Problem2 {
    //*********** https://projecteuler.net/problem=2 **********//
    // By considering the terms in the Fibonacci sequence whose values do not exceed four million,
    // find the sum of the even-valued terms.
    public static int evenFibonacci(){
        int previous =1;
        int current=2;
        int sum=0;

        while (current<4000000){ // follow Fibonacci sequence until value >= 4 million.
            if (current%2==0) // if current value is even
                sum+=current;

            current+=previous;
            previous=current-previous;
        }

        return sum;
    }
    //*********** https://projecteuler.net/problem=2 **********//
}
