//public class Bus {
//    private Passenger[] seats;
//    private int openIndex = 0;
//
//    public Bus() {
//        this.seats = new Passenger[40];
//    }
//    public Bus(int newcap) {
//        this.seats = new Passenger[newcap];
//    }
//
//    public void addPassenger(Passenger p) {
//        if (openIndex < seats.length) {
//            seats[openIndex] = p;
//            openIndex++;
//        }
//    }
//
//    public int numberOfPassengers() {
//        return openIndex;
//    }

    // The sorting algorithm one should use is the Insertion sort.  This is because already sorted
    // lists are very quickly sorted.  IE: If the fullest busses are already in the correct spot in line, the insertion
    // sort would allow them to be sorted quickly instead of waiting for all busses to be searched to confirm

//}
