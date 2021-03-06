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
    <title>New Song</title>
  </head>
  <body>
    <div class="row navlinks">
      <a href="/dashboard">Dashboard</a>
    </div>
    <h1>Enter New Song</h1>

    <form:form
      action="/songs"
      method="post"
      modelAttribute="song"
      class="form-inline col-md-6"
    >
      <div class="form-group">
        <p>
          <form:label path="title">Title</form:label>
          <form:errors path="title" />
          <form:input path="title" class="form-control" />
        </p>
        <p>
          <form:label path="artist">Artist</form:label>
          <form:errors path="artist" />
          <form:input path="artist" class="form-control" />
        </p>
        <p>
          <form:label path="rating">Rating (1-10)</form:label>
          <form:errors path="rating" />
          <form:input path="rating" class="form-control" />
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
