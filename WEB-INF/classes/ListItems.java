import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListItems extends HttpServlet {
    protected void doPost(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");

        if (items == null) {
            items = new ArrayList<String>();
        }
        String newItem = request.getParameter("newItem");

        if (newItem != null && !newItem.trim().isEmpty()) {
            items.add(newItem);
            Map<String, Integer> counts = (Map<String, Integer>) session.getAttribute("counts");

            if (counts == null) {
                counts = new HashMap<String, Integer>();
            }
            counts.put(newItem, counts.getOrDefault(newItem, 0) + 1);
            session.setAttribute("counts", counts);
        }
        session.setAttribute("items", items);
        response.sendRedirect(request.getContextPath() + "/ListItems");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        Map<String, Integer> counts = (Map<String, Integer>) session.getAttribute("counts");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><meta charset='UTF-8'></head><body>");
        out.println("<h2>My Items</h2>");
        out.println("<form action='ListItems' method='POST'>");
        out.println("Item: <input type='text' name='newItem'>");
        out.println("<input type='submit'>");
        out.println("</form>");
        out.println("<h3>Items List:</h3>");

        if (items != null) {
            out.println("<ul>");
            for (String item : items) {
                out.println("<li>" + item + "</li>");
            }
            out.println("</ul>");
            out.println("<h3>Number of times each item was entered:</h3>");
            out.println("<ul>");

            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                out.println("<li>" + entry.getKey() + " : "
                    + entry.getValue() + "</li>");
            }
            out.println("</ul>");
        }

        out.println("</body></html>");
    }
}
