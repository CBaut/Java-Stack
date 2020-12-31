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
    <title>New Ninja</title>
  </head>
  <body>
    <h1>Add New Ninja</h1>
    <div class="navlinks"><a href="/">Back To Dashboard...</a></div>
    <form:form
      action="/ninjas"
      method="post"
      modelAttribute="ninja"
      class="form-inline col-md-6"
    >
      <div class="form-group">
        <p>
          <form:label path="dojo">Dojo</form:label>
          <form:errors path="dojo" />
          <form:select path="dojo" name="dojo" class="form-control">
            <c:forEach items="${dojos}" var="dojo">
              <form:option value="${dojo}"
                ><c:out value="${dojo.name}" />
              </form:option>
            </c:forEach>
          </form:select>
        </p>
        <p>
          <form:label path="firstName">First Name</form:label>
          <form:errors path="firstName" />
          <form:input path="firstName" class="form-control" />
        </p>
        <p>
          <form:label path="lastName">Last Name</form:label>
          <form:errors path="lastName" />
          <form:input path="lastName" class="form-control" />
        </p>
        <p>
          <form:label path="Age">Age</form:label>
          <form:errors path="Age" />
          <form:input path="Age" class="form-control" />
        </p>
        <input
          type="submit"
          value="Submit"
          class="btn-outline-primary btn-block"
        />
      </div>
    </form:form>
  </body>
</html>
