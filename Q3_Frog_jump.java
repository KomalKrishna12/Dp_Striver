import java.util.*;
public class Q3_Frog_jump {

    public static int solve(int n, int[] dp, int[] heights){

        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];

        int left = solve(n-1, dp, heights) + Math.abs(heights[n] - heights[n-1]);
        int right = solve(n-2, dp, heights) + Math.abs(heights[n-2] - heights[n]);

        return dp[n] = Math.min(left, right);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] heights = new int[n];
        for(int i = 0; i < n; i++) heights[i] = scn.nextInt();
        scn.close();
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(solve(n, dp, heights));

    }
}
