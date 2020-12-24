<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="/css/style.css" rel="stylesheet" />
    <title>Ninja Gold</title>
  </head>
  <body>
    <div class="container">
      <h3 class="gold">
        Your Gold: <span class="gold"><c:out value="${gold}" /></span>
      </h3>
      <!-- FORMS -->
      <div class="forms">
        <div class="form">
          <h3>Farm</h3>
          <h5>(Earns 10-20 gold)</h5>
          <form action="/process" method="POST">
            <input type="hidden" name="process" value="farm" />
            <button type="submit">Find Gold!</button>
          </form>
        </div>
        <div class="form">
          <h3>Cave</h3>
          <h5>(Earns 5-10 gold)</h5>
          <form action="/process" method="POST">
            <input type="hidden" name="process" value="cave" />
            <button type="submit">Find Gold!</button>
          </form>
        </div>
        <div class="form">
          <h3>House</h3>
          <h5>(Earns 2-5 gold)</h5>
          <form action="/process" method="POST">
            <input type="hidden" name="process" value="house" />
            <button type="submit">Find Gold!</button>
          </form>
        </div>
        <div class="form">
          <h3>Casino</h3>
          <h5>(Earns / Takes 0-50 gold)</h5>
          <form action="/process" method="POST">
            <input type="hidden" name="process" value="casino" />
            <button type="submit">Find Gold!</button>
          </form>
        </div>
      </div>

      <!-- ACTIVITIES -->
      <h3 class="gold">Activity Log:</h3>
      <div class="activities">
        <c:forEach items="${activities}" var="activity">
            <c:if test="${activity.contains('lost')}"><p class="red"></c:if>
            <c:if test="${activity.contains('earned')}"><p class="green"></c:if>
            <c:out value="${activity}" />
          </p>
        </c:forEach>
      </div>
      <button class="reset"><a href="/reset">Reset Game</a></button>
    </div>
  </body>
</html>
