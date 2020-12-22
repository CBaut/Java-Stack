<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>Date</title>

    <link rel="stylesheet" type="text/css" href="css/date.css" />
  </head>
  <body>
    <h1><c:out value="${date}" /></h1>
    <a href="/">Go Back...</a>
    <script type="text/javascript" src="js/date.js"></script>
  </body>
</html>
