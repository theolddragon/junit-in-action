package kr.theolddragon.junit.chapter_03;

/**
 * 예제 3.1 요청 인터페이스
 * Created By tigger on 2018-05-30
 */
public interface Request {

    /**
     * 요청에 대한 고유한 이름을 반환
     * 다른 요청과 구분하기 위한 용도
     * @return
     */
    String getName();
}
