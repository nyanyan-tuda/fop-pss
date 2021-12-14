public class ArraySelectionSort extends ArraySort {
    public ArraySelectionSort(int[] array) {
        super(array);
    }

    @Override
    public void sort(int from, int to) {
        for (int i = from; i < to; i++) {
            int min = i;
            for (int j = i + 1; j <= to; j++)
                if (array[j] < array[min])
                    min = j;
            swap(i, min);
        }
    }
}
