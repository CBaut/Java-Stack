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
    <title>New Category</title>
  </head>
  <body>
    <div class="navlinks">
      <a href="/products/new">New Product</a>
      <a href="/">Back to Dashboard</a>
    </div>

    <h1>Add New Category</h1>
    <form:form
      action="/categories"
      method="post"
      modelAttribute="category"
      class="form-inline col-md-6"
    >
      <div class="form-group">
        <p>
          <form:label path="name">Name</form:label>
          <form:errors path="name" />
          <form:input path="name" class="form-control" />
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
