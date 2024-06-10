import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Definition of a static type variable
    static Connection con;

    // Code to create our method that will make the connection between the database and the project
    public static Connection createDBConnection () {

        // All the code being wrapped in a try-catch block in order to offer us exceptions in case of their appearance.
        try {

            // The code required to connect to the Driver to access the database connections
            Class.forName("com.mysql.cj.jdbc.Driver");

            // The URL of our database
            String url = "jdbc:mysql://localhost:3306/employeedb";

            // Code to access the name and password in our database
            String username = "root";
            String password = "Management";

            // Code to connect our variable to the database driver log data
            con = DriverManager.getConnection(url,username,password);

        } catch (Exception ex) {

            ex.printStackTrace();
        }
        // The code for returning the result
        return con;
    }
}
