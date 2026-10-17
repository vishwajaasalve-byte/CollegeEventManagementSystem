<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin | CampusConnect</title><link rel="stylesheet" href="${pageContext.request.contextPath}/style.css"></head>
<body>
<nav class="nav"><a class="brand" href="${pageContext.request.contextPath}/"><span class="brand-mark">C</span> CampusConnect</a><div class="nav-actions"><a class="navlink" href="${pageContext.request.contextPath}/">Home</a><a class="nav-cta" href="${pageContext.request.contextPath}/#register">New registration ↗</a></div></nav>
<main class="admin-wrap">
  <p class="eyebrow">ADMIN DASHBOARD</p><h1>Student registrations</h1><p class="muted">These records are loaded from MySQL through a Java Servlet and displayed using JSP.</p>
  <c:if test="${not empty errorMessage}"><p class="form-error"><c:out value="${errorMessage}"/></p></c:if>
  <div class="table-wrap"><table><thead><tr><th>ID</th><th>Student</th><th>Email</th><th>Department</th><th>Event</th><th>Registered at</th></tr></thead>
  <tbody><c:forEach var="r" items="${registrations}"><tr><td><c:out value="${r.id}"/></td><td><c:out value="${r.studentName}"/></td><td><c:out value="${r.email}"/></td><td><c:out value="${r.department}"/></td><td><c:out value="${r.eventName}"/></td><td><c:out value="${r.registeredAt}"/></td></tr></c:forEach>
  <c:if test="${empty registrations}"><tr><td colspan="6">No registrations found yet. Submit the registration form first.</td></tr></c:if></tbody></table></div>
  <p class="muted">Refresh this page to load the latest records.</p>
</main>
<footer><a class="brand" href="${pageContext.request.contextPath}/"><span class="brand-mark">C</span> CampusConnect</a><span>Admin view · Java + JSP + MySQL</span><a href="${pageContext.request.contextPath}/">Back to home ↗</a></footer>
</body></html>