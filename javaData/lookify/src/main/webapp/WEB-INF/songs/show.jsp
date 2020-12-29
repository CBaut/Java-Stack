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
    <title>Song Info</title>
  </head>
  <body>
    <div class="row navlinks">
        <a href="/dashboard">Dashboard</a>
      </div>
    <div class="container"><h3>Title: <c:out value="${song.title}" /></h3>
    <h3>Artist: <c:out value="${song.artist}" /></h3>
    <h3>Rating (1-10): <c:out value="${song.rating}" /></h3></div>
    <form:form action="/songs/${song.id}" method="POST">
		                            		<input type="hidden" name="_method" value="delete">
		                            		<input class="btn btn-outline-danger" type="submit" value="Delete" />
		                            	</form:form>
  </body>
</html>
