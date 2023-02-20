package context;

import java.sql.Connection;
import java.sql.DriverManager;

import DAO.LocationDAO;

public class DBContext {
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    private final String serverName = "LENOVO-ARH0528\\MSSQLSERVER01";
    private final String dbName = "FGO";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa";
    private final String password = "admin";

    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().getConnection());

        } catch (Exception e) {
        }
        LocationDAO dao = new LocationDAO();
        double lat = 15.97999;
        double lng = 108.2589953;
        // dao.saveLocation("test", lat, lng);
        try {
            System.out.print(dao.checkExistedAcc("test"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
