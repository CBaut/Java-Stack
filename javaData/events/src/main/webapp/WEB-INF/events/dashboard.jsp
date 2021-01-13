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
      <h1>Welcome, <c:out value="${user.firstName}" />!</h1>
      <a href="/logout">Logout</a>
    </div>
    <h5>Here are some of the events in your state:</h5>
    <table
      class="table table-striped table-bordered table-hover table-condensed table-dark"
    >
      <thead>
        <th id="name">Name</th>
        <th id="date">Date</th>
        <th id="location">Location</th>
        <th id="host">Host</th>
        <th id="status">Action/Status</th>
      </thead>
      <c:forEach items="${eventsInState}" var="event">
        <tr>
          <td>
            <a href="/events/${event.id}"><c:out value="${event.name}" /></a>
          </td>
          <td>
            <c:out value="${event.date}" />
          </td>
          <td>
            <c:out value="${event.location}" />
          </td>
          <td>
            <c:out value="${event.host.firstName}" />
            <c:out value="${event.host.lastName}" />
          </td>
          <c:choose>
            <c:when test="${ event.host.id == user.id }">
              <td>
                <a href="/events/${event.id}/edit" class="btn btn-outline-success">EDIT</a> |
                <form:form action="/events/${event.id}/delete" method="post">
		                            		<input type="hidden" name="_method" value="delete">
		                            		<input class="btn btn-outline-danger" type="submit" value="Delete" />
		                            	</form:form>
              </td>
            </c:when>
            <c:when test="${event.users.contains(user) }">
              <td>Joining<a href="/events/${event.id}/unjoin"> CANCEL</a></td>
            </c:when>
            <c:otherwise>
              <td><a href="/events/${event.id}/join">Join</a></td>
            </c:otherwise>
          </c:choose>
        </tr>
      </c:forEach>
    </table>
    <h5>Here are some events in other state:</h5>
    <table
      class="table table-striped table-bordered table-hover table-condensed table-dark"
    >
      <thead>
        <th id="name">Name</th>
        <th id="date">Date</th>
        <th id="location">Location</th>
        <th id="state">State</th>
        <th id="host">Host</th>
        <th id="status">Action</th>
      </thead>
      <c:forEach items="${eventsNotInState}" var="event">
        <tr>
          <td>
            <a href="/events/${event.id}"><c:out value="${event.name}" /></a>
          </td>
          <td>
            <c:out value="${event.date}" />
          </td>
          <td>
            <c:out value="${event.location}" />
          </td>
          <td>
            <c:out value="${event.state}" />
          </td>
          <td>
            <c:out value="${event.host.firstName}" />
            <c:out value="${event.host.lastName}" />
          </td>
          <c:choose>
            <c:when test="${ event.host.id == user.id }">
              <td>
                <a href="/events/${event.id}/edit" class="btn btn-outline-success">EDIT</a> |
                <form:form action="/events/${event.id}/delete" method="post">
		                            		<input type="hidden" name="_method" value="delete">
		                            		<input class="btn btn-outline-danger" type="submit" value="Delete" />
		                            	</form:form>
              </td>
            </c:when>
            <c:when test="${event.users.contains(user) }">
              <td>Joining<a href="/events/${event.id}/unjoin"> CANCEL</a></td>
            </c:when>
            <c:otherwise>
              <td><a href="/events/${event.id}/join">Join</a></td>
            </c:otherwise>

          </c:choose>
        </tr>
      </c:forEach>
    </table>
    <div class="col-md-6">
      <h3>Create an Event</h3>
      <form:form
        method="POST"
        action="/events"
        modelAttribute="newEvent"
        class="form-inline"
      >
        <div class="form-group">
          <p>
            <form:label path="name">Name:</form:label>
            <form:errors path="name" class="errors" />
            <form:input type="text" path="name" class="form-control" />
          </p>
          <p>
            <form:label path="date">Date:</form:label>
            <form:errors path="date" class="errors" />
            <form:input
              type="datetime-local"
              path="date"
              class="form-control"
            />
          </p>
          <p>
            <form:label path="location">Location:</form:label>
            <form:errors path="location" class="errors" />
            <form:input type="text" path="location" class="form-control" />
          </p>
          <p>
            <form:label path="state">State</form:label>
            <form:errors path="state" class="errors" />
            <form:select path="state" name="state" class="form-control">
              <c:forEach items="${states}" var="state">
                <form:option value="${state}"
                  ><c:out value="${state}"></c:out
                ></form:option>
              </c:forEach>
            </form:select>
          </p>
          <input
            type="submit"
            value="Create"
            class="btn btn-outline-primary btn-block"
          />
        </div>
      </form:form>
    </div>
  </body>
</html>
