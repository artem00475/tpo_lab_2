package function;

public class Csc {
    private final Sin sin;


    public Csc(Sin sin) {
        this.sin = sin;
    }

    public double calculate(double x) {
        if (Math.abs(x) % Math.PI == 0) throw new ArithmeticException("Косеканс не определен в PI + PIk");
        return 1/sin.calculate(x);
    }
}
