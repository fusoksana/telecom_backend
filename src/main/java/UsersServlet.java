/**
 * Created by yurko on 19.08.17.
 */

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UsersServlet extends HttpServlet{

    private String message;



    public void init() throws ServletException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");

        PrintWriter pw=response.getWriter();
      JDBCUsers j=new JDBCUsers();
        List<Users> listU =j.getUsersFromDB();
        j.deleteUsersFromDB();







//        List<Users> listU= new ArrayList<Users>();
//       Users u1=new Users(44,"Oksana","Vasko");
//      Users u2=new Users(47,"Alina","Rex");
//      Users u3=new Users(49,"Olga","Fus");
//     listU.add(u1);
//      listU.add(u2);
//      listU.add(u3);


            Gson gson = new Gson();

            String jsonInString = gson.toJson(j.deleteUsersFromDB());
            pw.println( jsonInString);

        }


    }


