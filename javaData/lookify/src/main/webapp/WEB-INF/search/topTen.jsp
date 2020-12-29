<!DOCTYPE html>
<html lang="en">
  <head>
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
    <title>Top 10</title>
  </head>
  <body>
    <div class="row navlinks flex">
      <h1>Top Ten Songs!</h1>
      <a href="/dashboard">Dashboard</a>
    </div>

    <table
      class="table table-striped table-bordered table-hover table-condensed table-dark"
    >
      <thead>
        <tr>
          <th id="songRating">Rating (1-10)</th>
          <th id="songTitle">Title</th>
          <th id="songArtist">Artist</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${songs}" var="song">
          <tr>
            <td>
              <c:out value="${song.rating}" />
            </td>
            <td>
              <a href="/songs/${song.id}"><c:out value="${song.title}" /></a>
            </td>
            <td>
              <c:out value="${song.artist}" />
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>
