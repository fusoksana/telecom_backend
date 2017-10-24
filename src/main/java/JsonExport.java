import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by yurko on 23.10.17.
 */
public class JsonExport implements UsersExport {

    @Override
    public ExportedFile getExportedFile() {

        JDBCUsers j = new JDBCUsers();
        List<User> listU = j.getUsersFromDB();
        Gson gson = new Gson();

        String jsonInString = gson.toJson(listU);
        String file = "/home/yurko/OKSANA/java/Users.json";

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
        return new ExportedFile(file, "json");
    }

}
