<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>Dojo Survey Results</title>
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body>
    <h1>Thanks for filling out the Survey!</h1>
    <div class="container">
      <table>
        <tr>
          <td>
            <p>Your Name:</p>
          </td>
          <td>
            <p><c:out value="${name}" /></p>
          </td>
        </tr>
        <tr>
          <td>
            <p>Location:</p>
          </td>
          <td>
            <p><c:out value="${location}" /></p>
          </td>
        </tr>
        <tr>
          <td><p>Favorite Language:</p></td>
          <td>
            <p><c:out value="${language}" /></p>
          </td>
        </tr>
        <tr>
          <td><p>Comment:</p></td>
          <td>
            <p><c:out value="${comment}" /></p>
          </td>
        </tr>
      </table>
    </div>
    <p><a href="/">Go Back...</a></p>
  </body>
</html>
