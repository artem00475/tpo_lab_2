package function;

public class Log {
    private final Ln ln;
    private final int base;

    public Log(Ln ln, int base) {
        if (base <= 0 || base == 1) throw new ArithmeticException("Основание должно быть положительным числом, кроме 1");
        this.ln = ln;
        this.base = base;
    }

    public double calculate(double x) {
        return ln.calculate(x)/ln.calculate(base);
    }
}
