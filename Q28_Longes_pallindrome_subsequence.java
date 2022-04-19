// in this problem we have given a string s1 we have to give the length of longest subsequence which is 
// pallindrome
// to solve this we were using same approach of longest common subsequence in which we have two strings
// so we create another string and set it as reverse of string s1 which is given and pass both in
// longest common subsequence problem it'll return length of longest substring
public class Q28_Longes_pallindrome_subsequence {

    public static int lowestCommonSubsequence(int n, String s, String t){

        int[][] dp = new int[n+1][n+1];

        for(int idx1 = 1; idx1 <= n; idx1++){

            for(int idx2 = 1; idx2 <= n; idx2++){

                if(s.charAt(idx1 - 1) == t.charAt(idx2 - 1)) dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];

                else dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);

            }

        }

        return dp[n][n];

    }

    public static void main(String[] args) {
        
        String s= "bbabcbcab";

        String t = ""; // store s into reverse form

        for(int i = s.length() - 1; i >= 0; i--) t += s.charAt(i);

        int n = s.length(); // both string length is same

        System.out.println(lowestCommonSubsequence(n, s, t));

    }

}
