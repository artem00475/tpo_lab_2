package function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SinTest {
    private Sin sin;
    private final double eps = 1e-10;
    @BeforeEach
    void before() {
        sin = new Sin(eps);
    }

    @DisplayName("Вычисление синуса")
    @ParameterizedTest
    @ValueSource(doubles = {
            Math.PI/8,
            Math.PI,
            Math.PI/6,
            Math.PI/10,
            10,
            -5
    }
    )
    void calculateSin(double x) {
        Assertions.assertEquals(Math.sin(x), sin.calculate(x), eps);
    }
}
