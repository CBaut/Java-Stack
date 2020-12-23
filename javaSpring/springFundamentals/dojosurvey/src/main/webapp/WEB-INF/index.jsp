<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>Dojo Survey</title>
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body>
    <h1>Welcome</h1>
    <div class="container">
      <form action="/survey" method="POST">
        <table>
          <tr>
            <td>
              <p>Your Name:</p>
            </td>
            <td>
              <input type="text" name="name" />
            </td>
          </tr>
          <tr>
            <td>
              <p>Dojo Location:</p>
            </td>
            <td>
              <select name="location">
                <option value="Saudi Digital Academy">SDA</option>
                <option value="Orange County">OC</option>
                <option value="Los Angeles">Los Angeles</option>
                <option value="Bellevue">Bellevue</option>
                <option value="San Jose">San Jose</option>
                <option value="Chicago">Chicago</option>
              </select>
            </td>
          </tr>
          <tr>
            <td>
              <p>Favorite Language:</p>
            </td>
            <td>
              <select name="language">
                <option value="Python">Python</option>
                <option value="JavaScript">JavaScript</option>
                <option value="HTML/CSS">HTML/CSS</option>
                <option value="Java">Java</option>
                <option value="C#">C#</option>
                <option value="Ruby">ruby</option>
              </select>
            </td>
          </tr>
            <td>
              <p>Comment (optional):</p>
            </td>
          </tr>
          <tr>
            <td>
              <textarea name="comment"></textarea>
            </td>
          </tr>
          <tr>
            <td>
              <button type="submit">Submit</button>
            </td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>
