package JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            String serverName = "DESKTOP-OP58DKI\\LEDAT";
            String login = "sa";
            String password = "200326";
            String databaseName = "universityms";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + serverName + ":1433" + ";databaseName=" + databaseName
                    + ";encrypt=true;trustServerCertificate=true";

            connection = DriverManager.getConnection(url, login, password);

            System.out.println("Kết nối thành công với database: " + databaseName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
