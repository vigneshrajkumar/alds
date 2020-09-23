package String;

public class Palindrome {

    public static void run(){
        System.out.println(longestPalindrome("banana"));
    }

    private static boolean isPalindrome(String str){
        int mid = str.length() / 2;
        if (str.length() % 2 == 0){
            for (int ix = 0; ix < mid; ix++) {
                if (str.charAt(mid + ix) != str.charAt(mid - ix - 1)){
                    return false;
                }
            }
        }else{
            for (int ix = 0; ix <= mid; ix++) {
                if (str.charAt(mid + ix) != str.charAt(mid - ix)){
                    return false;
                }
            }
        }   
        return true;
    }

    private static String longestPalindrome(String str){
        /*
            "banana" -> "anana" && "million" -> "illi"
        */

        int length = str.length();
        int width = 1;
        String largestPalindrome = "";
        while(width <= length){

            int start = 0;
            int end = start + width;
            while(end <= length){
                
                String substring = str.substring(start, end);
                if (isPalindrome(substring) && substring.length() > largestPalindrome.length()){
                    largestPalindrome = substring;
                }

                start++;
                end = start + width;
            }

            width++;
        }

    
        return largestPalindrome;
    }
    
}