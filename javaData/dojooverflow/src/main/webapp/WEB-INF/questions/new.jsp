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
    <h1>What is your question?</h1>
    <div class="navlinks">
      <a href="/questions">Back to Dashboard</a>
    </div>

    <form:form
      action="/questions/new"
      method="post"
      modelAttribute="newQuestion"
      class="form-inline col-md-6"
    >
      <div class="form-group">
        <p>
          <form:label path="question">Question:</form:label>
          <form:errors path="question" />
          <form:textarea rows="10" cols="30" path="question" class="form-control" />
        </p>
        <p>
          <form:label path="tags">Tags:</form:label>
          <form:errors path="tags" />
          <form:input path="tags" class="form-control" />
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
