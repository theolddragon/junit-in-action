package kr.theolddragon.junit.chapter_02.example_02;

import kr.theolddragon.junit.chapter_01.example_01.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * 예제 2.2 파라미터화 테스트
 * Created By tigger on 2018-05-30
 */
@RunWith(value=Parameterized.class)
public class ParameterizedTest {

    private double expected;
    private double valueOne;
    private double valueTwo;

    @Parameterized.Parameters
    public static Collection<Integer[]> getTestParameter() {
        return Arrays.asList(new Integer[][] {
                {2, 1, 1},  //예상값, 값1, 값2
                {3, 2, 1},  //예상값, 값1, 값2
                {4, 3, 1},  //예상값, 값1, 값2
        });
    }

    public ParameterizedTest(double expected, double valueOne, double valueTwo) {
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Test
    public void sum() {
        Calculator calc = new Calculator();
        assertEquals(expected, calc.add(valueOne, valueTwo), 0);
    }
}
