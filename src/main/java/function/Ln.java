package function;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ln {
    private final double eps;

    public Ln(double eps) {
        this.eps = eps;
    }

    public double calculate(double x) {
        if (x <= 0) throw new ArithmeticException("Логарифм не определен при x <= 0");
        BigDecimal prevIteration = BigDecimal.ZERO;
        x = (x-1)/(x+1);
        BigDecimal currentIteration = BigDecimal.valueOf(x);

        int n = 3;
        while (prevIteration.subtract(currentIteration).abs().compareTo(BigDecimal.valueOf(eps)) > -1 && n <= 10000) {
            prevIteration = new BigDecimal(currentIteration.toString());
            BigDecimal res = BigDecimal.valueOf(x).pow(n);
            currentIteration = currentIteration.add(res.divide(BigDecimal.valueOf(n), BigDecimal.valueOf(eps).scale(), RoundingMode.HALF_EVEN));
            n += 2;
        }
        return currentIteration.multiply(BigDecimal.valueOf(2)).doubleValue();
    }
}
