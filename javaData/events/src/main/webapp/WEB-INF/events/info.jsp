<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <!-- CSS only -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
      crossorigin="anonymous"
    />
    <link href="/css/style.css" rel="stylesheet" />
    <title>Events</title>
  </head>
  <body>
    <div class="navlinks">
      <a href="/events">Back To Dashboard...</a>
      <a href="/logout">Logout</a>
    </div>
    <div class="row">
      <div class="col-md-6">
        <h1><c:out value="${event.name}" /></h1>
        <p class="lead">Host: <c:out value="${event.host.firstName}" /> <c:out value="${event.host.lastName}" /></p>
        <p class="lead">Date: <c:out value="${event.getDateString()}" /></p>
        <p class="lead">Location: <c:out value="${event.location}" />, <c:out value="${event.state}" /></p>
        <p class="lead">People who are attending this event: <c:out value="${event.users.size()}" /></p>
        <table class="table table-striped table-bordered table-hover table-condensed table-dark">
        <thead>
        <th id="name">Name</th>
        <th id="location">Location</th>
        </thead>
        <c:forEach items="${event.users}" var="user">
        <tr>
        <td><c:out value="${user.firstName}" /> <c:out value="${user.lastName}" /></td>
        <td><c:out value="${user.location}" /></td>
        </tr>
        </c:forEach>
        </table>
      </div>
      <div class="col-md-6">
        <h3>Message Wall</h3>
        <div class="messages">
          <c:forEach items="${event.comments}" var="comment">
            <p>
              <c:out value="${comment.user.firstName}" /> says: <c:out value="${comment.body}" />
            </p>
          </c:forEach>
        </div>
        <form:form
          method="POST"
          action="/events/${event.id}/addcomment"
          modelAttribute="comments"
          class="form-inline"
        >
          <div class="form-group">
            <p>
              <form:label path="body">Add Comment:</form:label>
              <form:errors path="body" class="errors" />
              <form:input type="text" path="body" class="form-control" />
              
            <form:hidden path="event" value="${event.id}" />
            <form:hidden path="user" value="${user.id}" />
            <input type="submit"
              value="Create"
              class="btn btn-outline-primary btn-block create"
            />
          </div>
        </form:form>
      </div>
    </div>
  </body>
</html>
