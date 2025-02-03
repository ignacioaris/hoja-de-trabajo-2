public class PostfixCalculator implements ICalculadora {
    private Stack<Integer> stack;

    public PostfixCalculator(Stack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public int evaluate(String expression) throws Exception {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new Exception("Faltan operandos para la operación: " + token);
                }
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperation(a, b, token);
                stack.push(result);
            } else {
                try {
                    stack.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new Exception("Token inválido: " + token);
                }
            }
        }
        if (stack.size() != 1) {
            throw new Exception("La expresión no está bien formada");
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
    }

    private int applyOperation(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) {
                    throw new Exception("División por cero");
                }
                return a / b;
            case "%": return a % b;
            default: throw new Exception("Operador inválido: " + operator);
        }
    }
}
