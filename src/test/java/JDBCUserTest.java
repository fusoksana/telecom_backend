import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JDBCUserTest {

    @Test
    public void testEditUser() throws Exception {
        JDBCUsers jdbcUsers = new JDBCUsers();
        User user = jdbcUsers.getUserFromDataBase(17);
        System.out.println(user);
    }

    @Test
    public void testImport(){
        UserConverter uc = new UserConverter();
        String filePath = "/home/yurko/OKSANA/java/Users.json";
        List<User> usersList = uc.convert(filePath);
        Assert.assertNotNull(usersList);
        Assert.assertEquals(10, usersList.size());

    }
    @Test
    public void testUpdateDB(){
        UserConverter userc=new UserConverter();
        List<User> lU=userc.convert("/home/yurko/OKSANA/java/Users2.json");
        UserUpdaterDB uUpdate=new UserUpdaterDB();
//        List<User> lU=new ArrayList<User>();
//        User un1=new User(89,"jjk","kkok");
//        User un2=new User(88,"lll","vvvv");
//        lU.add(un1);
//        lU.add(un2);

        List<User>listNew=uUpdate.updateDB(lU);
        Assert.assertNotNull(listNew);
        Assert.assertEquals(16, listNew.size());
    }
    @Test
    public void testImportXML(){
        UserConverter ucXML=new UserConverter();
        String filePath = "/home/yurko/OKSANA/java/Users.xml";
        List<User> lUXML=ucXML.convertFromXML(filePath);
        Assert.assertEquals(10, lUXML.size());
    }

}