import java.util.Scanner;

public class fib {

    public static int fibRecursive(int n){
        if (n<=1){
            return n;
        }
        else return fibRecursive(n-1) + fibRecursive(n-2);
    }

    public static int fibIterative(int n){
        if (n<=1){
            return n;
        }
        int fibcur = 1;
        int prev = 1;
        for (int i = 2; i<n; i++) {
            int temp = fibcur;
            fibcur += prev;
            prev = temp;
        }
        return fibcur;
    }

    public static void main(String args[]){
        System.out.println("Enter a number n to get the n'th fibonacci number:");
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        System.out.println("The recursive fibonacci of " + n + " is: " + fibRecursive(n));
        System.out.println("The iterative fibonacci of " + n + " is: " + fibRecursive(n));
    }

}