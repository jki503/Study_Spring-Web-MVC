package mvc1.servlet.web.frontcontroller.v5;

import mvc1.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    /**
     * 어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드
     */
    boolean supports(Object handler);

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return ModelView
     * @throws ServletException
     * @throws IOException
     *
     */
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;

}
