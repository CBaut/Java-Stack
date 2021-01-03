<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <title>Questions Dashboard</title>
  </head>
  <body>
    <div class="navlinks">
      <a href="/questions">Back to Dashboard</a>
      <a href="/questions/new">New Question</a>
    </div>
    <div class="container">
      <h1>${ question.question }</h1>
      <h3>Tags:</h3>
      <c:forEach items="${ question.tags }" var="tag">
        <button class="btn btn-outline-secondary">${ tag.subject }</button>
      </c:forEach>
      <div class="row">
        <div class="col-md-6">
          <h3>Answers:</h3>
          <ul class="form-group">
            <c:forEach items="${ question.answers }" var="answer">
              <li class="form-control">${ answer.answerField }</li>
            </c:forEach>
          </ul>
        </div>
        <div class="col-md-6">
          <h3>Add your answer:</h3>
          <form:form
            action="/answers"
            method="post"
            modelAttribute="answer"
            class="form-inline"
          >
            <div class="form-group">
              <form:errors path="answerField" />
              <form:textarea
                class="form-control"
                path="answerField"
                name="answerField"
              ></form:textarea>
              <form:hidden path="question" value="${question.id}" />
            </div>
            <button class="btn btn-primary btn-block">Answer it!</button>
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>
