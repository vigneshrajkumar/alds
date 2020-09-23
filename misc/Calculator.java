package misc;


import java.util.ArrayList;


public class Calculator {
    public static void run() {
        // System.out.println(calc("1+1"));
        // System.out.println(calc("1-1"));
        // System.out.println(calc("2/1"));
        System.out.println(calc("2*1"));
        // System.out.println(calc("3+2*2"));
        
    }


    private static int calc(String input) {


        ArrayList<String> equation = new ArrayList<>();
        
        for(String str : input.split(""))
            equation.add(str);
        
        for(int ix = 0; ix < equation.size(); ix++){
            if (equation.get(ix) == "*"){
                String left = equation.get(ix - 1);
                String right = equation.get(ix + 1);
                equation.remove(ix - 1);
                equation.remove(ix + 1);
                equation.add(Integer.toString(Integer.parseInt(left) * Integer.parseInt(right)));
            }
        }

        System.out.println(equation);
        
        // if (input.length() == 3){
        //     String[] arr = input.split("");

        //     switch (arr[1]) {
        //         case "+":
        //             return Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);
        //         case "-":
        //             return Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]);
        //         case "/":
        //             return Integer.parseInt(arr[0]) / Integer.parseInt(arr[2]);
        //         case "*":
        //             return Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]);
        //     }
           
        // }

        return -1;
    }
}