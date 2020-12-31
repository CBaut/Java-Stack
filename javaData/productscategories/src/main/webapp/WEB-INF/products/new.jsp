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
    <title>New Product</title>
  </head>
  <body>
    <div class="navlinks">
      <a href="/">Back to Dashboard</a>
      <a href="/categories/new">New Category</a>
    </div>
    <h1>Add New Product</h1>

    <form:form
      action="/products"
      method="post"
      modelAttribute="product"
      class="form-inline col-md-6"
    >
      <div class="form-group">
        <p>
          <form:label path="name">Name</form:label>
          <form:errors path="name" />
          <form:input path="name" class="form-control" />
        </p>
        <p>
          <form:label path="description">Description</form:label>
          <form:errors path="description" />
          <form:input path="description" class="form-control" />
        </p>
        <p>
          <form:label path="price">Price</form:label>
          <form:errors path="price" />
          <form:input path="price" class="form-control" />
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
