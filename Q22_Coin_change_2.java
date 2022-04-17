public class Q22_Coin_change_2 {

    public static long f(int idx, int tar, int[] arr){

        if(idx == 0){
            if(tar % arr[0] == 0) return 1;
            return 0; 
        }

        long nottake = f(idx - 1, tar, arr);

        long take = 0;
        if(arr[idx] <= tar) take = f(idx, tar - arr[idx], arr);

        return take + nottake;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int target = 4;

        int n = arr.length;

        // recursion
        System.out.println(f(n-1, target, arr));
    }
}
