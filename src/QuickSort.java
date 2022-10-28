public class QuickSort {

        /** constructor */
        public QuickSort(){}

        /** attribute 1, a string array */
        private String[] words;

        /** attribute 2, an int */
        private int size;

        /** public sorting method */
        public void quicksort(String names[]){
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

