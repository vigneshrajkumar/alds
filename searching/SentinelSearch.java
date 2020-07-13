package searching;

public class SentinelSearch{
    /*
        Time Complexity: O(n)+ O(5)
        n: search array
    */
    public static int search(int[] values, int target){
        // Creating a backup of the last element || O(1)
        int backup = values[values.length - 1];

        // setting the target as the last element || O(1)
        values[values.length - 1] = target;

        // iterate till you reach the target
        // you either reach in between or at the last || O(n)
        int pos = 0;
        while(values[pos] != target) pos++;

        // restore the last element from backup || O(1)
        values[values.length - 1] = backup;

        // if pos is less than the size, then the element is present at pos
        // if pos is the last index and the value at the last index is the taget, return the pos || O(1)
        if ((pos < values.length - 1) || (values[values.length - 1] == target)) return pos;

        // target not found || O(1)
        return -1;
    }
}