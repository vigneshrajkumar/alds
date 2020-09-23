package misc;
import java.util.Scanner;

public class Luhn {
    /* 
        - You need to process right to left eventhough ip is given left to right
        - you do not know the length of ip, so you don't know which digit to mul by 2
        - cannot store in any DS, compute as you go
    */

    // convToInt converts chars 0-9 to int counterparts
    private static int convToInt(char ch){
        /*
            char 0's ASCII code = 48
            char 9's ASCII code = 57
            ASCII code - 48 gives the actual value
        */ 
        return ((int) ch - 48);
    }

    // 6 => 6 * 2 => 12 => 1 + 2 => 3
    private static int doubleTheDigit(int d){
        int doubled = d * 2;
        return (doubled >= 10) ? 1 + (doubled % 10) : doubled;
    }

    // luhnChecksum validates number of max length 6 incl check digit
    public static void check(){
        char digit;
        int position = 1;
        int evenCheckSum = 0;
        int oddCheckSum = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number [x to terminate]: ");
        digit = in.next().charAt(0);
        while ((int) digit != 120) {
            if (position % 2 == 0){
                evenCheckSum += doubleTheDigit(convToInt(digit));
                oddCheckSum += convToInt(digit);
            } else {
                evenCheckSum += convToInt(digit);
                oddCheckSum += doubleTheDigit(convToInt(digit));
            }
            digit = in.next().charAt(0);   
            position++;
        }
        in.close();

        int checksum = (position % 2) == 0 ? evenCheckSum : oddCheckSum;
        if (checksum % 10 == 0)  System.out.println("Valid"); 
        else System.out.println("Invalid");
    }
}