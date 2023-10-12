package dao;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class dbUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/hr";
    public static final String USER = "root"; // ues your MySQL ROOT
    public static final String PASSWORD = "Windows1"; // ues your MySQL PASSWORD
    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    /**
     * Establish Connection to MySQL Datasource
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(URL);
        mysqlDataSource.setUser(USER);
        mysqlDataSource.setPassword(PASSWORD);
        Class.forName(DRIVER_CLASS);
        return mysqlDataSource.getConnection();
    }

    /**
     * print SQL Exception
     *
     * @param ex
     */
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}