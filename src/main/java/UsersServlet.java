/**
 * Created by yurko on 19.08.17.
 */

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");

        PrintWriter pw=response.getWriter();
        JDBCUsers j=new JDBCUsers();
        List<Users> listU =j.getUsersFromDB();








//        List<Users> listU= new ArrayList<Users>();
//       Users u1=new Users(44,"Oksana","Vasko");
//      Users u2=new Users(47,"Alina","Rex");
//      Users u3=new Users(49,"Olga","Fus");
//     listU.add(u1);
//      listU.add(u2);
//      listU.add(u3);


        Gson gson = new Gson();

        String jsonInString = gson.toJson(listU);
        pw.println( jsonInString);

    }

    @Override
    public void doOptions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");


        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        String[] parts = body.split("&");

        String ID=parseString(parts[0]);
        int IDN=Integer.parseInt(ID);
        String firstNameN=parseString(parts[1]);
        String lastNameN=parseString(parts[2]);


      JDBCUsers j=new JDBCUsers();
       j.addUsersToDB(IDN,firstNameN,lastNameN);
//        List<Users> listU3 =j.getUsersFromDB();


    }
    public String parseString(String parts2){
        String[]partsN=parts2.split("=");
        String value=partsN[1];
        return value;



    };



    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");

        String uri=request.getPathInfo();

//        uri = uri.substring(1);
//
//        uri = uri.replace("/","");




        StringBuilder sb = new StringBuilder(uri);
        sb.deleteCharAt(0);
        uri=sb.toString();
        int ID=Integer.parseInt(uri);
//
        PrintWriter pw=response.getWriter();
        JDBCUsers j=new JDBCUsers();
        j.deleteUsersFromDB(ID);
        List<Users> listU2 =j.getUsersFromDB();
//
//
//
//
//
//
//
//
////        List<Users> listU= new ArrayList<Users>();
////       Users u1=new Users(44,"Oksana","Vasko");
////      Users u2=new Users(47,"Alina","Rex");
////      Users u3=new Users(49,"Olga","Fus");
////     listU.add(u1);
////      listU.add(u2);
////      listU.add(u3);
//
//
        Gson gson = new Gson();
//
        String jsonInString = gson.toJson(listU2);
        pw.println( jsonInString);
//
    }


}


