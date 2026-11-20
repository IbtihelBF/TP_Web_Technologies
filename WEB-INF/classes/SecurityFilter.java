import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("SecurityFilter initialized.");
    }
    
    @Override
    public void doFilter(ServletRequest request,  ServletResponse response,  FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        System.out.println("SecurityFilter: Before chain.doFilter()");
        HttpSession session = httpRequest.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            System.out.println("User authenticated.");
            chain.doFilter(request, response);
            System.out.println("SecurityFilter: After chain.doFilter()");

        } else {
            System.out.println("Access refused. User not authenticated.");
            httpResponse.sendRedirect( httpRequest.getContextPath() + "/login.html");
        }
    }
    @Override
    public void destroy() {
        System.out.println("SecurityFilter destroyed.");
    }
}
