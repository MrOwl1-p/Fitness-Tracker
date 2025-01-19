import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conn {
    Connection myConn;
    Statement myStat;
    ResultSet myRs;
    PreparedStatement myPreStat;

    public void setConnection(String user, String password) {
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness_tracker", user, password);
            myStat = myConn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
