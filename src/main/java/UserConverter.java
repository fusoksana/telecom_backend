import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurko on 04.10.17.
 */
public class UserConverter {


    public List<User> convert(String filePath) {
        //filePath = "/home/yurko/OKSANA/java/Users.json";
        // logic that reads file from path
        // use gson to convert that file to objects
        // return objects
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson=new Gson();
       List<User> usersFromFile = gson.fromJson(br, new TypeToken<List<User>>() {
       }.getType());;

        //

//        Expected BEGIN_OBJECT but was BEGIN_ARRAY at
//
//                User це обєкт
//                а в файлі в тебе арей обєктів
//
//                пошукай how to convert json to List objects


//        InputStream inJson = null;
//        try {
//            inJson = new FileInputStream(new File(filePath));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//         User   usersFromFile = new ObjectMapper().readValue(inJson, User.class);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("ASDASD");
        System.out.println("ASDASD1");
        return usersFromFile;
    }
}
