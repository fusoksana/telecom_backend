import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.*;
import java.util.List;

public class UserServlet4 extends HttpServlet{
    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
        JAXBContext contextObj = null;
        try {
            contextObj = JAXBContext.newInstance(Users.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Marshaller marshallerObj = null;
        try {
            marshallerObj = contextObj.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try {
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (PropertyException e) {
            e.printStackTrace();
        }


        JDBCUsers j=new JDBCUsers();
        List<User> user =j.getUsersFromDB();
        Users us=new Users(user);

        try {

           marshallerObj.marshal(us, new FileOutputStream("/home/yurko/OKSANA/java/Users.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        String file="/home/yurko/OKSANA/java/Users.xml";
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

