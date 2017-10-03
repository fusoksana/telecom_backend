import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class UserServlet2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
        String url2=request.getPathInfo();
        StringBuilder sb = new StringBuilder(url2);
        sb.deleteCharAt(0);
        url2=sb.toString();
        int ID=Integer.parseInt(url2);
        PrintWriter pw=response.getWriter();
        JDBCUsers j=new JDBCUsers();
        User user=j.getUserFromDataBase(ID);
        Gson gson = new Gson();
        String jsonInString = gson.toJson(user);
        pw.println( jsonInString);

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
        int IDEdit=Integer.parseInt(ID);
        String firstNameEdit=parseString(parts[1]);
        String lastNameEdit=parseString(parts[2]);


        JDBCUsers j=new JDBCUsers();
        boolean b=j.editUser(IDEdit,firstNameEdit,lastNameEdit);
        PrintWriter pw=response.getWriter();
        pw.println("{\"status\" : \""+b+"\"}");


    }
    public String parseString(String parts2){
        String[]partsN=parts2.split("=");
        String value=partsN[1];
        return value;



    };


}
