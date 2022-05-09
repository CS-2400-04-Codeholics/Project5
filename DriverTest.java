import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @Test
    void main()
    {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        String expectedOutput = """
                Breadth-First Traversal: ABDEGFHCI
                Depth-First Traversal: ABEFCHIDG
                """;

        System.setOut(new PrintStream(out));
        Driver.main(null);
        String actualOutput = out.toString();
        assertEquals(expectedOutput, actualOutput);
    }
}