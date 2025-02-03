import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new VectorStack<>();
        ICalculadora calculator = new PostfixCalculator(stack);

        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int result = calculator.evaluate(line);
                    System.out.println("Resultado: " + result);
                } catch (Exception e) {
                    System.err.println("Error al evaluar la expresión: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}