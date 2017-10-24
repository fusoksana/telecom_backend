import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurko on 24.10.17.
 */
public class CSVExport  implements UsersExport{
    private static final String CSV_SEPARATOR = ",";




    @Override
    public ExportedFile getExportedFile() {
        String file = "/home/yurko/OKSANA/java/Users.csv";

        JDBCUsers j = new JDBCUsers();
        List<User> usersList = j.getUsersFromDB();
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            for (User user : usersList) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(user.getID() <= 0 ? "" : user.getID());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(user.getFirstName().trim().length() == 0 ? "" : user.getFirstName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(user.getLastName().trim().length() == 0 ? "" : user.getLastName());
                oneLine.append(CSV_SEPARATOR);
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }


        return new ExportedFile(file, "csv");


    }


}
