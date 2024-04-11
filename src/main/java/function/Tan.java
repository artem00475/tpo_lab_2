package function;

public class Tan {
    private final Cos cos;
    private final Sin sin;


    public Tan(Cos cos, Sin sin) {
        this.cos = cos;
        this.sin = sin;
    }

    public double calculate(double x) {
        if (Math.abs(x) % Math.PI == Math.PI / 2) throw new ArithmeticException("Тангенс не определен в PI/2 + PIk");
        return sin.calculate(x)/cos.calculate(x);
    }
}
