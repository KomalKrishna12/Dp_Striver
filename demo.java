import java.util.*;

public class demo {
    public static void f(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        f(i + 1, n);
    }

    public static void f2(int i, int n) {
        if (i > n)
            return;

        System.out.println(i + ". Komal");
        f2(i + 1, n);
    }

    public static void f3(int i, int n){
        if(n < i) return;

        System.out.println(n);
        f3(i, n-1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        // printt countt from 1 to n
        // f(1, n);

        // print your name n times
        // f2(1, n);

        // print from n to 1
        // f3(1, n);

        // print from n to 1 by backtracking
        f4(1, n);

    }

    public static void f4(int i, int n){
        if(i > n) return;
        f4(i+1, n);
        System.out.println(i);
    }
}