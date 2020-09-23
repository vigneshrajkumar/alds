package misc;

public class Decoder {
        

        // 0 UPPER; 1 LOWER; 2 PUNC; 
        private static int mode = 0;
        private static void nextMode(){
            mode++;
            if (mode == 3){
                mode = 0;
            }
        }



        // (10^2 * 2)+ (10^1 * 5) + (10^0 * 6)
        // 256
        private static int decode(String number) {
            char[] arr = number.toCharArray();
            int sum = 0;
            for(int ix = 0; ix < arr.length; ix++){
                int decodedValue = ((int) arr[ix] % 48); // char to int conv
                double multiplier = Math.pow(10, arr.length - 1 - ix);
                sum += multiplier * decodedValue;
            }
            return sum;
        }

        public static char getUpperChar(String number) {
            int num = decode(number);
            return (char) (64 + num);
        }

        public static char getLowerChar(String number) {
            int num = decode(number);
            return (char) (96 + num);
        }
}