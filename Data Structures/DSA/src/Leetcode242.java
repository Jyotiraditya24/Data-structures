
import java.util.Stack;
public class Leetcode242 {
    public static int calculate(String s) {
            Stack<Integer> digitStack = new Stack<>();
            Stack<Character> symbolStack = new Stack<>();
            int num = 0;
            for(int i=0;i<s.length();i++){
                Character ch = s.charAt(i);
                if(Character.isDigit(ch)){
                    num = num * 10 + (ch - '0');
                }else if(ch == '('){
                    symbolStack.push(ch);
                }
                else if(ch == ')'){
                    digitStack.push(num);
                    num = 0;
                    while(symbolStack.peek()!='('){
                        Character symbol = symbolStack.pop();
                        int a =digitStack.pop();
                        int b = digitStack.pop();
                        int ans = operation (a,b,symbol);
                        digitStack.push(ans);
                    }
                    symbolStack.pop();
                }else if(ch == '+' || ch == '-'){
                    if(num!=0){
                        digitStack.push(num);
                    }
                    num = 0;
                    while(!symbolStack.isEmpty() && symbolStack.peek() != '('&& precedence(ch)>= precedence(symbolStack.peek())){
                        Character symbol = symbolStack.pop();
                        int a =digitStack.pop();
                        int b = digitStack.pop();
                        int ans = operation (a,b,symbol);
                        digitStack.push(ans);
                    }
                    symbolStack.push(ch);
                }
            }if(num != 0) {

            digitStack.push(num);
        }
            while (!symbolStack.isEmpty()) {
                Character symbol = symbolStack.pop();
                int a = digitStack.pop();
                int b = digitStack.pop();
                int ans = operation (a,b,symbol);
                digitStack.push(ans);
            }
            return digitStack.pop();
        }

        public static int operation(int a, int b, char ch) {
            return switch (ch) {
                case '+' -> a + b;
                case '-' -> b - a;
                default -> throw new IllegalArgumentException("Invalid operator: " + ch);
            };
        }

        public static int precedence(Character ch){
            return 1;
        }

    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}
