import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {
    private static final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        int active = counter.incrementAndGet();
        ServletContext context =event.getSession().getServletContext();
        context.setAttribute("activeSessions", active);
        System.out.println("Session created. Active sessions: " + active);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        int active = counter.decrementAndGet();
        ServletContext context = event.getSession().getServletContext();
        context.setAttribute("activeSessions", active);
        System.out.println("Session destroyed. Active sessions: " + active);
    }
}
