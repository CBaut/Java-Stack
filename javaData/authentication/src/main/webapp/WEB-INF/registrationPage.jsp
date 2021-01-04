<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
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
    <title>Registration Page</title>
  </head>
  <body>
    <h1>Register!</h1>

    <p><form:errors path="user.*" /></p>

    <form:form
      method="POST"
      action="/registration"
      modelAttribute="user"
      class="form-inline col-md-6"
    >
      <div class="form-group">
        <p>
          <form:label path="email">Email:</form:label>
          <form:input type="email" path="email" class="form-control" />
        </p>
        <p>
          <form:label path="password">Password:</form:label>
          <form:password path="password" class="form-control" />
        </p>
        <p>
          <form:label path="passwordConfirmation"
            >Password Confirmation:</form:label
          >
          <form:password path="passwordConfirmation" class="form-control" />
        </p>
        <input
          type="submit"
          value="Register!"
          class="btn btn-outline-primary btn-block"
        />
      </div>
    </form:form>
    <div class="navlinks">
      <a href="/login">Already member? Sign in here!</a>
    </div>
  </body>
</html>
