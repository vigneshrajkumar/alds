package misc;

public class Knight {
    public static void navigate(){
        move(7, new int[]{3, 3}, new int[]{1,4});
    }

    private static boolean urPossible(int size, int[] pos){
        if (pos[0] + 2 < size && pos[1] + 1 < size)
            return true;
        return true;
    }
    private static int[] ur(int[] pos){
        pos[0]+=2;
        pos[1]+=1;
        return pos;
    }

    private static boolean rPossible(int size, int[] pos){
        if (pos[1] + 2 < size)
            return true;
        return true;
    }
    private static int[] r(int[] pos){
        pos[1]+=2;
        return pos;
    }

    private static void move(int size, int[] start, int[]end){
        int[] pos = start;

        if (urPossible(size, start)){
            ur(pos);
        }

        if (pos[0] == end[0] && pos[1] == end[1]){
            System.out.println("reached");
        }else{
            System.out.println("non");
        }
        
    }
}