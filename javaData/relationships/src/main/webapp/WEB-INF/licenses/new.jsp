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
      <a href="/">Back to Dashboard...</a>
    </div>

    <form:form
      action="/licenses"
      method="post"
      modelAttribute="license"
      class="form-inline col-md-6"
    >
      <div class="form-group">
        <p>
          <form:label path="person">Person</form:label>
          <form:errors path="person" />
          <form:select path="person" name="person" class="form-control">
            <c:forEach items="${persons}" var="person">
              <form:option value="${person}"
                ><c:out value="${person.firstName}" />
                <c:out value="${person.lastName}"
              /></form:option>
            </c:forEach>
          </form:select>
        </p>
        <p>
          <form:label path="state">State</form:label>
          <form:errors path="state" />
          <form:input path="state" class="form-control" />
        </p>
        <p>
          <form:label path="expirationDate">Expiration Date</form:label>
          <form:errors path="expirationDate" />
          <form:input type="date" path="expirationDate" class="form-control" />
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
