<!DOCTYPE html>
<html lang="en">
  <head>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <h1>All Books</h1>
    <table>
      <thead>
        <tr>
          <th id="bookTitle">Title</th>
          <th id="bookDesc">Description</th>
          <th id="bookLang">Language</th>
          <th id="bookPages">Number of Pages</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${books}" var="book">
          <tr>
            <td><c:out value="${book.title}" /></td>
            <td><c:out value="${book.description}" /></td>
            <td><c:out value="${book.language}" /></td>
            <td><c:out value="${book.numberOfPages}" /></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <a href="/books/new">New Book</a>
  </body>
</html>
