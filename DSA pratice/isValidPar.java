import java.util.*;

public class isValidPar {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }

            // Closing brackets
            else {
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.pop();

                if ((top != '(' || ch != ')') &&
                    (top != '{' || ch != '}') &&
                    (top != '[' || ch != ']')) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {

        isValidPar s = new isValidPar();

        System.out.println(s.isValid("{}"));
        System.out.println(s.isValid("([])"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("((("));
        System.out.println(s.isValid("]"));
    }
}