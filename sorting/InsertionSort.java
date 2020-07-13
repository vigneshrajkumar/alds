package sorting;

public class InsertionSort {
    public static int[] sort(int[] arr) {
        for(int ix=1; ix< arr.length; ix++){
            int key = arr[ix];
            int jx = ix - 1;

            while(jx >= 0 && arr[jx] > key){
                arr[jx+1] = arr[jx];
                jx--;
            }
            arr[jx + 1] = key;
        }
        return arr;
    }
}