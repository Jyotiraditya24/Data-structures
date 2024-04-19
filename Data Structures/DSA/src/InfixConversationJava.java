import java.util.Stack;

public class InfixConversationJava {
    public static void main(String[] args) {
        Stack<String> cs_1 = new Stack<>();
        Stack<Character> op = new Stack<>();

        String test = "a*(b-c)/d+e";
        String ans1 = "";

        for (int i = 0; i < test.length(); i++) {
            char ch = test.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                cs_1.push(ch + "");
            } else if (ch == '(') {
                op.push(ch);
            } else if (ch == '*' || ch == '+' || ch == '-' || ch == '/') {
                while (!op.isEmpty() && op.peek() != '(' && precedence(op.peek()) >= precedence(ch)) {
                    Character one = op.pop();
                    String ans_2 = cs_1.pop();
                    String ans_1 = cs_1.pop();
                    String local = ans_1 + ans_2 + one;
                    cs_1.push(local);
                }
                op.push(ch);
            } else if (ch == ')') {
                while (!op.isEmpty() && op.peek() != '(') {
                    Character one = op.pop();
                    String ans_2 = cs_1.pop();
                    String ans_1 = cs_1.pop();
                    String local = ans_1 + ans_2 + one;
                    cs_1.push(local);
                }
                op.pop(); // Discard the '('
            }
        }

        while (!op.isEmpty()) {
            Character one = op.pop();
            String ans_2 = cs_1.pop();
            String ans_1 = cs_1.pop();
            String local = ans_1 + ans_2 + one;
            cs_1.push(local);
        }

        System.out.println(cs_1.peek());
    }

    static int precedence(Character c) {
        return switch (c) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0; // Lower precedence for '('
        };
    }
}
