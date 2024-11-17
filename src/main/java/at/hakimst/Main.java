package at.hakimst;
import java.sql.*;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("JDBC Demo!");
        selectAllDemo();
        deleteStudentDemo(5);
        selectAllDemo();
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

    public  static void updateStudentDemo()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo","root","");
                PreparedStatement preparedStatement = con.prepareStatement("UPDATE student SET name=?, email=? WHERE student.id=4;");
                try
                {
                    preparedStatement.setString(1,"Hans Zimmer");
                    preparedStatement.setString(2,"h.zi765@trx.at");
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

    public static void insertStudentDemo()
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
                    preparedStatement.setString(1,"Peter Zeck");
                    preparedStatement.setString(2,"p.zeck@gmail.com");
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

    public static void selectAllDemo()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo","root","");
                PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM `student`;");
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
        //INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, 'Moritz Falkner', 'moritzfalkner@gmail.com'), (NULL, 'Jakob Falkner', 'jafalkner@gmail.com');
    }
}