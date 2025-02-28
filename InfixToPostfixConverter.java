import java.util.Stack;

public class InfixToPostfixConverter {

public String convert(String infix) throws Exception {
  StringBuilder postfix = new StringBuilder();
  Stack<Character> stack = new Stack<>();

  for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

         
            if (c == ' ') {
                continue;
            }

            
            if (Character.isDigit(c)) {
               
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    postfix.append(infix.charAt(i));
                    i++;
                }
                i--; 
                postfix.append(' '); 
            }
           
            else if (c == '(') {
                stack.push(c);
            }
           
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' '); 
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    throw new Exception("Expresión inválida: paréntesis no balanceados");
                } else {
                    stack.pop(); 
                }
            }

            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(' '); 
                }
                stack.push(c);
            } else {
                throw new Exception("Carácter inválido: " + c);
            }
        }


        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new Exception("Expresión inválida: paréntesis no balanceados");
            }
            postfix.append(stack.pop()).append(' '); 
        }


        if (postfix.length() > 0 && postfix.charAt(postfix.length() - 1) == ' ') {
            postfix.deleteCharAt(postfix.length() - 1);
        }

        return postfix.toString();

}
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

  private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }
}
