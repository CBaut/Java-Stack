<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>
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
      <h1>Welcome, <c:out value="${user.firstName}" />!</h1>
      <a href="/events">Back to Dashboard...</a>
      <a href="/logout">Logout</a>
    </div>
    <div class="col-md-6">
      <h3>Edit Event</h3>
      <form:form
        method="post"
        action="/events/${event.id}/edit"
        modelAttribute="updateEvent"
        class="form-inline"
      >
        <div class="form-group">
            <input type="hidden" name="_method" value="put">
          <p>
            <form:label path="name">Name:</form:label>
            <form:errors path="name" class="errors" />
            <form:input type="text" path="name" value="${event.name}" class="form-control" />
          </p>
          <p>
            <form:label path="date">Date:</form:label>
            <form:errors path="date" class="errors" />
            <form:input
              type="datetime-local"
              path="date" value="${event.getDateString()}"
              class="form-control"
            />
          </p>
          <p>
            <form:label path="location">Location:</form:label>
            <form:errors path="location" class="errors" />
            <form:input type="text" path="location" value="${event.location}" class="form-control" />
          </p>
          <p>
            <form:label path="state">State</form:label>
            <form:errors path="state" class="errors" />
            <form:select path="state" name="state" class="form-control">
                <form:option value="${event.state}"><c:out value="${event.state}" /></form:option>
              <c:forEach items="${states}" var="state">
                <form:option value="${state}"
                  ><c:out value="${state}"></c:out
                ></form:option>
              </c:forEach>
            </form:select>
          </p>
          <input
            type="submit"
            value="Edit"
            class="btn btn-outline-primary btn-block"
          />
        </div>
      </form:form>
    </div>
  </body>
</html>
