import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by yurko on 23.10.17.
 */
public class XMLExport implements UsersExport {

    @Override
    public ExportedFile getExportedFile() {
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


        JDBCUsers j = new JDBCUsers();
        List<User> user = j.getUsersFromDB();
        Users us = new Users(user);

        try {
            marshallerObj.marshal(us, new FileOutputStream("/home/yurko/OKSANA/java/Users.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String file = "/home/yurko/OKSANA/java/Users.xml";
        return new ExportedFile(file, "xml");
    }
}
