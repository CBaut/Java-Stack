<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <!-- CSS only -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
      crossorigin="anonymous"
    />
    <link href="/css/style.css" rel="stylesheet" />
    <title>Login Page</title>
  </head>
  <body>
    <h1>Login</h1>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/login" class="form-inline col-md-6">
      <p>
        <label for="email">Email</label>
        <input type="text" id="email" name="email" class="form-control" />
      </p>
      <p>
        <label for="password">Password</label>
        <input
          type="password"
          id="password"
          name="password"
          class="form-control"
        />
      </p>
      <input
        type="submit"
        value="Login!"
        class="btn btn-block btn-outline-primary"
      />
    </form>
    <div class="navlinks">
      <a href="/registration">Not a member? Register here!</a>
    </div>
  </body>
</html>
