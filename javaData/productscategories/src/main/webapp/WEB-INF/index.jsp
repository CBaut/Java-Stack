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
    <title>Products and Categories</title>
  </head>
  <body>
    <div class="navlinks">
      <a href="/products/new">New Product</a>
      <a href="/categories/new">New Category</a>
    </div>
    <h1>Welcome to the Dashboard</h1>
    <div class="row">
      <div class="col-md-6">
        <c:forEach items="${products}" var="product">
          <a href="/products/${product.id}"
            ><p class="lead"><c:out value="${product.name}" /></p
          ></a>
        </c:forEach>
      </div>
      <div class="col-md-6">
        <c:forEach items="${categories}" var="category">
          <a href="/categories/${category.id}"
            ><p class="lead">
              <c:out value="${category.name}" /></p
          ></a>
        </c:forEach>
      </div>
    </div>
  </body>
</html>
