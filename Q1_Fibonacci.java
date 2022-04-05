import java.util.Arrays;

public class Q1_Fibonacci{

    // memoization
    // we have an array dp[n] in which by default fill with -1
    // if n is less than equal to 1 then return n
    // if dp[n] is not equal to -1 that means we already have that fibonacci
    // at end return for n-1 and n-2
    public static int fun(int n, int[] dp){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = fun(n-1, dp) + fun(n-2, dp);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fun(n, dp));
    }
}