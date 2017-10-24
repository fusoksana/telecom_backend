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

public class ExportXMLServlet extends HttpServlet{
    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");

        UsersExport userExport;

        String fileType = request.getQueryString();
        if (fileType.equals("xml")) {
            userExport = new XMLExport();
        }
         else if(fileType.equals("json")){
            userExport=new JsonExport();
        } else {
            userExport = new CSVExport();
        }

        ExportedFile expFile = userExport.getExportedFile();

        response.setHeader("Content-disposition", "attachment; filename=yourcustomfilename."+expFile.getExtention());
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(expFile.getFile());
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.flush();

        }


}

