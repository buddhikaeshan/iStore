package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

    String jdbcUrl="jdbc:mysql://localhost:3306/istore";
    String username = "root";
    String password = "";

    public Connection getCon() throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
        return conn;   
    }
}
