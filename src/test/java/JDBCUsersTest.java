import org.junit.Test;

import static org.junit.Assert.*;

public class JDBCUsersTest {

    @Test
    public void testEditUser() throws Exception {
        JDBCUsers jdbcUsers = new JDBCUsers();
        Users user = jdbcUsers.getUserFromDataBase(17);
        System.out.println(user);
    }

}