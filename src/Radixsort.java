public class Radixsort {
    /** constructor */
    public Radixsort(){}

    public int max(int a[], int n)
    {
        int m = a[0];
        for (int i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        return m;
    }

    public void radix(int a[], int n) {
        int m = max(a, n);
        for (int e = 1; m/e > 0; e *= 10) {
            countSort(a, n, e);
        }
    }

    private void countSort(int a[], int n, int e) {
        int output[] = new int[0];
        int i;
        int[] count = new int[10];

        for (i = 0; i < n; i++) {
            count [ (a[i]/e) % 10 ] ++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[ count[ (a[i]/e) % 10 ] - 1 ] = a[i];
            count[ (a[i]/e) % 10 ]--;
        }
        for (i = 0; i < n; i++) {
            a[i] = output[i];
        }
    }
}
