package lv.javaguru.java2.mvc;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public interface MVCController {
    MVCModel processRequest(HttpServletRequest request,
                            HttpServletResponse response);
}