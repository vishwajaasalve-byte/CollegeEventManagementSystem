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

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private String esc(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;").replace("<", "&lt;")
                    .replace(">", "&gt;").replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        StringBuilder rows = new StringBuilder();
        String sql = "SELECT id, student_name, email, department, event_name, registered_at FROM registrations ORDER BY registered_at DESC";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                rows.append("<tr><td>").append(rs.getInt("id")).append("</td><td>")
                    .append(esc(rs.getString("student_name"))).append("</td><td>")
                    .append(esc(rs.getString("email"))).append("</td><td>")
                    .append(esc(rs.getString("department"))).append("</td><td>")
                    .append(esc(rs.getString("event_name"))).append("</td><td>")
                    .append(esc(rs.getString("registered_at"))).append("</td></tr>");
            }
        } catch (Exception e) {
            getServletContext().log("Could not load registrations", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                "Could not load registrations. Check MySQL and DB.java settings.");
            return;
        }

        response.getWriter().write("""
            <!doctype html><html lang="en"><head><meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Admin | CampusConnect</title><link rel="stylesheet" href="style.css"></head>
            <body><nav class="nav"><a class="brand" href="./">CampusConnect</a><a class="navlink" href="./">Home</a></nav>
            <main class="admin-wrap"><div class="section-head"><p class="eyebrow">ADMIN DASHBOARD</p>
            <h1>Student registrations</h1><p class="muted">These records are loaded directly from MySQL.</p></div>
            <div class="table-wrap"><table><thead><tr><th>ID</th><th>Student</th><th>Email</th>
            <th>Department</th><th>Event</th><th>Registered at</th></tr></thead><tbody>
            """ + rows + """
            </tbody></table></div><p class="muted">Refresh this page to see the latest registrations.</p>
            </main></body></html>
            """);
    }
}