package lv.javaguru.java2.servlet.mvc;
import lv.javaguru.java2.servlet.SpringAppConfig;
import lv.javaguru.java2.servlet.mvc.controllers.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MVCFilter implements Filter {
    private Map<String, MVCController> controllerMapping;
    private ApplicationContext springContext;

    private static Logger logger = Logger.getLogger(MVCFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            springContext =
                    new AnnotationConfigApplicationContext(SpringAppConfig.class);
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e);
        }


        controllerMapping =  new HashMap<String, MVCController>();
        controllerMapping.put("/hello",  getBean( HelloWorldController.class));
        controllerMapping.put("/prod",  getBean( SearchResController.class));
        controllerMapping.put("/raw",  getBean( RawPageController.class));
        controllerMapping.put("/register",  getBean( RegisterPageController.class));
        controllerMapping.put("/description",  getBean( ProdDescripPageController.class));
        controllerMapping.put("/index",  getBean( IndexController.class));
        controllerMapping.put("/balance",  getBean( BalancePageController.class));
        controllerMapping.put("/onSale",  getBean( UserSalesController.class));
    }
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        String contextURI = req.getServletPath();

        if (controllerMapping.keySet().contains(contextURI)){
            MVCController controller = controllerMapping.get(contextURI);
            MVCModel model = controller.processRequest(req, resp);
            req.setAttribute("model", model.getData());

            ServletContext context = req.getServletContext();

            RequestDispatcher requestDispacher =
                    context.getRequestDispatcher(model.getView());
            requestDispacher.forward(req, resp);

        }
        else filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
    }

    private MVCController getBean(Class clazz){
        return (MVCController) springContext.getBean(clazz);
    }

}