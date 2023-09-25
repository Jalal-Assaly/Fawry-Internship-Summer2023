<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmation</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        h1 {
            margin-top: 20px;
        }

        p {
            margin-top: 10px;
        }

        button {
            background-color: blue;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
            margin-top: 20px;
        }

    </style>
</head>
<body>
<c:choose>
    <c:when test="${action == 'add'}">
        <h1>${pageContext.response.status == 200 ? 'Book Added Successfully' : 'Book Could Not Be Added'}</h1>
        <p>${message}</p>
    </c:when>
    <c:when test="${action == 'delete'}">
        <h1>${pageContext.response.status == 200 ? 'Book Deleted Successfully' : 'Book Could Not Be Deleted'}</h1>
        <p>${message}</p>
    </c:when>
    <c:when test="${action == 'update'}">
        <h1>${pageContext.response.status == 200 ? 'Book Update Successfully' : 'Book Could Not Be Updated'}</h1>
        <p>${message}</p>
    </c:when>
    <c:otherwise>
        <h1>Unknown Action</h1>
        <p>Invalid action requested.</p>
    </c:otherwise>
</c:choose>

<button onclick="redirectToURL()">Back</button>

<script>
    function redirectToURL() {
        window.location.href = "/home/books";
    }
</script>
</body>
</html>
