public class Q52_Partioning_Array_for_Max_sum {
    public static int f(int i, int[] arr, int k){
        if(i == arr.length) return 0;

        int len = 0;
        int maxInPartion = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for(int idx = i; idx < Math.min(arr.length, i+k); idx++){
            len++;
            maxInPartion = Math.max(maxInPartion, arr[idx]);
            int sum = len * maxInPartion + f(idx + 1, arr, k);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        System.out.println(f(0, arr, k));
    }
}
