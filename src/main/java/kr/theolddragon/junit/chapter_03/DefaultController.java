package kr.theolddragon.junit.chapter_03;

import java.util.HashMap;
import java.util.Map;

/**
 * 예제 3.2 일반적인 컨트롤러
 * Created By tigger on 2018-05-30
 */
public class DefaultController implements Controller {

    //요청 핸들러들을 등록할 HashMap
    private Map requestHandlers = new HashMap();

    /**
     * 주어진 요청에 적합한 RequestHandler를 반환
     * @param request
     * @return
     */
    protected RequestHandler getHandler(Request request) {

        //RequestHandler를 등록하지 않고, 호출하면 RuntimeException을 발생시킴
        if(!this.requestHandlers.containsKey(request.getName())) {
            String message = "Cannot find handler for request name "
                    + "[" + request.getName() + "]";

            //사용자나 외부 시스템보다는 프로그래밍 실수에 의해 발생한 상황
            //RuntimeException은 명시되지 않더라도 던지고 받아 처리할 수 있는 예외
            //명시적인 예외를 정의해 컨트롤러 프레임워크에 추가하는 것이 더 나은 설계
            throw new RuntimeException(message);
        }

        // - 핸들러 선택 -
        //호출자에게 적절한 핸들러를 반환함
        return (RequestHandler)this.requestHandlers.get(request.getName());
    }

    /**
     *  - 요청 수락 -
     * 요청을 적절한 핸들러에 전달하고, 그 핸들러의 응답을 반환
     * @param request
     * @return
     */
    public Response processRequest(Request request) {

        Response response;
        try {
            // - 요청 라우팅 -
            response = getHandler(request).process(request);
        } catch(Exception exception) {
            // - 오류 처리 -`
            response = new ErrorResponse(request, exception);
        }

        return response;
    }

    public void addHandler(Request request, RequestHandler requestHandler) {

        //핸들러 이름의 등록 여부를 확인
        if(this.requestHandlers.containsKey(request.getName())) {
            throw new RuntimeException("A request handler has"
                    + "already been registerd for request name "
                    + "[" + request.getName() + "]");
        } else {
            this.requestHandlers.put(request.getName(), requestHandler);
        }
    }
}
