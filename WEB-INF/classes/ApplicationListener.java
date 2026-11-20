import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        context.setAttribute("appName", "MP2 Web Application");
        System.out.println("Application started.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Application stopped.");
    }
}
