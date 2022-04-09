import java.util.Scanner;

// in this question we have given a m*n grid we are at top left and we've to reach bottom right
// we can mode in two directions either right or down
// we have to find total no of unique paths to reach the destination
// so we start from bottom so we can move either left or up
public class Q8_Grid_unique_path {
    public static int helper(int i, int j){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        int up = helper(i-1, j);
        int left = helper(i, j - 1);
        return up + left;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        scn.close();
        // recursion
        // pass m-1 and n-1 in ith and jth index and start travelling through destination which is (0,0)
        // if i and j is at 0 then return 1 that means we got one path
        // if any one going outside the boundary then return 0 that means no result
        // now call for up in up row will decrease by 1
        // call for left in left col will decrease by 1
        // at end return addition of both bcoz we can get path in up also and in left also
        System.out.println(helper(m-1, n-1));
    }
}
