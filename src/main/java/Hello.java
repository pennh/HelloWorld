import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Hello extends HttpServlet {

   private String message;

   public void init() throws ServletException {
      message = "Hello World from Hello.java";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>");
   }
   
   public int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
   }
}
