import java.util.Scanner;
import java.lang.Integer;

public class Whatever {
    private int data;
    public Whatever(int newData) {
        data = newData;
    }
    public void setData(int newData) {
        data = newData;
    }
    public int getData() {
        return data;
    }
    public static void doWhatever(Whatever w, int i, int d) {
        System.out.println("doWhatever(1): w: "+w.getData()+", i: "+i+"; d: "
                +d);
        w.setData(i);
        d = i;
        i = d;
        System.out.println("doWhatever(2): w: "+w.getData()+", i: "+i+"; d: "
                +d);
    }
    public static void main(String[] args) {
        Whatever w = new Whatever(1);
        int i = 2;
        double d = 3;
        System.out.println("main(1): w: "+w.getData()+", i: "+i+"; d: "+d);
        doWhatever(w, i, (int)d);
        System.out.println("main(2): w: "+w.getData()+", i: "+i+"; d: "+d);
        w = new Whatever(i);
        d = i / 4;
        System.out.println("main(3): w: "+w.getData()+", i: "+i+"; d: "+d);
    }
}

//    private int data;
//
//    public Whatever(int data) {
//        data = data;
//    }
//    public void setData(int newData) {
//        data = newData;
//    }
//
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int sum = 0;
//        while (s.hasNext()) {
//            String data = s.next();
//            if (data == "stop") {
//                break;
//            }
//            sum += Integer.parseInt(data);
//        }
//        System.out.println("The sum is:" + sum);
//
//
//        Ingredient[] recipe;
//        Ingredient eggs = new Ingredient(12);
//        Ingredient flour = new Ingredient(100);
//        Ingredient butter = new Ingredient(5); // missed a new statement in front of this ingredient
//        recipe = new Ingredient[3];
//        recipe[0] = eggs;
//        recipe[1] = flour;
//        recipe[2] = butter;
//        for (int i = 0; i < recipe.length; i++) {
//            System.out.println(recipe[i].getAmount()); // issue here was the fact that the getAmount method was being called in reference to a value that was null
//        }
//    }

