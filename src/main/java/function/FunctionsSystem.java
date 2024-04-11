package function;

/*
x <= 0 : (((((csc(x) - sin(x)) + tan(x)) - cos(x)) + cos(x)) ^ 2)
x > 0 : (((((log_2(x) * ln(x)) - (log_3(x) + ln(x))) ^ 2) * (log_2(x) / (ln(x) ^ 3))) + ((log_5(x) + log_5(x)) + log_10(x)))
*/
public class FunctionsSystem {
    private final Csc csc;
    private final Sin sin;
    private final Tan tan;
    private final Cos cos;
    private final Ln ln;
    private final Log log2;
    private final Log log3;
    private final Log log5;
    private final Log log10;

    public FunctionsSystem(Csc csc, Sin sin, Tan tan, Cos cos, Ln ln, Log log2, Log log3, Log log5, Log log10) {
        this.csc = csc;
        this.sin = sin;
        this.tan = tan;
        this.cos = cos;
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    public double calculate(double x) {
        if (x <= 0) {
            return Math.pow(((((csc.calculate(x) - sin.calculate(x)) + tan.calculate(x)) - cos.calculate(x)) + cos.calculate(x)),2);
        } else {
            return ((Math.pow(((log2.calculate(x) * ln.calculate(x)) - (log3.calculate(x) + ln.calculate(x))),2)) * (log2.calculate(x) / (Math.pow(ln.calculate(x),3)))) + ((log5.calculate(x) + log5.calculate(x)) + log10.calculate(x));
        }
    }

}
