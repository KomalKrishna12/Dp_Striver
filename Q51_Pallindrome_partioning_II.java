public class Q51_Pallindrome_partioning_II {
    public static boolean isPallindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static int f(int i, int n, String s){
        if(i == n) return 0;

        int min = Integer.MAX_VALUE;

        for(int j = i; j < n; j++){
            if(isPallindrome(i, j, s)){
                int cuts = 1 + f(j+1, n, s);
                min = Math.min(min, cuts);
            }
        }

        return min;
    }
    public static void main(String[] args) {
        String str = "aab";
        int n = str.length() - 1; 
        System.out.println(f(0, n-1, str));
    }
}
