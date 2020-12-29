<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ page isErrorPage="true" %>
    <meta charset="UTF-8" />
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <!-- CSS only -->
        <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
        crossorigin="anonymous"
      />
      <link href="/css/style.css" rel="stylesheet"/>
  </head>
  <body>
    <h1>Edit Language</h1>
    <div class="actions">
        <form:form action="/languages/${language.id}" method="POST">
                                      <input type="hidden" name="_method" value="delete">
                                      <input class="btn btn-outline-danger" type="submit" value="Delete" />
                                  </form:form>
                                  <a href="/languages/" class="btn btn-outline-secondary" role="button">Dashboard</a>
                                </div>
    <form:form action="/languages/${language.id}" method="post" modelAttribute="language" class="form-inline col-md-6">
        <div class="form-group"><input type="hidden" name="_method" value="put">
        <p>
        <form:label path="name">Namee</form:label>
        <form:errors path="name"/>
        <form:input path="name" class="form-control"/>
        </p>
        <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input path="creator" class="form-control"/>
        </p>
        <p>
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>
        <form:input path="version" class="form-control"/>
        </p>
        
        <input type="submit" value="Submit" class="btn-outline-primary"/></div>
    </form:form>
  </body>
</html>
