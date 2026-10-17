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

        if (blank(name) || blank(email) || blank(department) || blank(event)) {
            request.setAttribute("errorMessage", "Please complete every field and try again.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        String sql = "INSERT INTO registrations (student_name, email, department, event_name) VALUES (?, ?, ?, ?)";
        try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name.trim());
            ps.setString(2, email.trim());
            ps.setString(3, department.trim());
            ps.setString(4, event.trim());
            ps.executeUpdate();
            response.sendRedirect(request.getContextPath() + "/?success=1#register");
        } catch (Exception e) {
            getServletContext().log("Registration could not be saved", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            request.setAttribute("errorMessage", "Registration could not be saved. Check MySQL and DB.java settings.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    private boolean blank(String value) {
        return value == null || value.isBlank();
    }
}