package function;

import csv.CsvHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.List;

public class FunctionsSystemTest {
    static final double eps = 3e-3;
    static Sin sin;
    static Cos cos;
    static Csc csc;
    static Tan tan;
    static Ln ln;
    static Log log2;
    static Log log3;
    static Log log5;
    static Log log10;

    @BeforeAll
    static void init() {
        sin = Mockito.mock(Sin.class);
        cos = Mockito.mock(Cos.class);
        csc = Mockito.mock(Csc.class);
        tan = Mockito.mock(Tan.class);
        ln = Mockito.mock(Ln.class);
        log2 = Mockito.mock(Log.class);
        log3 = Mockito.mock(Log.class);
        log5 = Mockito.mock(Log.class);
        log10 = Mockito.mock(Log.class);

        CsvHandler csvHandler = new CsvHandler("src/test/resources", ",");
        List<String> sinData = csvHandler.readData("sin.csv");
        sinData.forEach(row -> {
            String[] values = row.split(",");
            Mockito.when(sin.calculate(Double.parseDouble(values[0]))).thenReturn(Double.parseDouble(values[1]));
        });

        List<String> cosData = csvHandler.readData("cos.csv");
        cosData.forEach(row -> {
            String[] values = row.split(",");
            Mockito.when(cos.calculate(Double.parseDouble(values[0]))).thenReturn(Double.parseDouble(values[1]));
        });

        List<String> cscData = csvHandler.readData("csc.csv");
        cscData.forEach(row -> {
            String[] values = row.split(",");
            Mockito.when(csc.calculate(Double.parseDouble(values[0]))).thenReturn(Double.parseDouble(values[1]));
        });

        List<String> tanData = csvHandler.readData("tan.csv");
        tanData.forEach(row -> {
            String[] values = row.split(",");
            Mockito.when(tan.calculate(Double.parseDouble(values[0]))).thenReturn(Double.parseDouble(values[1]));
        });

        List<String> lnData = csvHandler.readData("ln.csv");
        lnData.forEach(row -> {
            String[] values = row.split(",");
            Mockito.when(ln.calculate(Double.parseDouble(values[0]))).thenReturn(Double.parseDouble(values[1]));
        });

        List<String> log2Data = csvHandler.readData("log2.csv");
        log2Data.forEach(row -> {
            String[] values = row.split(",");
            Mockito.when(log2.calculate(Double.parseDouble(values[0]))).thenReturn(Double.parseDouble(values[1]));
        });

        List<String> log3Data = csvHandler.readData("log3.csv");
        log3Data.forEach(row -> {
            String[] values = row.split(",");
            Mockito.when(log3.calculate(Double.parseDouble(values[0]))).thenReturn(Double.parseDouble(values[1]));
        });

        List<String> log5Data = csvHandler.readData("log5.csv");
        log5Data.forEach(row -> {
            String[] values = row.split(",");
            Mockito.when(log5.calculate(Double.parseDouble(values[0]))).thenReturn(Double.parseDouble(values[1]));
        });

        List<String> log10Data = csvHandler.readData("log10.csv");
        log10Data.forEach(row -> {
            String[] values = row.split(",");
            Mockito.when(log10.calculate(Double.parseDouble(values[0]))).thenReturn(Double.parseDouble(values[1]));
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
        "2, 2.3577070962795593156432819",
        "10, 6.736450233559547752585227",
        "-1, 3.626479778262002303851671",
        "-2, 3.978377778442476714624968",
        "-30, 41.3373505681757163208865",
    })
    void calculateAllMocks(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, cos, ln,log2,log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalSin(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,new Sin(1e-20), tan, cos, ln,log2,log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalCos(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, new Cos(sin), ln,log2,log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalCsc(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(new Csc(sin),sin, tan, cos, ln,log2,log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalTan(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, new Tan(cos, sin), cos, ln,log2,log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalCosAndSin(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, new Cos(new Sin(1e-20)), ln,log2,log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalCscAndSin(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(new Csc(new Sin(1e-20)),sin, tan, cos, ln,log2,log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalTanAndSin(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, new Tan(cos, new Sin(1e-20)), cos, ln,log2,log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalTanAndCos(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, new Tan(new Cos(sin), sin), cos, ln,log2,log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalTanAndSinAndCos(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, new Tan(new Cos(sin), new Sin(1e-20)), cos, ln,log2,log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalLn(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, cos, new Ln(1e-20),log2,log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalLog2(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, cos, ln,new Log(ln, 2),log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalLog3(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, cos, ln,log2,new Log(ln, 3),log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalLog5(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, cos, ln,log2,log3,new Log(ln, 5),log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalLog10(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, cos, ln,log2,log3,log5,new Log(ln, 10));
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalLog2AndLn(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, cos, ln,new Log(new Ln(1e-20), 2),log3,log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalLog3AndLn(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, cos, ln,log2,new Log(new Ln(1e-20), 3),log5,log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalLog5AndLn(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, cos, ln,log2,log3,new Log(new Ln(1e-20), 5),log10);
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 2.3577070962795593156432819",
            "10, 6.736450233559547752585227",
            "-1, 3.626479778262002303851671",
            "-2, 3.978377778442476714624968",
            "-30, 41.3373505681757163208865",
    })
    void calculateOriginalLog10AndLn(double x, double y) {
        FunctionsSystem functionsSystem = new FunctionsSystem(csc,sin, tan, cos, ln,log2,log3,log5,new Log(new Ln(1e-20), 10));
        Assertions.assertEquals(y, functionsSystem.calculate(x), eps);
    }
}
