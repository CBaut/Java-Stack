<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ page isErrorPage="true" %>
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
    <title><c:out value="${product.name}" /></title>
  </head>
  <body>
    <div class="navlinks">
      <a href="/categories/new">New Category</a>
      <a href="/products/new">New Product</a>
      <a href="/">Back to Dashboard</a>
    </div>
    <h1><c:out value="${product.name}" /></h1>

    <div class="row">
      <div class="col-md-6">
        <h3>Categories:</h3>
        <ul>
          <c:forEach items="${product.categories}" var="category">
            <li>
              <a href="/categories/${category.id}"
                ><p class="lead">
                  <c:out value="${category.name}" /></p
              ></a>
            </li>
          </c:forEach>
        </ul>
      </div>
      <div class="col-md-6">
        <form
          action="/products/${product.id}/category/add"
          method="post"
          class="form-inline col-md-6"
        >
          <div class="form-group">
            <h5>Add Category:</h5>
            <p>
              <form:errors path="categories" />
              <select name="category" class="form-control">
                <c:forEach items="${categories}" var="category">
                  <option value="${category.id}">
                    <c:out value="${category.name}" />
                  </option>
                </c:forEach>
              </select>
            </p>
            <input
              type="submit"
              value="Submit"
              class="btn-outline-primary btn-block"
            />
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
