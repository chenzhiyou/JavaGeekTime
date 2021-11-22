package remoteLearn;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServletA extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String message = "if you are reading this , it worked!";
        out.println("<HTML><BODY>");
        out.println("<H1> + message +</H1>");
        out.println("</BODY><HTML>");
        out.close();
    }

}
