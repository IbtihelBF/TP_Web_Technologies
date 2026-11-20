import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {
    private String logPrefix;

    @Override
    public void init(FilterConfig config) throws ServletException {
        logPrefix = config.getInitParameter("logPrefix");
        System.out.println(logPrefix + " Filter initialized.");
    }

    @Override
    public void doFilter(ServletRequest request,  ServletResponse response,  FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURL().toString();
        long startTime = System.nanoTime();
        System.out.println(logPrefix + " Before chain.doFilter(): " + url);

        try {
            chain.doFilter(request, response);
        } finally {

            System.out.println(logPrefix + " After chain.doFilter(): " + url);
            long endTime = System.nanoTime();
            double executionTime = (endTime - startTime) / 1_000_000.0;

            System.out.println(logPrefix + " Execution time: "  + executionTime + " ms");
        }
    }

    @Override
    public void destroy() {
        System.out.println(logPrefix + " Filter destroyed.");
    }
}
