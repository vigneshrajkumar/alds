package dynamic;
import java.util.Arrays;
public class Fibonacci {
    // Bottom Up Approach
    public static int bottomUp(int n){
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for(int ix = 2; ix < n + 1; ix++){
            arr[ix] = arr[ix - 1] + arr[ix - 2];
        }
        return arr[n];
    }

    static int counter = 0;

    public static int topDown(int n){
        counter++;
        int[] arr = new int[n + 1];
        for(int ix = 0; ix < arr.length; ix++){
            arr[ix] = Integer.MIN_VALUE;
        }
        arr[0] = 0;
        arr[1] = 1;
        if (n == 0) return arr[0];
        if (n == 1) return arr[1];
        if (arr[n - 1] == Integer.MIN_VALUE){
            arr[n - 1] = topDown(n - 1);
        }
        if (arr[n - 2] == Integer.MIN_VALUE){
            arr[n - 2] = topDown(n - 2);
        }
        
        arr[n] = arr[n - 1] + arr[n - 2];

        System.out.println("counter: " + counter);
        System.out.println(Arrays.toString(arr));
        return arr[n];
    }
}