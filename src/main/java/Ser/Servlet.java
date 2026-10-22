package Ser;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("tp1.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String firstName = escape(request.getParameter("firstName"));
        String lastName  = escape(request.getParameter("lastName"));
        String birthDate = escape(request.getParameter("birthDate"));
        String sex       = escape(request.getParameter("sex"));

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><meta charset='UTF-8'>");
            out.println("<title>Personal Information</title></head><body>");
            out.println("<h2>Personal Information</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>First Name</th><td>" + firstName + "</td></tr>");
            out.println("<tr><th>Last Name</th><td>" + lastName + "</td></tr>");
            out.println("<tr><th>Birth Date</th><td>" + birthDate + "</td></tr>");
            out.println("<tr><th>Sex</th><td>" + sex + "</td></tr>");
            out.println("</table>");
            out.println("<br><a href='tp1.html'>Back</a>");
            out.println("</body></html>");
        }
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;");
    }
}