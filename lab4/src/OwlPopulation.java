import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;


    public int populateData() throws FileNotFoundException {
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        data = new Owl[numLines];   //data is allocated the exact amount of space it needs

        scanner = new Scanner(f);

        int count = 0;
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] splitted = s.split(",");

            Owl owl1 = new Owl(splitted[0],Integer.parseInt(splitted[1]),Double.parseDouble(splitted[2]));
            data[count] = owl1;
            count++;
        }
        return numLines;
    }

    public OwlPopulation(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.populateData();
    }

    public double averageAge(){
        //TODO: implement
        double total = 0;
        double count = 0;
        for (int i = 0; i < data.length; i++) {
            total += data[i].getAge();
            count++;
        }

        return total / count;
    }

    public Owl getYoungest(){
        //TODO: implement
        int min = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].getAge() <= data[min].getAge()) {
                min = i;
            }
        }
        return data[min];
    }

    public Owl getHeaviest(){
        //TODO: implement
        int heaviest = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].getWeight() >= data[heaviest].getWeight()) {
                heaviest = i;
            }
        }
        return data[heaviest];
    }

    public String toString(){
        //TODO: implement
        Owl youngest = this.getYoungest();
        Owl heaviest = this.getHeaviest();
        return ("The youngest owl is: " + youngest.getName() + " who is " + youngest.getAge() + " years old" + "\n" + "The heaviest owl is: " + heaviest.getName() + " which is " + heaviest.getWeight() + " pounds" + "\n" + "The average age of the owls in this population is: " + this.averageAge() + " years young");
    }

    public boolean containsOwl(Owl other){
        for (int i =0; i<this.popSize();i++) {
            if (data[i].equals(other)) {
                return true;
            }
        }
        return false;
    }

    public void merge(OwlPopulation other) {
        //TODO: a brief overview of what you can do to implement this method is given below:
        Owl[] arr;
        int count = 0; //count how many dupes there are
        int count2 = 0; // a way to index Owl[]arr
        for (int i = 0; i < other.popSize(); i++){  // counts the amount of duplicates
            if (containsOwl(other.data[i]) == true){
                count ++;
            }

        }
        arr = new Owl[this.popSize() + other.popSize() - count];
        for (int j = 0; j < (other.popSize()); j ++){ // puts the amount of owls that aren't duplicates from owlpop2.csv
            if (this.containsOwl(other.data[j]) == false){
                arr[count2] = other.data[j];
                count2++;
            }
        }

        for(int k = 0; k <this.popSize();k++){ //puts all owls from owlpop1.csv in, since dupes have been dealt with
            arr[count2] = data[k];
            count2++;
        }
        this.data = arr;

    }

    public int popSize(){
        return data.length;
    }

    public static void main(String[] args) {
        try {
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println(pop1);
            System.out.println(pop1.popSize());

            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println(pop2);
            System.out.println(pop2.popSize());

            pop1.merge(pop2);
            System.out.println(pop1);
            System.out.println(pop1.popSize());
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
        catch (IOException f){
            System.out.println("File IO exception");
        }
    }


}
