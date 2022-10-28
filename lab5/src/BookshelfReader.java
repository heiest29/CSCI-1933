import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.function.Predicate;


public class BookshelfReader {

    public static Bookshelf readBooksFromFile(String fileName){
        Bookshelf up = new Bookshelf();
        Scanner s = null;
        try {
            s = new Scanner(new File(fileName));
        }
        catch (Exception e) {
            System.out.println("Whoops! File not found exception scrub");
            return null;
        }

        while (s.hasNextLine()) {
            String s1 = s.nextLine();
            String[] spliced = s1.split(",");

            Book newBook = new Book(spliced[0],spliced[1],Double.parseDouble(spliced[2]));
            up.add(newBook);
        }
        s.close();
        return up;
    }

    public static void writeShelfToFile(Bookshelf b, String fileName){
        PrintWriter p = null;
        try {
            p = new PrintWriter(new File(fileName));
        }
        catch(Exception e) {
            System.out.println("Exception has been found");
            return;
        }
        p.println(b);
        p.close();
    }
    public static void main(String[] args){
        Bookshelf boo;
        boo = readBooksFromFile("bookinput.txt");
        boo.sort('r');
        writeShelfToFile(boo,"output.txt");
    }
}

