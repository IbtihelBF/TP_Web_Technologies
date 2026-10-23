package Ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>Cookies</title></head><body>");
        out.println("<h2>Cookies values</h2>");
        
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            out.println("<p>No cookies found.</p>");
        } else {
            out.println("<table border='1'>");
            for (Cookie c : cookies) {
                String name = c.getName();
                if (name.equals("firstName") || name.equals("lastName") || name.equals("birthDate") || name.equals("sex")) {
                	out.println("<tr><th>" + name + "</th><td>" + URLDecoder.decode(c.getValue(), "UTF-8") + "</td></tr>");
                }
            }
            out.println("</table>");
        }
        out.println("<br><a href='tp1.html'>Back</a>");
        out.println("</body></html>");
    }
}