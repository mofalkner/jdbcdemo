package at.hakimst;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo","root","");
                PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM `student`");
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