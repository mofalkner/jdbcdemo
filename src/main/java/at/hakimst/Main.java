package at.hakimst;
import java.sql.*;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("JDBC Demo!");
        selectAllDemo();
        insertStudentDemo();
        selectAllDemo();
    }

    public  static void updateStudentDemo()
    {

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