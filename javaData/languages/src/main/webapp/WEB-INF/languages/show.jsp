<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
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
    <title>Language Info</title>
  </head>
  <body>
    <h1><c:out value="${language.name}" /></h1>
    <a href="/languages/" class="btn btn-outline-secondary" role="button"
      >Dashboard</a
    >
    <p>Creator: <c:out value="${language.creator}" /></p>
    <p>Version: <c:out value="${language.version}" /></p>
    <div class="actions">
      <a
        href="/languages/${language.id}/edit"
        class="btn btn-outline-warning"
        role="button"
        >Edit</a
      >
      <form action="/books/${book.id}" method="post">
        <input type="hidden" name="_method" value="delete" />
        <input class="btn btn-outline-danger" type="submit" value="Delete" />
      </form>
    </div>
  </body>
</html>
