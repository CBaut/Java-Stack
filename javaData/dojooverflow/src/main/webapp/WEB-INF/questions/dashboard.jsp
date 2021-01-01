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
    <title>DojoOverflow</title>
  </head>
  <body>
    <h1>Questions Dashboard</h1>
    <table
      class="table table-striped table-bordered table-hover table-condensed table-dark"
    >
      <thead>
        <th id="question">Question</th>
        <th id="tags">Tags</th>
      </thead>
      <c:forEach items="${questions}" var="question">
        <tr>
          <td>
            <a href="/questions/${question.id}"
              ><c:out value="${question.question}"
            /></a>
          </td>
          <td>
            <c:out value="${question.tagString()}" />
          </td>
        </tr>
      </c:forEach>
    </table>
    <div class="navlinks">
      <a href="/questions/new">New Question</a>
    </div>
  </body>
</html>
