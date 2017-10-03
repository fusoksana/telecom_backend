import org.junit.Test;

public class JDBCUserTest {

    @Test
    public void testEditUser() throws Exception {
        JDBCUsers jdbcUsers = new JDBCUsers();
        User user = jdbcUsers.getUserFromDataBase(17);
        System.out.println(user);
    }

}