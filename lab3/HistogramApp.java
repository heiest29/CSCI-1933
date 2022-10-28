import java.util.Scanner;

public class HistogramApp {
    public static void main(String args[]){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter two numbers to create a range for the histogram: ");
        int n = myScanner.nextInt();
        int w = myScanner.nextInt();
        Histogram histo = new Histogram(n,w);

        while (myScanner.hasNext())     {
            String line = myScanner.next();
            if ("quit".equals(line)){
                System.out.println("Bye!");
                break;
            }
            else if ("add".equals(line)){
                System.out.println("Enter number(s) you want to add: ");
                while (myScanner.hasNextInt()){
                    int num = myScanner.nextInt();
                    if (histo.add(num)) {
                    }
                    else {
                        System.out.println(num + " is not within the specified range");
                    }

                    // if (myScanner.hasNextInt()){
                    //     int num = myScanner.nextInt();
                    //     if (histo.add(num) == false){
                    //         System.out.println(num + " is not within the specified range :(");
                    //     }
                    //     else {
                    //         histo.add(num);
                    //     }
                    // }
                    // else {
                    //     myScanner.next();
                    // }
                    // break;
                }
            }
            else if ("print".equals(line)){
                System.out.println(histo);
            }
        }
    }
}
