package function;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cos {
    private final Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    public double calculate(double x) {
        return sin.calculate(Math.PI/2 - x);
    }
}
