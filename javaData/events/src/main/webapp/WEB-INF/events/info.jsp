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
    <h1><c:out value="${event.name}" /></h1>
    <div class="row">
      <div clas="col-md-6">
        <p class="lead">Host: <c:out value="${event.host.firstName}" /> <c:out value="${event.host.lastName}" /></p>
        <table>
          <thead>
            <th id="name">Name</th>
            <th id="location">Location</th>
          </thead>
          <tr>
            <td>{Place Holder}</td>
            <td>{Place Holder}</td>
          </tr>
        </table>
      </div>
      <div class="col-md-6">
        <h3>Message Wall</h3>
        <div class="messages">{placeholder for loopy}</div>
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
            <input
              type="submit"
              value="Create"
              class="btn btn-outline-primary btn-block"
            />
          </div>
        </form:form>
      </div>
    </div>
  </body>
</html>
