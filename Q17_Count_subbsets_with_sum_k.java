// this is similar ques like Q14 in that ques we have to return true if their exists any subsets with sum k
// here we have to return count so use 1 and 0 instead of true and false
// and pick & nonpick will be same but add both of them so it'll denotes count

public class Q17_Count_subbsets_with_sum_k {

    public static int f(int idx, int tar, int[] arr){
        if(tar == 0) return 1;
        if(idx == 0) return arr[idx] == tar ? 1 : 0;

        int nottake = f(idx - 1, tar, arr);

        int take = 0;
        if(arr[idx] <= tar) take = f(idx - 1, tar - arr[idx], arr);

        return take + nottake;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3 };
        int k = 3; // target
        
        // recursion
        int n = arr.length;
        System.out.println(f(n-1, k, arr));
    }
}
