package vd1;

public class Producer extends Thread {
    Store store = null;
    long index = 1;

    // index of product that will be made
    public Producer(Store s) {
        store = s;
    }

    public void run() {
        while (true) {
            try {
                boolean result= store.put(index);
                if (result==true) System.out.println("** Product" + (index++) + " is made.");
                else System.out.println("Store is full!");
            } catch (Exception e) {
            }
        }
    }
}
