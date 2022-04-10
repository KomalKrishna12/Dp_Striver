// in this question we given a triangle in the ith row i+1 elements are their
// like for 0th we have 1 element, for 1th we have 2 elements
// we can traverse to down or diagonal means at (i+1, j) or (i+1,j+1)
// we have to reach last row, we can reach any col of last row
// so using these two stuffs we have to return minimum path to reach destination
// in prev questions we started from last row and col but here at end we have total n column
// so we have to use these n col to reach destination which is (0,0) so instead of
// calling for n coloumns we can start traversing from (0,0)
public class Q11_Triangle {

    public static int minimumPathSum(int i, int j, int[][] triangle, int n){

        if(i == n-1){
            return triangle[n-1][j];
        }

        int down = triangle[i][j] + minimumPathSum(i+1, j, triangle, n);

        int diagonal = triangle[i][j] + minimumPathSum(i+1, j+1, triangle, n);

        return Math.min(down, diagonal);

    }

    public static void main(String[] args) {

        int triangle[][] = { { 1 },
                { 2, 3 },
                { 3, 6, 7 },
                { 8, 9, 6, 10 } };

        int n = triangle.length;

        System.out.println(minimumPathSum(0, 0, triangle, n));

    }
}
