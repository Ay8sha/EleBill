package pk1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    Connection connection;
    Statement statement;
    database(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billin",
                    "root", "shooky123");
            statement= connection.createStatement();
        } catch (Exception e) {
           e.printStackTrace();
        }

    }
}
