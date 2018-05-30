package kr.theolddragon.junit.chapter_01.example_03;

import kr.theolddragon.junit.chapter_01.example_01.Calculator;

/**
 * 예제 1.3 조금 개선된 계산기 프로그램
 * Created By tigger on 2018-05-30
 */
public class CalculatorTest {

    private int nbErrors = 0;

    /**
     * 테스트 로직
     */
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        if(result != 60) {
            throw new IllegalStateException("Bad result: " + result);
        }
    }

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();

        /**
         * 오류 발생 시 스택 추적 정보를 출력
         * 발생한 오류들을 요약한 예외를 던짐
         */
        try {
            test.testAdd();
        } catch(Throwable e) {
            test.nbErrors++;
            e.printStackTrace();
        }

        if(test.nbErrors > 0) {
            throw new IllegalStateException("There were " + test.nbErrors + " error(s)");
        }
    }
}
