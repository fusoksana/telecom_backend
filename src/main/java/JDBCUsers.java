

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JDBCUsers {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Users";


    static final String USER = "root";
    static final String PASS = "1234";

    public List<Users> getUsersFromDB() {


        Connection conn = null;
        Statement stmt = null;
        List<Users> listUsers = new ArrayList<Users>();
        try {

            Class.forName("com.mysql.jdbc.Driver");


            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ID, firstName, lastName FROM Users";
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {

                int ID = rs.getInt("ID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");

                //   System.out.print("ID: " + ID);
                // System.out.print(", firstName: " + firstName);
                // System.out.println(", lastName: " + lastName);

                // System.out.println(user);
                Users user = new Users(ID, firstName, lastName);
                listUsers.add(user);
            }

//            Iterator<Users>itr=listUsers.iterator();
//            while (itr.hasNext()){
//                Users elem=itr.next();
//                System.out.println(elem);
//            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            return listUsers;

        }

    }

    public List<Users> deleteUsersFromDB( int IDDelete) {


        Connection conn = null;
        Statement stmt = null;
        List<Users> listUsers = new ArrayList<Users>();
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "DELETE FROM Users " +
                    "WHERE ID ="+ IDDelete;
            stmt.executeUpdate(sql);


            sql = "SELECT ID, firstName, lastName FROM Users";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int ID = rs.getInt("ID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Users user = new Users(ID, firstName, lastName);
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
        }return listUsers;
    }
    public boolean addUsersToDB( int IDN,String firstNameN,String lastNameN) {


        Connection conn = null;
        Statement stmt = null;
        List<Users> listUsers = new ArrayList<Users>();
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "INSERT INTO Users (ID,firstName,lastName) VALUES (" +IDN+",'"+firstNameN+"','"+lastNameN+"')";
            stmt.executeUpdate(sql);


            sql = "SELECT ID, firstName, lastName FROM Users";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int ID = rs.getInt("ID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Users user = new Users(ID, firstName, lastName);
                listUsers.add(user);


            }
            rs.close();
        } catch (SQLException se) {

            se.printStackTrace();
            return false;
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
        }return true ;
    }
    public boolean editUser( int IDEdit,String firstNameEdit,String lastNameEdit) {


        Connection conn = null;
        Statement stmt = null;
        List<Users> listUsers = new ArrayList<Users>();
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "UPDATE Users SET firstName='"+firstNameEdit+"' ,lastName ='"+lastNameEdit+"' WHERE ID="+IDEdit+";";
            stmt.executeUpdate(sql);


            sql = "SELECT ID, firstName, lastName FROM Users";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int ID = rs.getInt("ID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Users user = new Users(ID, firstName, lastName);
                listUsers.add(user);


            }
            rs.close();
        } catch (SQLException se) {

            se.printStackTrace();
            return false;
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
        }return true ;
    }
    public Users getUserFromDataBase( int IDUser) {


        Connection conn = null;
        Statement stmt = null;
        Users user=null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Users WHERE ID=" +IDUser;


            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int ID = rs.getInt("ID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                user = new Users(ID, firstName, lastName);
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
        }return user;
    }


}