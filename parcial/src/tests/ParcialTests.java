package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import logic.Parcial;

public class ParcialTests {
    Parcial parcial;

    @BeforeEach
    public void setUp() {
        parcial = new Parcial();
    }

    @Test
    public void testPower() throws ArithmeticException {
        assertEquals("No maneja bien e = 0", 1, parcial.potencia(2, 0));
        assertEquals("No maneja bien e = 1/2", 2, parcial.potencia(2, 1/2));
        assertEquals("No maneja bien e = 2", 4, parcial.potencia(2, 2));
        assertEquals("No maneja bien e = 10", 1024, parcial.potencia(2, 10));

        assertEquals("No maneja bien b = 0", 0, parcial.potencia(0, 1));
    }

    @Test
    public void testPoweExceptions() throws ArithmeticException {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            parcial.potencia(2, -1);
        });
        assertEquals("Negative exponent", exception.getMessage(), "No maneja bien e < 0");

        exception = assertThrows(ArithmeticException.class, () -> {
            parcial.potencia(0, 0);
        });
        assertEquals("Indeterminate form", exception.getMessage(), "No maneja bien b = 0, e = 0");

        exception = assertThrows(ArithmeticException.class, () -> {
            parcial.potencia(2, 31);
        });
        assertEquals("Overflow", exception.getMessage(), "No maneja bien overflow");
        
        exception = assertThrows(ArithmeticException.class, () -> {
            parcial.potencia(2, (1/2));
        });
        assertEquals("Not an integer", exception.getMessage(), "No maneja bien no entero");
    }
}
