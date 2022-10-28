public class BubbleSort {

    /** constructor */
    public BubbleSort(){}

    /** sorting by bubblesort method */
    public void sort(int[] a) {
        int in;
        int out;

        for (out = a.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    int temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                }
            }
        }
    }
}
