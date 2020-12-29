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
    <title>Lookify Dashboard</title>
  </head>
  <body><h1>Welcome to Lookify</h1>
    <div class="navlinks">
        <a href="/songs/new">Add New</a>
        <a href="/search/topTen">Top Songs</a>
        <form action="/search" method="post">
      <input type="text" name="searchString" placeholder="Artist Name" />
      <input type="submit" value="Search Artists" class="btn-outline-primary"/>
    </form>
    </div>
    <table
      class="table table-striped table-bordered table-hover table-condensed table-dark"
    >
      <thead>
        <tr>
          <th id="songTitle">Title</th>
          <th id="songRating">Rating (1-10)</th>
          <th id="actions">Actions</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${songs}" var="song">
          <tr>
            <td>
              <a href="/songs/${song.id}"
                ><c:out value="${song.title}"
              /></a>
            </td>
            <td>
              <c:out value="${song.rating}" />
            </td>

            <td class="actions">
              <form:form action="/songs/${song.id}" method="POST">
		                            		<input type="hidden" name="_method" value="delete">
		                            		<input class="btn btn-outline-danger" type="submit" value="Delete" />
		                            	</form:form>
		                            	<a href="/songs/${song.id}/edit" class="btn btn-outline-warning" role="button">Edit</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    </body>
</html>
