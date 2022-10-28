import java.util.Scanner;

public class Max {

    public static int RecursiveMaxDigit(int num) {
        if (num == 0){
            return 0;
        }
        else if (num/10 == 0){
            return num;
        }
        else if ((num%10)>(RecursiveMaxDigit(num/10))){
            return num%10;
        }
        else
            return RecursiveMaxDigit(num/10);
    }

    public static int IterativeMaxDigit(int num) {
        int max = 0;
        while (num != 0){
            if (num%10 > max){
                max = num%10;
                num = num/10;
            }
            else {
                num = num/10;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        System.out.println("Enter a number 'n' to get the largest digit in that number:");
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        System.out.println("The recursive max digit of " + n + " is: " + RecursiveMaxDigit(n));
        System.out.println("The iterative max digit of " + n + " is: " + IterativeMaxDigit(n));
    }
}