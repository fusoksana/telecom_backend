/**
 * Created by yurko on 19.08.17.
 */



import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
public class UsersServlet extends HttpServlet{
    private String message;



    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();

        pw.println("<html><body>");
        List<Users> listU =new ArrayList<Users>();
        Users u1=new Users("44","Oksana","Vasko");
        Users u2=new Users("47","Alina","Rex");
        Users u3=new Users("49","Olga","Fus");
        listU.add(u1);
        listU.add(u2);
        listU.add(u3);
        Iterator<Users> itrU=listU.iterator();
        while (itrU.hasNext()){
            Users elem=itrU.next();
            pw.println(elem+"<br>");
        }

        pw.println("</body></html>");

        pw.close();
    }

}
