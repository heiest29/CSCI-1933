public class RecursiveFact {
    public static int nfact(int n) {
        if (n == 0) {
            return 1;
        }else {
            return n * nfact(n-1);
        }
    }

    public static double factIter(int n, int count, int partial) {
        if (count == n) {
            return partial;
        }
        else return factIter(n, count+1, (count+1)*partial);
    }

    public static void main(String args[]){
        int n = 25;
        double x = factIter(n,0,1);
        System.out.println("factorial of " + n + " is equal to: " + x);
    }
}