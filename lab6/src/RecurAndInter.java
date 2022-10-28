public class RecurAndInter {

    public static int powerK(int k,int n) {
        if (n == 1) {
            return k;
        }
        else {
            return (k * powerK(k,n-1));
        }
    }

    public static int interPowerK(int k, int n) {
        int total = 1;
        for (int i = 0; i < n; i++) {
            total *= k;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(powerK(5,10));
        System.out.println(interPowerK(5,10));
    }
}
