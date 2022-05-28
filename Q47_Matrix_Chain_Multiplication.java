public class Q47_Matrix_Chain_Multiplication {
    public static int f(int i, int j, int[] arr){

        if(i == j) return 0;

        int mini = (int)1e9;

        for(int k = i; k < j; k++){

            int steps = (arr[i-1] * arr[k] * arr[j]) + f(i, k, arr) + f(k+1, j, arr);

            mini = Math.min(mini, steps);

        }

        return mini;

    }
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int n = arr.length;

        System.out.println(f(1, n-1, arr));
    }
}
