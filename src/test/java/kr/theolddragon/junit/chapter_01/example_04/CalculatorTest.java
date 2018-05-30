package kr.theolddragon.junit.chapter_01.example_04;

import kr.theolddragon.junit.chapter_01.example_01.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 예제 1.4 JUnit을 적용한 CalculatorTest 프로그램
 * Created By tigger on 2018-05-30
 */
public class CalculatorTest {       //반드시 public 이어야 한다는 제약만 지킨다면 어떤 이름을 사용하건 상관없음

    @Test                           //이 메서드가 단위 테스트 메서드임을 표시함
    public void testAdd() {         //Calculator 클래스(테스트 대상 객체)의 인스턴스를 생성함으로써 본격적인 테스트에 착수
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        assertEquals(60, result, 0);    //테스트 결과를 확인
    }
}
