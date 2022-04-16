// this is similar ques like count partition with given difference
// we have given a target we can use two signs + or - if we assign positive that means we have to add them
// if - that means we have to subtract so by adding all our array will divide in two subsetrs s1 - s2 = d
// and this is similar ques like Q18 
public class Q21_Target_sum {

    public static int f(int idx, int tar, int[] arr){

        if(idx == 0){
            if(tar == 0 && arr[idx] == 0) return 2;

            if(tar == 0 || arr[idx] == tar) return 1;

            return 0;
        }

        int nottake = f(idx-1, tar, arr);

        int take = 0;
        if(arr[idx] <= tar) take = f(idx-1, tar-arr[idx], arr);

        return take + nottake;

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 1 };
        int target = 3;

        int n = arr.length;

        int totalsum = 0;
        for(int val : arr) totalsum += val;

        if(totalsum - target < 0 || (totalsum - target) % 2 == 1) System.out.println(0);
        else System.out.println(f(n-1, (totalsum - target) / 2, arr));

    }
}
