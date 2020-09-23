package Arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Arr {

    public static void run(){
        int[] arr = new int[]{4, 7, 1, -3, 2};
        System.out.println(possiblePair(arr, 5));
    }


    // to return the only number that occours once, rest all
    // occours twice
    private static int uniqueNumber(int[] arr){
        int unique = 0;
        for(int i : arr){
            unique ^= i;
        }
        return unique;
    }

    // to find whether its possible to form k with two numbers in the array
    private static boolean possiblePair(int[] arr, int k){
        Set<Integer> visited = new HashSet<>();
        for(int i : arr){
            int comp = k - i;
            if (visited.contains(comp)){
                return true;
            }else{
                visited.add(i);
            }
        }
        return false;
    }

    // to return the first and last index of the given target in the 
    // given array
    private static int[] firstLastIndex(int[] arr, int target){
        int first = -1;
        int last = -1;
        for(int ix = 0; ix < arr.length; ix++){
            if (arr[ix] == target){
                first = ix;
                break;
            }
        }
        
        for(int ix = arr.length - 1; ix > 0; ix--){
            if (arr[ix] == target){
                last = ix;
                break;
            }
        }
        return new int[]{first, last};
    }
    
}