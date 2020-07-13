package sorting;

public class QuickSort {

    private static int partition(int[] arr, int low, int high) {
        int ix = low;
        int jx = high;
        int pivot = arr[0];
        // System.out.println("ix: " + ix);
        // System.out.println("jx: " + jx);
        // System.out.println("pivot val: " + pivot);

        while (ix < jx) {
            // System.out.println(arr[ix + 1] + " <= " + pivot);
            while (arr[ix + 1] <= pivot) {
                // System.out.println("ix++");
                ix++;
            }

            while (arr[jx - 1] > pivot) {
                jx--;
            }

            if (ix < jx) {
                int backup = arr[ix];
                arr[ix + 1] = arr[jx - 1];
                arr[jx + 1] = backup;
            }
        }

        int backup = arr[jx];
        arr[jx] = arr[0];
        arr[0] = backup;

        return jx - 1;
    }

    public static int[] sort(int[] arr, int low, int high) {

        int pivot = partition(arr, low , high);
        sort(arr, low, pivot);
        sort(arr, pivot + 1, high);

        // System.out.println("pivot: " + pivot);

        return arr;
    }
}