public class Q50_Evaluate_boolean_expression_to_true {
    static int mod = 1000000007;
    public static int f(int i, int j, String s, int isTrue, Integer[][][] dp){
        if(i > j) return 0;
        if(i == j){
            if(isTrue == 1){
                return s.charAt(i) == 'T' ? 1 : 0;
            }
            else{
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }

        if(dp[i][j][isTrue] != null) return dp[i][j][isTrue];

        int ways = 0;

        for(int idx = i + 1; idx <= j - 1; idx += 2){
            int lt = f(i, idx - 1, s, 1, dp);
            int lf = f(i, idx - 1, s, 0, dp);
            int rt = f(idx + 1, j, s, 1, dp);
            int rf = f(idx + 1, j, s, 0, dp);

            if(s.charAt(idx) == '&'){
                if(isTrue == 1) ways += (lt * rt) % mod;
                else ways += (lf * rf) % mod + (lt * rf) % mod + (lf * rt) % mod;
            }
            else if(s.charAt(idx) == '|'){
                if(isTrue == 1) ways += (lt * rt) % mod + (lt * rf) % mod + (lf * rt) % mod;
                else ways += (lf * rf) % mod;
            }
            else{
                if(isTrue == 1) ways += (lt * rf) % mod + (lf * rt) % mod;
                else ways += (lt * rt) % mod + (lf * rf) % mod;
            }
        }
        
        return dp[i][j][isTrue] = ways;
    }
    public static void main(String[] args) {
        String s = "F|T^F";
        int j = s.length();

        Integer[][][] dp = new Integer[j][j][2];

        System.out.println(f(0, j-1, s, 1, dp));
    }
}
