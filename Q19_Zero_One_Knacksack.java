public class Q19_Zero_One_Knacksack {
    public static int f(int idx, int capacity, int[] wt, int[] val){

        if(idx == 0){
            if(wt[idx] <= capacity) return val[idx];
            return 0;
        }

        int nottake = 0 + f(idx - 1, capacity, wt, val);

        int take = Integer.MIN_VALUE;
        if(wt[idx] <= capacity) take = val[idx] + f(idx - 1, capacity - wt[idx], wt, val);

        return Math.max(take, nottake);

    }
    public static void main(String[] args) {
        int wt[] = { 1, 2, 4, 5 };
        int val[] = { 5, 4, 8, 6 };
        int W = 5;

        int n = wt.length;

        System.out.println(f(n-1, W, wt, val));
    }
}
