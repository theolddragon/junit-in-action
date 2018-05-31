package kr.theolddragon.junit.chapter_03;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created By tigger on 2018-05-30
 */
public class DefaultControllerTest {

    private DefaultController controller;
    private Request request;
    private RequestHandler handler;

    /**
     * @Before 메서드는 각 테스트 메서드 사이에서 호출되는 JUnit의 기본 확장 포인트
     * @throws Exception
     */
    @Before
    public void instanticate() throws Exception {
        controller = new DefaultController();

        request = new SampleRequest();
        handler = new SampleHandler();
        controller.addHandler(request, handler);
    }

    @Test
    public void testAddHandler() {

        RequestHandler handler2 = controller.getHandler(request);
        assertSame("Handler we set in controller should be the same handler we get", handler2, handler);
    }

    @Test
    public void testProcessRequest() {

        Response response = controller.processRequest(request);
        assertNotNull("Must not return a null response", response);
        assertEquals(new SampleResponse(), response);
    }

    /**
     * testProcessRequestAnswersError 첫 번째 버전
     */
    @Test
    public void testProcessRequestAnswersError() {

        SampleRequest request = new SampleRequest("testError");
        SampleExceptionHandler handler = new SampleExceptionHandler();
        controller.addHandler(request, handler);

        Response response = controller.processRequest(request);
        assertNotNull("Must not return a null response", response);
        assertEquals(ErrorResponse.class, response.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined() {

        SampleRequest request = new SampleRequest("testNotDefined");

        //다음 줄에서 RuntimeException을 발생시킴
        controller.getHandler(request);
    }

    @Test(expected = RuntimeException.class)
    public void testAddReqeuestDuplicateName() {

        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();

        //다음 줄에서 RuntimeExcpetion을 발생시킴
        controller.addHandler(request, handler);
    }

    @Test(timeout=130)
    @Ignore(value = "Ignore for now until we decide a decent time-limit")
    public void testProicessMultipleReqeustsTimeout() {

        Request request;
        Response response = new SampleResponse();
        RequestHandler handler = new SampleHandler();

        for(int i=0; i<99999; i++) {
            request = new SampleRequest(String.valueOf(i));
            controller.addHandler(request, handler);

            response = controller.processRequest(request);
            assertNotNull(response);
            assertNotSame(ErrorResponse.class, response.getClass());
        }
    }

    /**
     * 약속된 이름(Test)을 반환하는 요청 객체
     */
    private class SampleRequest implements Request {

        private static final String DEFAULT_NAME = "TEST";
        private String name;

        public SampleRequest(String name) {
            this.name = name;
        }
        public SampleRequest() {
            this(DEFAULT_NAME);
        }


        public String getName() {
            return this.name;
        }
    }

    /**
     * SampleHandler
     */
    private class SampleHandler implements RequestHandler {

        /**
         *
         * @param request
         * @return
         * @throws Exception
         */
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {

        private static final String NAME = "Test";

        @Override
        public String getName() {
            return NAME;
        }

        @Override
        public boolean equals(Object object) {

            boolean result = false;
            if(object instanceof SampleResponse) {
                result = ((SampleResponse)object).getName().equals(getName());
            }

            return result;
        }

        @Override
        public int hashCode() {
            return NAME.hashCode();
        }
    }

    /**
     * 예외 사왕을 만들어주는 요청 핸들러
     */
    private class SampleExceptionHandler implements RequestHandler {

        public Response process(Request request) throws Exception {
            throw new Exception("error processing request");
        }
    }
}