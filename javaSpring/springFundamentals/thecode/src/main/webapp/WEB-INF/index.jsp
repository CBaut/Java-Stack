<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>The Code</title>
    <link href="css/style.css" rel="stylesheet" />
  </head>
  <body>
    <h1>Hello, Do you know the Code?</h1>
    <p class="error"><c:out value="${error}" /></p>
    <form action="/form" method="POST">
      <input type="text" name="code" placeholder="Try Code..." />
      <button type="submit">Try Code</button>
    </form>
  </body>
</html>
