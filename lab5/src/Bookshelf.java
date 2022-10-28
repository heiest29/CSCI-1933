public class Bookshelf {
    private Book bookHolder[];
    private int nextEmpty = 0;
    private int numBooks;
    public Bookshelf(int numOfBooks){
        bookHolder = new Book[numOfBooks];
        this.numBooks = numOfBooks;

    }
    public Bookshelf(){
        bookHolder = new Book[20];
        this.numBooks = 20;
    }

    public boolean add(Book newBook){
        if (nextEmpty < bookHolder.length && 0<= nextEmpty){
            bookHolder[nextEmpty] = newBook;
            nextEmpty += 1;
            return true;
        }
        else{return false;}
    }
    public Bookshelf getBooksByAuthor(String Author) {
        Bookshelf specific = new Bookshelf(numBooks);
        for (int i = 0; i < bookHolder.length; i++) {
            if (Author.equals(bookHolder[i].getAuthor())) {
                specific.add(bookHolder[i]);
            }
        }
        return specific;
    }


    public String toString(){
        String temp = "";
        for (int i =0; i < bookHolder.length; i++){
            if (bookHolder[i] != null) {
                temp += (bookHolder[i] + "\n");
            }
        }
        return temp;
    }
    public void sort(char sortBy){
//        int i,j;
//        Book n;
//        for(i =1; i < bookHolder.length; i++){
//            n = bookHolder[i];
//            for(j = i -1; j>=0 && n.compareTo(bookHolder[i],sortBy)<0;j--){
//                bookHolder[j+1] = bookHolder[j];
//            }
//            bookHolder[j+1] = n;
//
//        }
        int i,j,minIndex;
        Book temp;

        for(i = 0; i<bookHolder.length-1 && bookHolder[i]!=null;i++) {
            minIndex = i;
            for(j=i+1; j<bookHolder.length && bookHolder[j]!= null; j++) {
                if (bookHolder[j].compareTo(bookHolder[minIndex],sortBy) < 0) {
                    minIndex = j;
                }
            }
            temp = bookHolder[minIndex];
            bookHolder[minIndex] = bookHolder[i];
            bookHolder[i] = temp;
        }
    }

    public static void main(String[] args){
//        Bookshelf bs = new Bookshelf(5);
//        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
//        bs.add(new Book("Eldest", "Christopher Paolini", 10.0));
//        bs.add(new Book("Brisingr", "Christopher Paolini", 10.0));
//        bs.add(new Book("Inheritance", "Christopher Paolini", 10.0));
//        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
//        Bookshelf goodbooks = bs.getBooksByAuthor("Christopher Paolini");
//        System.out.println(goodbooks);

        Bookshelf bs = new Bookshelf(5);
        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkein", 10.0));
        bs.add(new Book("Twilight", "Stephenie Meyer", 0.0));
        bs.add(new Book("The Diary of a Wimpy Kid", "Jeff Kinney", 0.0));
        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
        bs.sort('a');
        System.out.println(bs);
    }
}


