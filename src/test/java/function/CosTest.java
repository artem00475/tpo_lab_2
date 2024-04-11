package function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CosTest {
    private Cos cos;
    private final double eps = 1e-10;

    @DisplayName("Вычисление косинуса")
    @ParameterizedTest
    @ValueSource(doubles = {
            Math.PI/8,
            Math.PI,
            Math.PI/6,
            Math.PI/10,
            10,
            -5
    })
    void calculateCos(double x) {
        final Sin sin = Mockito.mock(Sin.class);
        Mockito.when(sin.calculate(Math.PI/2 - x)).thenReturn(Math.sin(Math.PI/2 - x));
        cos = new Cos(sin);
        Assertions.assertEquals(Math.cos(x), cos.calculate(x), eps);
    }

    @Test
    @DisplayName("Вызов функции синуса")
    void callSinFunction() {
        final Sin sin = Mockito.mock(Sin.class);
        cos = new Cos(sin);
        cos.calculate(10);
        Mockito.verify(sin, Mockito.atLeastOnce()).calculate(Math.PI/2 - 10);
    }
}
