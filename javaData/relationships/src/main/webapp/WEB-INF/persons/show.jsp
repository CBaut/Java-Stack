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
    <title>
      <c:out value="${person.firstName}" /> <c:out value="${person.lastName}" />
    </title>
  </head>
  <body>
    <h1>
      <c:out value="${person.firstName}" /> <c:out value="${person.lastName}" />
    </h1>
    <div class="navlinks">
      <a href="/">Back to Dashboard...</a>
    </div>
    <table class="table table-striped table-bordered table-hover table-condensed table-dark">
        <tr>
            <td><h5>License Number:</h5></td>
            <td><p><c:out value="${license.number}" /></p></td>
        </tr>
        <tr>
            <td><h5>State:</h5></td>
            <td><p><c:out value="${license.state}" /></p></td>
        </tr>
        <tr>
            <td><h5>Expiration Date:</h5></td>
            <td><p><c:out value="${license.expirationDate}" /></p></td>
        </tr>
    </table>
    </div>
  </body>
</html>
