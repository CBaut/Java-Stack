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
    <title>Welcome</title>
  </head>
  <body>
    <h1>Welcome</h1>
    <div class="navlinks">
      <a href="/persons/new">Create New Person</a>
      <a href="/licenses/new">Create New License</a>
    </div>

    <table
      class="table table-striped table-bordered table-hover table-condensed table-dark"
    >
      <thead>
        <tr>
          <th id="firstName">First Name</th>
          <th id="lastName">Last Name</th>
          <th id="license">License #</th>
          <th id="state">State</th>
          <th id="expirationDate">Expiration Date</th>
        </tr>
      </thead>
      <c:forEach items="${persons}" var="person">
        <tr>
          <td>
            <p><c:out value="${person.firstName}" /></p>
          </td>
          <td>
            <p><c:out value="${person.lastName}" /></p>
          </td>
          <td>
            <p><c:out value="${person.license.number}" /></p>
          </td>
          <td>
            <p><c:out value="${person.license.state}" /></p>
          </td>
          <td>
            <p><c:out value="${person.license.expirationDate}" /></p>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
