<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>Document</title>
  </head>
  <body>
    <p>
      You have visited <a href="/">http://your_server</a>
      <c:out value="${count}" /> times!
    </p>
    <p><a href="/">Test another visit?</a></p>
    <p><a href="/count2">Count by 2</a></p>
    <p><a href="/reset">Reset</a></p>
  </body>
</html>
