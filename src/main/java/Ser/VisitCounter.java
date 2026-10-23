package Ser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisitCounter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int visits = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visits")) {
                    visits = Integer.parseInt(c.getValue());
                }
            }
        }
        
        visits++;
        Cookie visitCookie = new Cookie("visits", String.valueOf(visits));
        visitCookie.setMaxAge(60 * 60 * 24 * 30); // 30 jours
        response.addCookie(visitCookie);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>Visits</title></head><body>");
        out.println("<h2>Number of visits: " + visits + "</h2>");
        out.println("<a href='tp1.html'>Back</a>");
        out.println("</body></html>");
    }
}