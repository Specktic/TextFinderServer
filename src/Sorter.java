import java.util.Arrays;

public class Sorter
{
    public static class Radixsort {

        /** constructor */
        public Radixsort(){}

        public int Max(int a[], int n) {
            int m = a[0];
            for (int i = 1; i < n; i++)
                if (a[i] > m)
                    m = a[i];
            return m;
        }

        public void count(int a[], int n, int exp) {
            int output[] = new int[n];
            int i;
            int count[] = new int[10];
            Arrays.fill(count, 0);

            for (i = 0; i < n; i++)
                count[(a[i] / exp) % 10]++;

            for (i = 1; i < 10; i++)
                count[i] += count[i - 1];

            for (i = n - 1; i >= 0; i--) {
                output[count[(a[i] / exp) % 10] - 1] = a[i];
                count[(a[i] / exp) % 10]--;
            }

            for (i = 0; i < n; i++)
                a[i] = output[i];
        }

        public void radix(int arr[], int n) {
            int m = Max(arr, n);

            for (int exp = 1; m / exp > 0; exp *= 10)
                count(arr, n, exp);
        }
    }

    public static class Quicksort {

        /** constructor */
        public Quicksort(){}

        /** attribute 1, a string array */
        private String[] words;

        /** attribute 2, an int */
        private int size;

        /** public sorting method */
        public void sort(String names[]){
            if (names == null || names.length == 0){
                return;
            }
            this.words = names;
            size = names.length;
            quicksort(0, size - 1);
        }

        /** quicksort method */
        private void quicksort(int low, int high) {
            int i = low;
            int j = high;
            String pivot = words[low + (high - low) / 2];

            while (i <= j) {
                while (words[i].compareTo(pivot) < 0) {
                    i++;
                }
                while (words[j].compareTo(pivot) > 0) {
                    j--;
                }
                if ( i <= j) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                    i++;
                    j--;
                }
            }
            if (low < j) {
                quicksort(low, j);
            }
            if (i < high) {
                quicksort(i, high);
            }
        }
    }

    public static class Bubblesort {

        /** constructor */
        public Bubblesort(){}

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
}
