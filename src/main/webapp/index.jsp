<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>CampusConnect | College Events</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
  <nav class="nav">
    <a class="brand" href="${pageContext.request.contextPath}/"><span class="brand-mark">C</span> CampusConnect</a>
    <div class="nav-actions"><a class="navlink" href="#events">Events</a><a class="navlink" href="#register">Register</a><a class="nav-cta" href="${pageContext.request.contextPath}/admin">Admin records ↗</a></div>
  </nav>
  <header class="hero">
    <div class="hero-copy">
      <p class="eyebrow"><span class="dot"></span> YOUR CAMPUS. YOUR MOMENT.</p>
      <h1>Make college life<br><span>unforgettable.</span></h1>
      <p class="hero-text">Discover events, meet your people, and turn your ideas into experiences. Your next campus memory starts here.</p>
      <div class="hero-actions"><a class="button button-light" href="#events">Explore events <span>↘</span></a><a class="text-link" href="#register">Register in a minute →</a></div>
      <div class="hero-stats"><div><strong>03</strong><span>Featured events</span></div><div><strong>01</strong><span>Campus community</span></div><div><strong>∞</strong><span>Possibilities</span></div></div>
    </div>
    <div class="hero-art" aria-label="Decorative event illustration">
      <div class="orb orb-one"></div><div class="orb orb-two"></div>
      <div class="ticket"><div class="ticket-top"><span>CAMPUSCONNECT / LIVE</span><span>2026</span></div><div class="ticket-icon">✦</div><p class="ticket-small">YOUR INVITATION TO</p><h2>Something<br>AMAZING.</h2><div class="ticket-bottom"><span>IDEAS · PEOPLE · ENERGY</span><span>✳</span></div></div>
      <div class="float-tag tag-top">✦ Find your crowd</div><div class="float-tag tag-bottom">↗ Make it happen</div>
    </div>
  </header>
  <main>
    <section id="events" class="section">
      <div class="section-head"><div><p class="eyebrow">WHAT'S HAPPENING</p><h2>Find your next <span>thing.</span></h2></div><p class="muted">A little curiosity can lead to a big experience.</p></div>
      <div class="event-grid">
        <article class="event-card card-purple"><div class="event-top"><span class="event-icon">⌘</span><span class="pill">TECH</span></div><p class="event-date">01 / INNOVATION</p><h3>CodeSprint</h3><p>Build, brainstorm, and bring your boldest ideas to life in a friendly coding challenge.</p><a href="#register" class="event-link" data-event="CodeSprint">Join this event ↗</a></article>
        <article class="event-card card-orange"><div class="event-top"><span class="event-icon">♫</span><span class="pill">CULTURE</span></div><p class="event-date">02 / EXPRESSION</p><h3>Rhythm &amp; Roots</h3><p>Celebrate music, dance, and the creative energy that makes our campus unique.</p><a href="#register" class="event-link" data-event="Rhythm & Roots">Join this event ↗</a></article>
        <article class="event-card card-green"><div class="event-top"><span class="event-icon">✳</span><span class="pill">COMMUNITY</span></div><p class="event-date">03 / IMPACT</p><h3>Campus Carnival</h3><p>Meet new friends, explore student clubs, and make the most of campus life.</p><a href="#register" class="event-link" data-event="Campus Carnival">Join this event ↗</a></article>
      </div>
    </section>
    <section id="register" class="register-section">
      <div class="register-intro"><p class="eyebrow">SAVE YOUR SPOT</p><h2>You're one step<br>away from <span>in.</span></h2><p>Fill in your details and join the experience. Your registration will be saved in our MySQL database.</p><div class="mini-note"><span>✓</span> Quick and simple registration</div><div class="mini-note"><span>✓</span> Your entry is recorded in MySQL</div></div>
      <form class="register-form" action="${pageContext.request.contextPath}/register" method="post">
        <div class="form-heading"><h3>Event registration</h3><p>All fields are required.</p></div>
        <label for="studentName">Full name</label><input id="studentName" name="studentName" placeholder="e.g. Aanya Sharma" required maxlength="100">
        <label for="email">College email</label><input id="email" name="email" type="email" placeholder="you@example.com" required maxlength="150">
        <label for="department">Department</label><select id="department" name="department" required><option value="">Choose your department</option><option>Computer Engineering</option><option>Information Technology</option><option>AI &amp; Data Science</option><option>Electronics Engineering</option><option>Mechanical Engineering</option><option>Other</option></select>
        <label for="eventName">Choose an event</label><select id="eventName" name="eventName" required><option value="">Select an event</option><option>CodeSprint</option><option>Rhythm &amp; Roots</option><option>Campus Carnival</option></select>
        <button class="button button-dark" type="submit">Confirm registration <span>→</span></button>
        <p class="form-foot">By registering, you confirm your details are correct.</p>
        <c:if test="${param.success == '1'}"><p class="success">Registration saved successfully! Open Admin records to view it.</p></c:if>
        <c:if test="${not empty requestScope.errorMessage}"><p class="form-error">${requestScope.errorMessage}</p></c:if>
      </form>
    </section>
  </main>
  <footer><a class="brand" href="${pageContext.request.contextPath}/"><span class="brand-mark">C</span> CampusConnect</a><span>Made for campus life · Java + JSP + MySQL</span><a href="${pageContext.request.contextPath}/admin">View registrations ↗</a></footer>
  <script src="${pageContext.request.contextPath}/script.js"></script>
</body>
</html>