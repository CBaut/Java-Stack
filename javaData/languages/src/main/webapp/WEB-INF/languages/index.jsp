<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <!-- CSS only -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
      crossorigin="anonymous"
    />
    <link href="/css/style.css" rel="stylesheet"/>
    <title>Languages Dashboard</title>
  </head>
  <body>
    <h1>Welcome to the Language Dashboard</h1>
    <table
      class="table table-striped table-bordered table-hover table-condensed table-dark"
    >
      <thead>
        <tr>
          <th id="languageName">Name</th>
          <th id="languageCreator">Creator</th>
          <th id="languageVersion">Version</th>
          <th id="actions">Actions</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${languages}" var="language">
          <tr>
            <td>
              <a href="/languages/${language.id}"
                ><c:out value="${language.name}"
              /></a>
            </td>
            <td>
              <c:out value="${language.creator}" />
            </td>
            <td>
              <c:out value="${language.version}" />
            </td>
            <td class="actions">
              <form:form action="/languages/${language.id}" method="POST">
		                            		<input type="hidden" name="_method" value="delete">
		                            		<input class="btn btn-outline-danger" type="submit" value="Delete" />
		                            	</form:form>
		                            	<a href="/languages/${language.id}/edit" class="btn btn-outline-warning" role="button">Edit</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <form:form action="/languages" method="post" modelAttribute="language" class="form-inline col-md-6">
      <div class="form-group"><p>
      <form:label path="name">Name</form:label>
      <form:errors path="name" />
      <form:input path="name" class="form-control" />
      </p>
      <p>
      <form:label path="creator">Creator</form:label>
      <form:errors path="creator" />
      <form:input path="creator" class="form-control" />
      </p>
      <p>
      <form:label path="version">Version</form:label>
      <form:errors path="version" />
      <form:input path="version" class="form-control" />
      </p>
      
      <input type="submit" value="Submit" class="btn-outline-primary"/></div>
    </form:form>
  </body>
</html>
