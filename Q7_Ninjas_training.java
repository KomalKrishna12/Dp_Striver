import java.util.Arrays;
import java.util.Scanner;

// some ninjas are in training of n days where they have to trains in 3 practices
// if at day1 he practice first skill then on next day he cannot practice same skill
// so non adjacent type
// so we have given a points array which is 2d row represents days o training and column
// are 3 bcoz we have three skills training with their marks
// we have to find in n days a ninja can take training so he can earn max points
public class Q7_Ninjas_training {
    public static int helper(int day, int last, int[][] points){
        // base case when day is 0 that means we are at last day and in last we have idx which
        // we used in previous day so don't use that index
        if(day == 0){
            int maxi = 0;
            for(int i = 0; i < 3; i++){
                // if we perform ith task on this day then compare max and return and make sure we
                // are not using last task
                if(i != last) maxi = Math.max(maxi, points[day][i]); 
            }
            return maxi;
        }

        // in rest day we have same options but here we can perform todays task and pass ith index
        // so in next day that ith task will not perform
        int maxi = 0;

        for(int i = 0; i < 3; i++){
            if(i != last){
                int point = points[day][i] + helper(day - 1, i, points);
                maxi = Math.max(maxi, point);  
            }
        }

        return maxi;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // days 
        int[][] points = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                points[i][j] = scn.nextInt();
            }
        }
        scn.close();
        // so we start at n-1 days and first time w have 3 options available but we are using 0 based 
        // indexing so index will be 0 to 2 but we give 3 that means we have all options from 0 to 2 
        // are available
        // System.out.println(helper(n-1, 3, points));

        // now we can solve this using memoization
        // but in recursion we are using two variables daya and last so we have to create 2D array
        // row size will be n and col size will be 4, 4 bcoz we have 3 skills from 0 to 2 and we have option
        // 3 that means we haven't use any task 
        int[][] dp = new int[n][4];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(helper2(n-1, 3, points, dp));
        
    }

    public static int helper2(int day, int last, int[][] points, int[][] dp){
        // base case when day is 0 that means we are at last day and in last we have idx which
        // we used in previous day so don't use that index
        if(day == 0){
            int maxi = 0;
            for(int i = 0; i < 3; i++){
                // if we perform ith task on this day then compare max and return and make sure we
                // are not using last task
                if(i != last) maxi = Math.max(maxi, points[day][i]); 
            }
            return maxi;
        }

        if(dp[day][last] != -1) return dp[day][last];

        // in rest day we have same options but here we can perform todays task and pass ith index
        // so in next day that ith task will not perform
        int maxi = 0;

        for(int i = 0; i < 3; i++){
            if(i != last){
                int point = points[day][i] + helper2(day - 1, i, points, dp);
                maxi = Math.max(maxi, point);  
            }
        }

        return dp[day][last] = maxi;
    }
}
