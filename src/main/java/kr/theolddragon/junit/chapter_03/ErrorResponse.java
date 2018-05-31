package kr.theolddragon.junit.chapter_03;

/**
 * 예제 3.3 에러 발생을 알리는 특수한 응답 클래스
 * Created By tigger on 2018-05-30
 */
public class ErrorResponse implements Response {

    private Request originalRequest;
    private Exception originalException;

    @Override
    public String getName() {
        return null;
    }

    public ErrorResponse(Request request, Exception exception) {
        this.originalRequest = request;
        this.originalException = exception;
    }

    public Request getOriginalRequest() {
        return this.originalRequest;
    }

    public Exception getOriginalException() {
        return this.originalException;
    }
}
