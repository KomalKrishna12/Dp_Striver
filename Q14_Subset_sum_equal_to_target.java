// given n size of array, and all elements of array is given
// k is the target we want to get with the help of subset of array 
// if their exist any one subset whose sum is k then return true else return false
public class Q14_Subset_sum_equal_to_target {

    public static boolean f(int idx, int target, int[] arr){
        // base case
        // when f(n-1, tar) given that means we have given array till n-1 and we need to check is their
        // any subset exist with target tar
        // f(0, tar) that means we have given a one size array so if that arr[0] == tar then return true
        // in any case if our tar become 0 then also return true, no need to go till 0th idx
        if(target == 0) return true;
        if(idx == 0){
            // if(arr[0] == target) return true;
            // else return false;
            // these two lines can also be written in one line
            return arr[0] == target;
        }

        // now for creating subset we have two options
        // either we can take this arr[idx] element or not 
        // if taking then only idx will decrease, target will be same
        boolean nottake = f(idx - 1, target, arr);

        // now if we want to take that arr[idx] element then we have to check first
        // if arr[idx] is less than or equal to target then only we can take this
        // if arr[idx] is greater than target then their is no need to take the element
        // if we are taking the arr[idx] then subtract arr[idx] from target that means
        // here we acheive arr[idx] ans rest target we want to find
        boolean take = false;
        if(arr[idx] <= target) take = f(idx - 1, target - arr[idx], arr);

        return take || nottake;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 4; // target
        int n = arr.length;

        System.out.println(f(n-1, k, arr));
    }
}
