import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class PostfixCalculatorTest {

    @Test
    public void testEvaluate() throws Exception {
        Stack<Integer> stack = new VectorStack<>();
        ICalculadora calculator = new PostfixCalculator(stack);

        assertEquals(15, calculator.evaluate("1 2 + 4 * 3 +"));
        assertEquals(30, calculator.evaluate("6 2 3 + *"));

        // Pruebas de manejo de errores
        Exception exception = assertThrows(Exception.class, () -> calculator.evaluate("1 0 /"));
        assertEquals("División por cero", exception.getMessage());

        exception = assertThrows(Exception.class, () -> calculator.evaluate("1 2 &"));
        assertEquals("Token inválido: &", exception.getMessage());

        exception = assertThrows(Exception.class, () -> calculator.evaluate("1 +"));
        assertEquals("Faltan operandos para la operación: +", exception.getMessage());

        exception = assertThrows(Exception.class, () -> calculator.evaluate("1 2 3 +"));
        assertEquals("La expresión no está bien formada", exception.getMessage());
    }
}

