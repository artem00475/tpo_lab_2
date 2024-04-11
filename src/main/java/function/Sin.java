package function;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sin {
    private final double eps;

    public Sin(double eps) {
        this.eps = eps;
    }

    public double calculate(double x) {
        if (x >= 2 * Math.PI) {
            x -= 2*Math.PI * ((int)(x/(2*Math.PI)));
        }
        BigDecimal prevIteration = BigDecimal.ZERO;
        BigDecimal currentIteration = BigDecimal.valueOf(x);
        int n = 2;
        while (prevIteration.subtract(currentIteration).abs().compareTo(BigDecimal.valueOf(eps)) > -1) {
            prevIteration = new BigDecimal(currentIteration.toString());
            BigDecimal res = new BigDecimal(String.valueOf(Math.pow(-1, n-1) * Math.pow(x, 2*n -1)));
            currentIteration = currentIteration.add(res.divide(factorial(2*n-1), BigDecimal.valueOf(eps).scale(), RoundingMode.HALF_EVEN));
            n++;
        }
        return currentIteration.doubleValue();
    }

    private BigDecimal factorial(int x) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= x; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
}
