package web;

import bean.employees;
import bean.department;
import dao.dao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "DisplayDepartments", value = "/DisplayDepartments")
public class DisplayDepartments extends HttpServlet {

    private dao empDao = new dao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");
        out.println("<h1>Question 2</h1>");
        try {
            ResultSet rs = empDao.Departments();
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>Department Name</th><th>No. employees</th><tr>");
            while (rs.next()) {
                String departmentName = rs.getString("name");
                String employees = String.valueOf(rs.getLong("NoOfEmp"));
                out.println("<tr><td>" + departmentName + "</td><td>" + employees + "</td>");
            }
            out.println("</table>");
            out.println("</html></body>");
        } catch (Exception e) {
            out.println("error");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}
