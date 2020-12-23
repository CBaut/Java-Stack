<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>The Code</title>
  </head>
  <body>
    <h1>Hello, Do you know the Code?</h1>
    <c:out class="output" value="${error}" />
    <form action="/form" method="POST">
      <input type="text" name="code" />
    </form>
  </body>
</html>
