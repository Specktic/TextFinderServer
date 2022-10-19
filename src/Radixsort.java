import java.util.Arrays;

public class Radixsort {
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
