package sorting;

import java.util.Arrays;

public class CountSort {
    /*
        Time Complexity: 2 * O(v) + O(f) + O(4)
        v: input array
        f: range between smallest and largest value in the input
    */ 
    public static int[] sort(int[] values){
        // O(1)
        int max = Arrays.stream(values).max().getAsInt();
        
        // O(1)
        int min = Arrays.stream(values).min().getAsInt();
        
        // O(1)
        int[] freq = new int[max - min + 1];
        
        // O(v)
        for(int v : values){
            freq[v - min]++ ;
        }

        // O(f)
        for(int ix = 1; ix < freq.length; ix++){
            freq[ix] = freq[ix] + freq[ix - 1];
        }
        
        // O(1)
        int[] output = new int[values.length];

        // O(v)
        for(int ix = 0; ix < values.length; ix++){
            int newPos = freq[values[ix] - min];
            output[newPos - 1] = values[ix];
            freq[values[ix] - min]--;
        }
        return output;
    }
}