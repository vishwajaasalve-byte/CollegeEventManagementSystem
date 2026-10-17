package com.college;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Registration> registrations = new ArrayList<>();
        String sql = "SELECT id, student_name, email, department, event_name, registered_at FROM registrations ORDER BY registered_at DESC";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Registration r = new Registration();
                r.setId(rs.getInt("id"));
                r.setStudentName(rs.getString("student_name"));
                r.setEmail(rs.getString("email"));
                r.setDepartment(rs.getString("department"));
                r.setEventName(rs.getString("event_name"));
                r.setRegisteredAt(rs.getString("registered_at"));
                registrations.add(r);
            }
        } catch (Exception e) {
            getServletContext().log("Could not load registrations", e);
            request.setAttribute("errorMessage", "Could not load records. Check that MySQL is running and DB.java has the correct password.");
        }
        request.setAttribute("registrations", registrations);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }
}