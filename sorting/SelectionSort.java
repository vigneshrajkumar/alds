package sorting;

public class SelectionSort {
    // O(n^2)
    public static int[] sort(int[] arr) {        
        for (int ix = 0; ix < arr.length - 1; ix++) {
            int minIndex = ix;
            for (int jx = ix + 1; jx < arr.length; jx++) {
                if (arr[jx] < arr[minIndex]) {
                    minIndex = jx;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[ix];
            arr[ix] = temp;
        }

        return arr;
    }
}