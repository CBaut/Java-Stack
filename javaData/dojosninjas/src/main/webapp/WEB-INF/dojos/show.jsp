<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!-- CSS only -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
      crossorigin="anonymous"
    />
    <link href="/css/style.css" rel="stylesheet" />
    <title><c:out value="${dojo.name}" /></title>
  </head>
  <body>
    <h1><c:out value="${dojo.name}" /> Location Ninjas</h1>
    <div class="navlinks">
      <a href="/dojos/new">New Dojo</a>
      <a href="/ninjas/new">New Ninja</a>
    </div>
    <table
      class="table table-striped table-bordered table-hover table-condensed table-dark"
    >
      <thead>
        <tr>
          <th id="firstName">First Name</th>
          <th id="lastName">Last Name</th>
          <th id="age">Age</th>
        </tr>
      </thead>
      <c:forEach items="${dojo.ninjas}" var="ninja">
        <tr>
          <td>
            <p><c:out value="${ninja.firstName}" /></p>
          </td>
          <td>
            <p><c:out value="${ninja.lastName}" /></p>
          </td>
          <td>
            <p><c:out value="${ninja.age}" /></p>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
