import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class VectorStackTest {

    @Test
    public void testStackOperations() {
        Stack<Integer> stack = new VectorStack<>();
        assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }
}