package kr.theolddragon.junit.chapter_03;

/**
 * 예제 3.1 Controller
 * Created By tigger on 2018-05-30
 */
public interface Controller {

    /**
     * 요청을 처리할 최상위 메서드
     * 제어 스택의 마지막에 해당하므로, 실행 과정 중 발생하는 모든 예외를 잡아 스스로 처리해야 함
     * @param request
     * @return
     */
    Response processRequest(Request request);

    /**
     * 자바 소스를 수정하지 않고도 향후 손쉽게 기능을 확장할 수 있는 길을 터줌
     * @param request
     * @param requestHandler
     */
    void addHandler(Request request, RequestHandler requestHandler);
}
