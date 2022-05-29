import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q48_Min_Cost_to_Cut_a_Stick{
    public static int f(int i, int j, ArrayList<Integer> list, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
        for(int idx = i; idx <= j; idx++){
            int cuts = list.get(j+1) - list.get(i-1) + f(i, idx-1, list, dp) + f(idx+1, j, list, dp);
            mini = Math.min(mini, cuts);
        }
        return dp[i][j] = mini;
    }
    public static void main(String[] args) {
        int[] cuts = {1,3,4,5};
        int n = 7; // length of stick
        int c = cuts.length;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        for(int i = 0; i < c; i++) list.add(cuts[i]);

        list.add(n);
        Collections.sort(list);

        int[][] dp = new int[c+1][c+1];
        for(int i = 0; i <= c; i++) Arrays.fill(dp[i], -1);

        System.out.println(f(1, c, list, dp));
    }
}