// we have given an array of size n, we have to divide the array in two subsets
// so that the diff between sum of both subset is minimum
// so use Q14 concept in which we used subset sum equal to target
// here sum is total sum (sum of all elements) pass this as target
// so in the last row of dp we have true or false which deotes that till n-1 row we can
// get target from 0 to target or not
// like dp[n-1][tar] denotes till n-1 row we can make target or nott
// so dp[i][tar] denotes that till ith index we can make target or not
// so use that last row of dp 
// suppose s1 is sum of subset 1 and total sum is ts so we find s2(subset of second subset) using ts - s1
// and find abs of (ts-s1) - s1
public class Q16_Partition_into_two_subsets_with_abs_sum_diff_min {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int n = arr.length;

        int totsum = 0;
        for (int val : arr)
            totsum += val;

        int k = totsum;
        boolean[][] dp = new boolean[n][totsum + 1];
        // fill all 0th col as true bcoz we can achieve target 0 without takin any
        // elemens
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int idx = 1; idx < n; idx++) {

            for (int tar = 1; tar <= k; tar++) {

                boolean nottake = dp[idx - 1][tar];

                boolean take = false;
                if (arr[idx] <= tar)
                    take = dp[idx - 1][tar - arr[idx]];

                dp[idx][tar] = take || nottake;

            }

        }

        int mini = (int) Math.pow(10, 9);
        for (int s1 = 0; s1 <= k; s1++) {
            if (dp[n - 1][s1] == true) {
                int diff = Math.abs((totsum - s1) - s1);
                mini = Math.min(mini, diff);
            }
        }

        System.out.println(mini);
    }
}
