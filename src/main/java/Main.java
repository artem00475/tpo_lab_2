import csv.CsvHandler;
import function.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        CsvHandler cswWriter = new CsvHandler("src/test/resources", ",");
//        List<Double> arrayList = List.of(2.0, -1.0, -2.0, 10.0, -30.0);
//        arrayList.forEach(aDouble -> cswWriter.writeResult("sin.csv", "sin", aDouble, Math.sin(aDouble)));
//        arrayList.forEach(aDouble -> cswWriter.writeResult("cos.csv", "cos", aDouble, Math.cos(aDouble)));
//        arrayList.forEach(aDouble -> cswWriter.writeResult("csc.csv", "csc", aDouble, 1/Math.sin(aDouble)));
//        arrayList.forEach(aDouble -> cswWriter.writeResult("tan.csv", "tan", aDouble, Math.sin(aDouble)/Math.cos(aDouble)));
//        arrayList.forEach(aDouble -> cswWriter.writeResult("ln.csv", "ln", aDouble, Math.log(aDouble)));
//        arrayList.forEach(aDouble -> cswWriter.writeResult("log2.csv", "log2", aDouble, Math.log(aDouble)/Math.log(2)));
//        arrayList.forEach(aDouble -> cswWriter.writeResult("log3.csv", "log3", aDouble, Math.log(aDouble)/Math.log(3)));
//        arrayList.forEach(aDouble -> cswWriter.writeResult("log5.csv", "log5", aDouble, Math.log(aDouble)/Math.log(5)));
//        arrayList.forEach(aDouble -> cswWriter.writeResult("log10.csv", "log10", aDouble, Math.log10(aDouble)));
//        arrayList = List.of(Math.PI/2 - 2.0, Math.PI/2+1.0, Math.PI/2+2.0, Math.PI/2 - 10.0, Math.PI/2+30.0);
//        arrayList.forEach(aDouble -> cswWriter.writeResult("sin.csv", "sin", aDouble, Math.sin(aDouble)));
//        arrayList = List.of(3.0, 5.0);
//        arrayList.forEach(aDouble -> cswWriter.writeResult("ln.csv", "ln", aDouble, Math.log(aDouble)));
        CsvHandler csvHandler = new CsvHandler("src/main/resources", ",");
        Sin sin = new Sin(1e-20);
        Cos cos = new Cos(sin);
        Tan tan = new Tan(cos, sin);
        Csc csc = new Csc(sin);
        for (double i = -5; i <= 0; i += 0.01) {
            csvHandler.writeResult("sin.csv", "sin", i, sin.calculate(i));
            csvHandler.writeResult("cos.csv", "cos", i, cos.calculate(i));
            csvHandler.writeResult("tan.csv", "tan", i, tan.calculate(i));
            csvHandler.writeResult("csc.csv", "csc", i, csc.calculate(i));
        }


//        System.out.println(sin.calculate(Math.PI / 4));
//        Ln ln = new Ln(1e-20);
//        System.out.println(Math.log(2));
//        System.out.println(ln.calculate(2));
//
//        System.out.println(cos.calculate(10));
//        System.out.println(Math.cos(10));
//
//        System.out.println(tan.calculate(Math.PI));
//        System.out.println(Math.tan(-3));
//
//        System.out.println(csc.calculate(3));
//        System.out.println(1 / Math.sin(3));
//        Log lg = new Log(ln, 10);
//        System.out.println(lg.calculate(3));
//        System.out.println(Math.log10(3));
//        FunctionsSystem functionsSystem = new FunctionsSystem(
//                csc,
//                sin,
//                tan,
//                cos,
//                ln,
//                new Log(ln, 2),
//                new Log(ln, 3),
//                new Log(ln, 5),
//                lg
//        );
//        System.out.println(functionsSystem.calculate(-30));
    }
}
