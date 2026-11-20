
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request,   HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        session.setAttribute("user", username);
        SessionUser sessionUser = new SessionUser(username);
        session.setAttribute("sessionUser", sessionUser);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'>");
        out.println("<title>Login</title></head><body>");
        out.println("<h2>Login successful!</h2>");
        out.println("<p>Welcome " + username + "</p>");
        out.println("<a href='" + request.getContextPath()+ "/items.html'>Go to items</a>");
        out.println("<br><br>");
        out.println("<a href='" + request.getContextPath()  + "/LogoutServlet'>Logout</a>");
        out.println("</body></html>");
    }
}
