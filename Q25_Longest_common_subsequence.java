public class Q25_Longest_common_subsequence {

    public static int f(int idx1, int idx2, String s1, String s2){

        if(idx1 < 0 || idx2 < 0) return 0;

        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return 1 + f(idx1-1, idx2-1, s1, s2);
        }

        return Math.max(f(idx1-1, idx2, s1, s2), f(idx1, idx2-1, s1, s2));

    }

    public static void main(String[] args) {

        String s1 = "acd";
        String s2 = "ced";

        int n = s1.length();
        int m = s2.length();

        System.out.println(f(n-1, m-1, s1, s2));

    }

}
