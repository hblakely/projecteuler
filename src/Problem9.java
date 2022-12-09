public class Problem9 {
    /**
     * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
     *
     * a2 + b2 = c2
     * For example, 32 + 42 = 9 + 16 = 25 = 52.
     *
     * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
     * Find the product abc.
     */
    public static int productOfPythagoreanTriplet(){
        /*
        a+b+c=1000
        c=1000-a-b

        a^2+b^2=c^2
         */
        // Brute force came to mind first.
        for (int a =1; a<1000; a++){ // I realized afterwards that a would never get to 1000
            for(int b = a+1; b<1000; b++) { // Euclidean equations made me realize that I could have just counted to 500.
                int c = 1000 - a - b;
                if (a*a + b*b == c*c)
                    return a * b * c;
            }
        }
        return -1;
    }

    public static void main(String[]args){
        System.out.println(productOfPythagoreanTriplet());
    }

    /* https://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple
        #################### Euclidean generation ####################
        Admittedly, my mathematical skills are rusty.
        I'll have to retrain all of my math skills to feel comfortable providing
        proofs for the following:
        ##############################################################
        # https://stackoverflow.com/questions/2817848/find-pythagorean-triplet-for-which-a-b-c-1000
        # a*a + b*b = c*c
        # a+b+c = 1000.
        # You can deduce the following relation
        # a = (1000*1000-2000*b)/(2000-2b)
        # or after two simple math transformations, you get:
        # a = 1000*(500-b) / (1000 - b)
        #
        # Since a must be an natural number, the complexity can be reduced to:
        #
        # for b in range(1, 500):
        #    if 1000*(500-b) % (1000-b) == 0:
        #        print b, 1000*(500-b) / (1000-b)
        #
        # The above code would give the values: 200, and 375
        # 200^2 + 375^2 = c^2
        # 40000 + 140625 = c^2
        # 180625 = c^2
        # 425 = c
        #
        # Answer to Problem9: 200*375*425 = 31875000
        #############################################################
        */
}
