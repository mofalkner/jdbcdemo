package at.hakimst;
import java.sql.*;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("JDBC Demo!");
        selectAllStudentDemo();
    }

    private static void findAllByNameLike(String pattern)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo","root","");
                PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM student WHERE student.name LIKE ?");
                preparedStatement.setString(1,"%"+pattern+"%");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    System.out.println("Student aus der DB: [ID] " + id + " [NAME] " + name + " [EMAIL] " + email);
                }
            }
            catch (SQLException e)
            {
                throw new RuntimeException("Die Verbindung nicht möglich!");
            }
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException("Treiber nicht gefunden!");
        }
    }

    public static void deleteStudentDemo(int studentID)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo","root","");
                PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM student WHERE student.id = ?;");
                try
                {
                    preparedStatement.setInt(1,studentID);
                    int rowAffected = preparedStatement.executeUpdate();
                    System.out.println("Anzahl der gelöschten Datensätze: " + rowAffected);
                }
                catch (SQLException ex)
                {
                    System.out.println("Fehler im SQL-DELETE Statement: " + ex.getMessage());
                }
            }
            catch (SQLException e)
            {
                throw new RuntimeException("Die Verbindung nicht möglich!");
            }
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException("Treiber nicht gefunden!");
        }
    }

    public  static void updateStudentDemo( int ID, String neuerName, String neueEmail)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo","root","");
                PreparedStatement preparedStatement = con.prepareStatement("UPDATE student SET name=?, email=? WHERE student.id=?;");
                try
                {
                    preparedStatement.setString(1,neuerName);
                    preparedStatement.setString(2,neueEmail);
                    preparedStatement.setInt(3,ID);
                    int affectedRows = preparedStatement.executeUpdate();
                    System.out.println("Anzahl der aktualisierten Datensätze: " + affectedRows);
                }
                catch (SQLException ex)
                {
                    System.out.println("Fehler im SQL-UPDATE Statement: " + ex.getMessage());
                }
            }
            catch (SQLException e)
            {
                throw new RuntimeException("Die Verbindung nicht möglich!");
            }
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException("Treiber nicht gefunden!");
        }
    }

    public static void insertStudentDemo(String name, String email)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo","root","");
                PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, ?, ?);");
                try
                {
                    preparedStatement.setString(1,name);
                    preparedStatement.setString(2,email);
                    int rowAffected = preparedStatement.executeUpdate();
                    System.out.println(rowAffected + " Datensätze eingefügt!");

                }
                catch (SQLException ex)
                {
                    System.out.println("Fehler im SQL-INSERT Statement: " + ex.getMessage());
                }
            }
            catch (SQLException e)
            {
                throw new RuntimeException("Die Verbindung nicht möglich!");
            }
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException("Treiber nicht gefunden!");
        }
    }

    public static void selectAllStudentDemo()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo","root","");
                PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM student;");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    System.out.println("Student aus der DB: [ID] " + id + " [NAME] " + name + " [EMAIL] " + email);
                }
            }
            catch (SQLException e)
            {
                throw new RuntimeException("Die Verbindung nicht möglich!");
            }
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException("Treiber nicht gefunden!");
        }
    }
}