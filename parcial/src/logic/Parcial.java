package logic;

public class Parcial {
    public int potencia(int b, int e) throws ArithmeticException {
        if (Math.pow(b,e) > Integer.MAX_VALUE) {
            throw new ArithmeticException("Overflow");
        } else if (e < 0) {
            throw new ArithmeticException("Negative exponent");
        } else if (b == 0 && e == 0) {
            throw new ArithmeticException("Indeterminate form");
        } else if (Math.pow(b,e) % 1 != 0) {
            throw new ArithmeticException("Not an integer");
        } else {
            return (int) Math.pow(b, e);
        }
    }
}
