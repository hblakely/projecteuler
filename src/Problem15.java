import java.math.BigInteger;
import java.util.Arrays;

public class Problem15 {
    /*
    Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
    there are exactly 6 routes to the bottom right corner.

    How many such routes are there through a 20×20 grid?
     */
    /* This is a classic dynamic programming problem.
       We'll use the grid as its own memo, cumulatively storing calculations
       until we get to the end, which will be a summation of possible routes.

       To determine the number of possible paths to reach a cell, one can sum the
       possible paths from each of the cells that approach that cell.

       A cell can be approached either from above, or from the left, meaning we can
       determine the number of routes to a cell by adding the left-cell's # and the above-cell's
       # of possible routes to get the total number of possible routes to the current cell.

       Starting at 0,0 the number would be 1 because you have no alternatives ways to get there.

        Each cell in the top row only has one direction from which to access that cell.
        Each cell in the leftmost column similarly can only be reached from one path.
        We begin by setting each of those cells to 1. We then loop, adding route possibilities
        as described above.

        This memoized approach of storing calculations to be used for future calculations prevents
        increasing complexity.

        Complexity analysis:
        Time complexity O(n*m)
        Space complexity O(n*m)
        Where n is number of rows, and m is number of columns.
     */

    // My first attempt I didn't realize that we were calculating the points of the cell, not the cell itself. 
    //  Normally there are 4 points to a cell, which would make you think that you should have 8 points for a 1x2 grid.
    //  That's not right, though; because the cells share points. I realized later that the 2x2 cell-grid was really a 
    //  3x3 point-grid. If a 2x2 grid was really 3x3 points, then a 20x20 grid would be 21x21 points. 
    // I adjusted my algorithm to add 1 to length and width of the grid and got the correct answer.
    // I used BigInteger to avoid overflow, and to make the algorithm reusable at different sizes. Example 100x100
    private static BigInteger one = new BigInteger("1");
    public static BigInteger uniqueLatticePaths(int m, int n){
        BigInteger[][] grid =  new BigInteger[m+1][n+1]; // Add one to calculate lattice (points), not cells.
        Arrays.fill(grid[0],one);

        for(int r=1; r<grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if(c==0) grid[r][c] = one;
                else grid[r][c] = grid[r-1][c].add(grid[r][c-1]);
            }
        }
        return grid[grid.length-1][grid[1].length-1];
    }

    public static void main(String[] args){
        System.out.println("Unique lattice paths moving only right or down in a 20x20 grid: "+
                uniqueLatticePaths(20,20)); // 137846528820
    }
}
