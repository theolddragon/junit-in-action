package kr.theolddragon.junit.chapter_01.example_02;

import kr.theolddragon.junit.chapter_01.example_01.Calculator;

/**
 * 예제 1.2 간단한 계산기 테스트 프로그램
 * Created By tigger on 2018-05-30
 */
public class CalculatorTest {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        if(result != 60) {
            System.out.println("Bad result: " + result);
        }
    }
}
