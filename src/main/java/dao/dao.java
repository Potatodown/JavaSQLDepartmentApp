package dao;

import dao.dbUtil;
import java.sql.*;
import java.sql.ResultSet;

public class dao {

    public ResultSet Employees() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = dbUtil.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select first_name, last_name, salary, salary*1.15 AS PF from employees");
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet Departments() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = dbUtil.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select departments.department_name as name, COUNT(employees.employee_id) AS NoOfEmp from departments JOIN employees ON departments.department_id = employees.department_id Group By department_name");
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
