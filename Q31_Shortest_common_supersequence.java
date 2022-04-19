public class Q31_Shortest_common_supersequence {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int idx1 = 1; idx1 <= n; idx1++){

            for(int idx2 = 1; idx2 <= m; idx2++){

                if(s1.charAt(idx1-1) == s2.charAt(idx2-1)){

                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
 
                }

                else {

                    dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);

                }

            }

        }

        String ans = "";

        int i = n, j = m;

        while(i > 0 && j > 0){

            if(s1.charAt(i-1) == s2.charAt(j-1)){

                ans = s1.charAt(i-1) + ans;
                i--;
                j--;

            }

            else if(dp[i-1][j] > dp[i][j-1]){

                ans = s1.charAt(i-1) + ans;
                i--;

            }

            else {

                ans = s2.charAt(j-1) + ans;
                j--;

            }

        }

        while(i > 0){

            ans = s1.charAt(i-1) + ans;
            i--;

        }

        while(j > 0){

            ans = s2.charAt(j-1) + ans;
            j--;

        }

        System.out.println(ans);

    }
}
