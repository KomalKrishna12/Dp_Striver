import java.util.*;
public class Q4_Frog_jump_with_k_distance {
    public static int solve(int n, int k, int[] dp){
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];
        int minStep = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++){
            if(n-i >= 0){
            int jump = solve(n - i, k, dp) + Math.abs(dp[n] - dp[n-i]);
            minStep = Math.min(jump, minStep);
            }
        }
        return dp[n] = minStep;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // total no of steps

        int[] heights = new int[n];
        for(int i = 0; i < n; i++) heights[i] = scn.nextInt(); // energy required on n steps
        int k = scn.nextInt(); // jumps which are possibls
        scn.close();

        // memoization
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(solve(n-1, k, dp));

    }
}
