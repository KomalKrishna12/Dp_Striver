// we have given a matrix, we have to find the maximum path sum to reach destination
// destination is last row any col
// starting from 1st row any col
// so basically we have starting and ending both points are variable so we start loop
// get max path sum in between col 0 to end
public class Q12_Max_min_falling_path_sum {

    public static int helper(int i, int j, int[][] matrix) {
        // for straight i will be corrent
        // but for left and right diag their is possibility that col can go out of bound
        if(j < 0 || j >= matrix[0].length) return -(int)Math.pow(10, 9);
        if(i == 0) return matrix[0][j];
        
        // these are the three calls
        // to go straight col will be same, row will decrease
        // to go in left diag col and row both will decrease
        // to go in right diag col will increase and row will decrease
        int straight = matrix[i][j] + helper(i - 1, j, matrix);
        int leftdiag = matrix[i][j] + helper(i - 1, j - 1, matrix);
        int rightdiag = matrix[i][j] + helper(i - 1, j + 1, matrix);

        return Math.max(straight, Math.max(leftdiag, rightdiag));
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,10,4},
                    {100,3,2,1},
                    {1,1,20,2},
                    {1,2,2,1}};

        int m = matrix.length;
        int n = matrix[0].length;
        
        // recursion
        // maxi variable will compare max path sum for starting from each j = 0 to n-1
        int maxi = -(int)Math.pow(10, 9);

        for(int j = 0; j < n; j++){
            maxi = Math.max(maxi, helper(m-1, j, matrix));
        }

        System.out.println(maxi);
    }
}
