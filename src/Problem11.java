public class Problem11 {
    // https://projecteuler.net/problem=11
    public static void main(String[] args){ // CORRECT: 70600674
        System.out.println("The greatest product of four adjacent numbers in the same direction: "+
                greatestProductOfFourAdjacentNumbers());
    }
   /* In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
   (I put stars near the numbers from the website).

            08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
            49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
            81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
            52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
            22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
            24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
            32 98 81 28 64 23 67 10 *26 38 40 67 59 54 70 66 18 38 64 70
            67 26 20 68 02 62 12 20 95 *63 94 39 63 08 40 91 66 49 94 21
            24 55 58 05 66 73 99 26 97 17 *78 78 96 83 14 88 34 89 63 72
            21 36 23 09 75 00 76 44 20 45 35 *14 00 61 33 97 34 31 33 95
            78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
            16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
            86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
            19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
            04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
            88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
            04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
            20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
            20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
            01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48

    The product of these numbers is 26 × 63 × 78 × 14 = 1788696.

    What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally)
    in the 20×20 grid?
    */

    // I copied the above 20x20 grid of integers into sublime text, ran find and replace "[0-9][0-9]" with "$0,", then removed
    // the last unecessary comma from the comma-separated grid. Those comma separated values will now be stored as a 1d
    // array of integers. Then, because many of the numbers started with 0, java was complaining. I removed the 0 from
    // the front of those numbers: "([0])([1-9])" replaced with "$2". 00 didn't upset the compiler.

    // The below final integers below allow us to treat our 1d array as a 2d grid.
    static final int  MIN_COLUMN=0, MAX_COLUMN = 20, MAX_ROW = 20, MIN_ROW = 0, GROUP_LENGTH = 4;
    public static int[] grid= {
            8,  2,  22,  97,  38,  15,  00,  40,  00,  75,  4,  5,  7,  78,  52,  12,  50,  77,  91,  8,
            49,  49,  99,  40,  17,  81,  18,  57,  60,  87,  17,  40,  98,  43,  69,  48,  4,  56,  62,  00,
            81,  49,  31,  73,  55,  79,  14,  29,  93,  71,  40,  67,  53,  88,  30,  3,  49,  13,  36,  65,
            52,  70,  95,  23,  4,  60,  11,  42,  69,  24,  68,  56,  1,  32,  56,  71,  37,  2,  36,  91,
            22,  31,  16,  71,  51,  67,  63,  89,  41,  92,  36,  54,  22,  40,  40,  28,  66,  33,  13,  80,
            24,  47,  32,  60,  99,  3,  45,  2,  44,  75,  33,  53,  78,  36,  84,  20,  35,  17,  12,  50,
            32,  98,  81,  28,  64,  23,  67,  10,  26,  38,  40,  67,  59,  54,  70,  66,  18,  38,  64,  70,
            67,  26,  20,  68,  2,  62,  12,  20,  95,  63,  94,  39,  63,  8,  40,  91,  66,  49,  94,  21,
            24,  55,  58,  5,  66,  73,  99,  26,  97,  17,  78,  78,  96,  83,  14,  88,  34,  89,  63,  72,
            21,  36,  23,  9,  75,  00,  76,  44,  20,  45,  35,  14,  00,  61,  33,  97,  34,  31,  33,  95,
            78,  17,  53,  28,  22,  75,  31,  67,  15,  94,  3,  80,  4,  62,  16,  14,  9,  53,  56,  92,
            16,  39,  5,  42,  96,  35,  31,  47,  55,  58,  88,  24,  00,  17,  54,  24,  36,  29,  85,  57,
            86,  56,  00,  48,  35,  71,  89,  7,  5,  44,  44,  37,  44,  60,  21,  58,  51,  54,  17,  58,
            19,  80,  81,  68,  5,  94,  47,  69,  28,  73,  92,  13,  86,  52,  17,  77,  4,  89,  55,  40,
            4,  52,  8,  83,  97,  35,  99,  16,  7,  97,  57,  32,  16,  26,  26,  79,  33,  27,  98,  66,
            88,  36,  68,  87,  57,  62,  20,  72,  3,  46,  33,  67,  46,  55,  12,  32,  63,  93,  53,  69,
            4,  42,  16,  73,  38,  25,  39,  11,  24,  94,  72,  18,  8,  46,  29,  32,  40,  62,  76,  36,
            20,  69,  36,  41,  72,  30,  23,  88,  34,  62,  99,  69,  82,  67,  59,  85,  74,  4,  36,  16,
            20,  73,  35,  29,  78,  31,  90,  1,  74,  31,  49,  71,  48,  86,  81,  16,  23,  57,  5,  54,
            1,  70,  54,  71,  83,  51,  54,  69,  16,  92,  33,  48,  61,  43,  52,  1,  89,  19,  67,  48};

    public static long greatestProductOfFourAdjacentNumbers(){
        // 1-based x,y grid values as if the array were a 1 based 2d array.
        int[] originIndex = new int[2];
        long product = 0, current;

        for (int i = 0; i<MAX_COLUMN*MAX_ROW; i++) { // loop through 0 bassed array
            originIndex = getGridLocation(i);
            int originX = originIndex[0];
            int originY = originIndex[1];
            boolean roomOnRight = (originX+GROUP_LENGTH)<=MAX_COLUMN;
            boolean roomOnLeft = (originX-GROUP_LENGTH)>=MIN_COLUMN;
            boolean roomBelow = (originY+GROUP_LENGTH)<=MAX_ROW;

            // getRight if not exceeding right boundary
            if(roomOnRight){
                current = rightProduct(originIndex);
                product = current>product?current:product;
            }

            // getDown if not exceeding bottom boundary
            if(roomBelow){
                current = belowProduct(originIndex);
                product = current>product?current:product;
            }

            // getDiaganolRightDown if not exceeding right or bottom boundary
            if(roomOnRight && roomBelow){
                current = diaganolRightDownProduct(originIndex);
                product = current>product?current:product;
            }

            // getDiaganolLeftDown if not exceeding left or bottom boundary
            if(roomOnLeft && roomBelow){
                current = diaganolLeftDownProduct(originIndex);
                product = current>product?current:product;
            }

            // All other checks would be redundant. Left is handled by right. Up is handled by down.
            // DiaganolLeftUp is handled by DiaganolRightDown. And DiaganolRightUp is handled by DiaganolLeftDown
        }
        return product;
    }

    public static int rightProduct(int[]num1){
        int one = 0, two = 0, three = 0, four = 0;
        int[] num2 = new int[2], num3 = new int[2], num4 = new int[2];

        one = getValueAtIndex(num1);
        num2 = getRight(num1);
        two = getValueAtIndex(num2);
        num3 = getRight(num2);
        three = getValueAtIndex(num3);
        num4 = getRight(num3);
        four = getValueAtIndex(num4);

        return one*two*three*four;
    }
    public static int belowProduct(int[]num1){
        int one = 0, two = 0, three = 0, four = 0;
        int[] num2 = new int[2], num3 = new int[2], num4 = new int[2];

        one = getValueAtIndex(num1);
        num2 = getDown(num1); // Uses current grid location to get next grid location.
        two = getValueAtIndex(num2);
        num3 = getDown(num2);
        three = getValueAtIndex(num3);
        num4 = getDown(num3);
        four = getValueAtIndex(num4);

        return one*two*three*four;
    }
    public static int diaganolRightDownProduct(int[]num1){
        int one = 0, two = 0, three = 0, four = 0;
        int[] num2 = new int[2], num3 = new int[2], num4 = new int[2];

        one = getValueAtIndex(num1);
        num2 = getDiaganolRightDown(num1); // Uses current grid location to get next grid location.
        two = getValueAtIndex(num2);
        num3 = getDiaganolRightDown(num2);
        three = getValueAtIndex(num3);
        num4 = getDiaganolRightDown(num3);
        four = getValueAtIndex(num4);

        return one*two*three*four;
    }
    public static int diaganolLeftDownProduct(int[]num1){
        int one = 0, two = 0, three = 0, four = 0;
        int[] num2 = new int[2], num3 = new int[2], num4 = new int[2];

        one = getValueAtIndex(num1);
        num2 = getDiaganolLeftDown(num1); // Uses current grid location to get next grid location.
        two = getValueAtIndex(num2);
        num3 = getDiaganolLeftDown(num2);
        three = getValueAtIndex(num3);
        num4 = getDiaganolLeftDown(num3);
        four = getValueAtIndex(num4);

        return one*two*three*four;
    }


    // ###################################################################################
    // Helper methods allow us to navigate the 20x20 grid from projecteuler.net/problem11
    private static int[] getGridLocation(int index){
        // Convert 0 based index of 1d array to 1 based indexes for 2d (20x20) array
        int i = index+1;
        int x = i%MAX_COLUMN==0?MAX_COLUMN:i%MAX_COLUMN;
        int y = (i/MAX_ROW)+1;
        return new int[]{x,y};
    }
    private static int getValueAtIndex(int[] xy){
        return getValueAtIndex(getIndex(xy));
    }

    // Not protecting against Index Out Of Bounds because we know the input will pass.
    private static int getValueAtIndex(int index){ // uses 0-based 1d array index.
        int val = grid[index];
        return val;
    }
    private static int getIndex(int[]xy){
        // x and y are 1-based grid locations.
        // getIndex translates these 1-based 2d locations into 0-based 1d array index.
        int x = xy[0]-1;
        int y = xy[1]-1;
        int index = x+(20*y);
        return index;
    }
    private static int[] getDiaganolRightDown(int[]xy){
        int x = xy[0]+1;
        int y = xy[1]+1;
        return new int[]{x,y};
    }

    private static int[] getDiaganolLeftDown(int[]xy){
        int x = xy[0]-1;
        int y = xy[1]+1;
        return new int[]{x,y};
    }
    private static int[] getDown(int[]xy){
        //I counted with origin of the array at top left,
        //so, adding one from the y-value gives the row down.
        int x = xy[0];
        int y = xy[1]+1;
        return new int[]{x,y};
    }
    private static int[] getRight(int[]xy){
        int x = xy[0]+1;
        int y = xy[1];
        return new int[]{x,y};
    }
    // ###################################################################################
}