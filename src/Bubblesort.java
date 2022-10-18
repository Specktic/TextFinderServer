import java.util.*;

public class Bubblesort {
    /** constructor */
    public Bubblesort(){}

    /** sorting by bubblesort method */
    public static void sort(String[] a) {
        int in;
        int out;

        for (out = a.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in].compareTo(a[in + 1]) > 0) {
                    String temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                }
            }
        }
    }
}
