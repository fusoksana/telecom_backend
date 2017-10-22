import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by yurko on 30.09.17.
 */
public class ExportJsonServlet extends HttpServlet {
    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");

        JDBCUsers j=new JDBCUsers();
        List<User> listU =j.getUsersFromDB();
        Gson gson = new Gson();

        String jsonInString = gson.toJson(listU);
        String file="/home/yurko/OKSANA/java/Users.json";

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(jsonInString);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        response.setHeader("Content-disposition","attachment; filename=yourcustomfilename.txt");
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(file);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }
        in.close();
        out.flush();

    }

}
