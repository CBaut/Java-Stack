<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>Document</title>
  </head>
  <body>
    <h1>Welcome User!</h1>
    <c:out value="${count}" />
  </body>
</html>
