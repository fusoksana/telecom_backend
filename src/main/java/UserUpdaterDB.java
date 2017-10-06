import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yurko on 04.10.17.
 */
public class UserUpdaterDB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Users";


    static final String USER = "root";
    static final String PASS = "1234";

    public List<User> updateDB(List<User> lU) {
        Connection conn = null;
        Statement stmt = null;
        List<User> listUsers = new ArrayList<User>();
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            Iterator<User> itr=lU.iterator();
            while (itr.hasNext()){
                User user=itr.next();
                int IDN=user.getID();
                String firstNameN=user.getFirstName();
                String lastNameN=user.getLastName();
                String sql = "INSERT INTO Users (ID,firstName,lastName) VALUES (" +IDN+",'"+firstNameN+"','"+lastNameN+"') ON DUPLICATE KEY UPDATE   firstName='" +firstNameN+"',lastName='"+lastNameN+"'";

                stmt.executeUpdate(sql);
            }



             String sql = "SELECT ID, firstName, lastName FROM Users ORDER BY ID ASC;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int ID = rs.getInt("ID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                User user = new User(ID, firstName, lastName);
                listUsers.add(user);


            }
            rs.close();
        } catch (SQLException se) {

            se.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return listUsers;
    }

    }

