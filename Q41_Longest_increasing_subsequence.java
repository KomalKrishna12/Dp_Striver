// in this ques we have given an array and w have to find out the length of longest increasing subsequence
// we use same take not take approch and we use a prev_idx to compare the curr idx
// bcoz we need subsequence in increasing order
public class Q41_Longest_increasing_subsequence {

    public static int f(int idx, int prev_idx, int[] arr, int n) {

        if (idx == n)
            return 0;

        // not take case
        // so 0 length taken and prev_idx will be same
        int len = 0 + f(idx + 1, prev_idx, arr, n);

        // for take check that the curr idx val is greater than prev idx val or not or
        // if
        // prev_idx == -1 than also take bcoz it's first idx
        if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
            len = Math.max(len, 1 + f(idx + 1, idx, arr, n));
        }

        return len;

    }

    public static int f2(int idx, int prev_idx, int[] arr, int n, Integer[][] dp) {

        if (idx == n)
            return 0;

        if (dp[idx][prev_idx + 1] != null)
            return dp[idx][prev_idx + 1];

        int len = 0 + f2(idx + 1, prev_idx, arr, n, dp);

        if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {

            len = Math.max(len, 1 + f2(idx + 1, idx, arr, n, dp));

        }

        return dp[idx][prev_idx + 1] = len;

    }

    public static void main(String[] args) {

        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int n = arr.length;

        // recursion
        // System.out.println(f(0, -1, arr, n));
        // for prev_idx we start from -1 but in array their is no idx like -1 so we do
        // shifting of 1
        // so treat idx as idx+1

        // memoization
        // Integer[][] dp = new Integer[n][n+1];
        // System.err.println(f2(0, -1, arr, n, dp));

        // tabulation
        // int[][] dp = new int[n + 1][n + 1];
        // for (int idx = n - 1; idx >= 0; idx--) {

        //     // prev are the idexes just before idx so start from idx-1 till -1 and for dp use second idx +1
        //     // bcoz it can't be -1
        //     for (int prev_idx = idx - 1; prev_idx >= -1; prev_idx--) {

        //         int len = 0 + dp[idx + 1][prev_idx + 1];

        //         if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {

        //             len = Math.max(len, 1 + dp[idx + 1][idx + 1]);

        //         }

        //         dp[idx][prev_idx + 1] = len;

        //     }

        // }

        // System.out.println(dp[0][-1 + 1]);

        int[] dp = new int[n + 1];
        int[] curr = new int[n + 1];
        for (int idx = n - 1; idx >= 0; idx--) {

            // prev are the idexes just before idx so start from idx-1 till -1 and for dp use second idx +1
            // bcoz it can't be -1
            for (int prev_idx = idx - 1; prev_idx >= -1; prev_idx--) {

                int len = 0 + dp[prev_idx + 1];

                if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {

                    len = Math.max(len, 1 + dp[idx + 1]);

                }

                curr[prev_idx + 1] = len;

            }

            dp = curr;

        }

        System.out.println(dp[-1 + 1]);

    }

}