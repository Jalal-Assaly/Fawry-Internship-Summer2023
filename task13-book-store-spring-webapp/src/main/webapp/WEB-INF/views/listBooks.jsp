<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books List</title>
    <style>
        body {
            min-height: 100vh;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .button-container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            margin-bottom: 10px;
            padding: 10px;
        }

        .btn-blue {
            background-color: blue;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
        }

        .search-bar {
            text-align: center;
            margin-top: 20px;
            padding-bottom: 20px;
        }

        .search-input {
            width: 300px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .search-button {
            background-color: gray;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
        }

        .btn-group {
            display: flex;
            justify-content: center;
            margin-top: 10px;
        }

        .btn-red {
            background-color: red;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
        }

        .btn-update {
            margin-left: 10px;
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

        h1 {
            margin: 0;
            padding: 20px;
            text-align: center;
        }

        .books-list {
            display: grid;
            grid-template-columns: repeat(3, 1fr); /* 3 cards per row */
            gap: 20px; /* Gap between cards */
            justify-content: center;
            align-items: start;
        }

        .book-card {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="content-container">
    <h1>Books List</h1>

    <div class="button-container">
        <form action="books/add" method="get">
            <button type="submit" class="btn btn-blue">Add New Book</button>
        </form>
    </div>

    <div class="search-bar">
        <form action="${pageContext.request.contextPath}/home/books/search" method="get">
            <label for="search-input"></label>
            <input type="text" id="search-input" name="keyword" class="search-input" placeholder="Search...">
            <button type="submit" class="btn btn-blue search-button">Search</button>
        </form>
    </div>

    <div class="books-list">
        <jsp:useBean id="books" scope="request" type="java.util.List"/>
        <c:forEach var="book" items="${books}">
            <div class="book-card">
                <h1>${book.bookName}</h1>
                <h2>${book.authorName}</h2>
                <h3>Price: $${book.price}</h3>
                <h5>${book.category}</h5>
                <h5>IBAN: ${book.iban}</h5>

                <div class="btn-group">
                    <form action="${pageContext.request.contextPath}/home/books/delete" method="get">
                        <input type="hidden" name="iban" value="${book.iban}">
                        <input type="hidden" name="bookName" value="${book.bookName}">
                        <button type="submit" class="btn btn-red">Delete</button>
                    </form>

                    <form action="${pageContext.request.contextPath}/home/books/update" method="get">
                        <input type="hidden" name="iban" value="${book.iban}">
                        <input type="hidden" name="bookName" value="${book.bookName}">
                        <input type="hidden" name="authorName" value="${book.authorName}">
                        <input type="hidden" name="category" value="${book.category}">
                        <input type="hidden" name="price" value="${book.price}">
                        <button type="submit" class="btn btn-blue btn-update">Update</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>


