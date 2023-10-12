package web;

import bean.employees;
import dao.dao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "DisplayName", value = "/DisplayNames")
public class DisplayNames extends HttpServlet{
    private dao empDao = new dao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            ResultSet rs = empDao.Employees();
            request.setAttribute("rs", rs);
            request.getRequestDispatcher("question1.jsp").forward(request, response);

            response.setContentType("text/html");
            out.println("<html><body>");
            out.println("<h1>Question 1</h1>");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>first name</th><th>last name</th><th>salary</th><th>PF</th><tr>");
            while (rs.next()) {
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                Double salary = rs.getDouble("salary");
                Double pf = rs.getDouble("PF");
                out.println("<tr><td>" + first + "</td><td>" + last + "</td><td>" + salary + "</td><td>" + pf + "</td>");
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
