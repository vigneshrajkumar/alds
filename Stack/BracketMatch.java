package Stack;

import java.util.Stack;

public class BracketMatch {

    private static String validate(String stream) {
        Stack<String> stack = new Stack<>();
        for (String s : stream.split("")) {
            if (s.equals("{") || s.equals("[") || s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.empty()){
                    return "NO";
                }
                String head = stack.pop();
                if (s.equals("}") && !head.equals("{")) {
                    return "No";
                }
                if (s.equals("]") && !head.equals("[")) {
                    return "No";
                }
                if (s.equals(")") && !head.equals("(")) {
                    return "No";
                }
            }
        }
        return stack.empty() ? "Yes" : "No";
    }

    public static void run() {
        System.out.println(validate("][(]}})("));
    }

}