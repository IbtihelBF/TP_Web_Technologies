import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer visits = (Integer) session.getAttribute("visits");

        if (visits == null) {
            visits = 0;
        }

        visits++;
        session.setAttribute("visits", visits);
        Integer activeSessions = (Integer) getServletContext().getAttribute("activeSessions");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'>");
        out.println("<title>Session</title></head><body>");
        out.println("<h2>Session Information</h2>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Number of visits: " + visits + "</p>");
        out.println("<p>Active sessions: " + activeSessions + "</p>");
        out.println("<a href='tp1.html'>Back</a>");
        out.println("</body></html>");
    }
}
