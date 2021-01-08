<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
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
    <title>Events</title>
  </head>
  <body>
    <h1>Welcome to Events!</h1>
    <div class="row">
      <div class="col-md-6">
        <h1>Register!</h1>
        <p><form:errors path="user.*" /></p>
        <form:form
          method="POST"
          action="/registration"
          modelAttribute="user"
          class="form-inline"
        >
          <div class="form-group">
            <p>
              <form:label path="firstName">First Name:</form:label>
              <form:input
                type="firstName"
                path="firstName"
                class="form-control"
              />
            </p>
            <p>
              <form:label path="lastName">Email:</form:label>
              <form:input
                type="lastName"
                path="lastName"
                class="form-control"
              />
            </p>
            <p>
              <form:label path="email">Email:</form:label>
              <form:input type="email" path="email" class="form-control" />
            </p>
            <p>
              <form:label path="location">Location:</form:label>
              <form:input
                type="location"
                path="location"
                class="form-control"
              />
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
      </div>
      <div class="col-md-6">
        <h1>Login</h1>
        <p><c:out value="${error}" /></p>
        <form:form
          method="post"
          action="/login"
          modelAttribute="userLogin"
          class="form-inline"
        >
          <div class="form-group">
            <p>
              <form:label path="loginEmail">Email</form:label>
              <form:input type="email" path="loginEmail" class="form-control" />
            </p>
            <p>
              <form:label path="loginPassword">Password</form:label>
              <form:input
                type="password"
                path="loginPassword"
                id="loginPassword"
                name="loginPassword"
                class="form-control"
              />
            </p>
            <input
              type="submit"
              value="Login!"
              class="btn btn-block btn-outline-primary"
            />
          </div>
        </form:form>
      </div>
    </div>
  </body>
</html>
