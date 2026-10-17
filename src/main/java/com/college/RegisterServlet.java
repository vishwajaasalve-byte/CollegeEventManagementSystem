package com.college;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("studentName");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String event = request.getParameter("eventName");

        if (name == null || email == null || department == null || event == null ||
            name.isBlank() || email.isBlank() || department.isBlank() || event.isBlank()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please complete every field.");
            return;
        }

        String sql = "INSERT INTO registrations (student_name, email, department, event_name) VALUES (?, ?, ?, ?)";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name.trim());
            ps.setString(2, email.trim());
            ps.setString(3, department);
            ps.setString(4, event);
            ps.executeUpdate();
            response.sendRedirect(request.getContextPath() + "/?success=1");
        } catch (Exception e) {
            getServletContext().log("Registration could not be saved", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                "Could not save registration. Check that MySQL is running and DB.java has the correct password.");
        }
    }
}
