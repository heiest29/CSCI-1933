public class Histogram {
    public int lowerbound,upperbound;
    public int[] count;

    public Histogram(int lowerbound, int upperbound){
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
        this.count = new int[(this.upperbound-this.lowerbound)+1];
    }
    public boolean add(int i){
        if (i>=this.lowerbound && i<=this.upperbound){
            this.count[i-this.lowerbound] += 1;
            return true;
        }
        return false;
    }
    public String toString(){
        String tempstring = "";
        for (int i=this.lowerbound; i<=(this.upperbound-this.lowerbound);i++){
            String countdooku = i + ":";
            for (int j = 0; j<this.count[i]; j++){
                countdooku += "*";
            }
            countdooku += "\n";
            tempstring += countdooku;
        }
        return tempstring;
    }
    public static void main(String args[]){
        Histogram histo = new Histogram(0, 5);
        histo.add(3);
        histo.add(2);
        histo.add(1);
        histo.add(2);
        histo.add(3);
        histo.add(0);
        histo.add(1);
        histo.add(5);
        histo.add(3);
        System.out.println(histo);
    }
}
