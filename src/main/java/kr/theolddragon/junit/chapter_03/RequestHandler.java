package kr.theolddragon.junit.chapter_03;

/**
 * 예제 3.1 요청 핸들러
 *
 * - 대부분의 처리를 맡을 목적으로 설계된 도우미 Component
 * Created By tigger on 2018-05-30
 */
public interface RequestHandler {

    Response process(Request request) throws Exception;
}
