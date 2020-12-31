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
    <title>Dojos and Ninjas</title>
  </head>
  <body>
    <h1>Welcome to the Dashboard</h1>
    <div class="navlinks">
      <a href="/dojos/new">New Dojo</a>
      <a href="/ninjas/new">New Ninja</a>
    </div>
    <c:forEach items="${dojos}" var="dojo">
      <a href="/dojos/${dojo.id}"
        ><p class="lead"><c:out value="${dojo.name}" /></p
      ></a>
      <ul>
        <c:forEach items="${dojo.ninjas}" var="ninja">
          <li>
            <p>
              <c:out value="${ninja.firstName}" />
              <c:out value="${ninja.lastName}" />
            </p>
          </li>
        </c:forEach>
      </ul>
    </c:forEach>
  </body>
</html>
