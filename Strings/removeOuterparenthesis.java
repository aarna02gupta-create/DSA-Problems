public class removeOuterparenthesis {

    // Your solution
    static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder(); // builds the answer (see concept 4 below)
        int depth = 0; // how many '(' are currently open

        for (int i = 0; i < s.length(); i++) { // s.length() = number of characters
            char c = s.charAt(i); // get the character at index i

            if (c == '(') {
                if (depth > 0) { // depth 0 means this is an outer '(' → skip it
                    sb.append(c);
                }
                depth++; // go one level deeper
            } else { // c == ')'
                depth--; // come one level back out
                if (depth > 0) { // depth 0 means this is an outer ')' → skip it
                    sb.append(c);
                }
            }
        }
        return sb.toString(); // convert StringBuilder → String
    }

    // Test it
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())")); // ()()()
        System.out.println(removeOuterParentheses("(()())(())(()(()))")); // ()()()()(())
        System.out.println(removeOuterParentheses("()()")); // (empty line)
    }
}