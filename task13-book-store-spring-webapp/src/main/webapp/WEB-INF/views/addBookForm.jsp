<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Product</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        form {
            text-align: center;
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

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .drop-down {
            width: 108%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        h1 {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<header class="site-header">
</header>

<h1>Add New Book</h1>

<form action="${pageContext.request.contextPath}/home/books/add" method="post">
    <label for="iban">IBAN</label>
    <input type="number" id="iban" name="iban" required><br><br>

    <label for="bookName">Book Name</label>
    <input type="text" id="bookName" name="bookName" required><br><br>

    <label for="authorName">Author Name</label>
    <input type="text" id="authorName" name="authorName" required><br><br>

    <label for="category">Category</label>
    <select id="category" name="category" required class="drop-down">
        <option value="BIOGRAPHY">Biography</option>
        <option value="CHILDREN">Children</option>
        <option value="COOKING">Cooking</option>
        <option value="FICTION">Fiction</option>
        <option value="FANTASY">Fantasy</option>
        <option value="HISTORY">History</option>
        <option value="HORROR">Horror</option>
        <option value="MYSTERY">Mystery</option>
        <option value="OTHER">Other</option>
        <option value="POETRY">Poetry</option>
        <option value="ROMANCE">Romance</option>
        <option value="SCIENCE">Science</option>
        <option value="SCIENCE_FICTION">Science Fiction</option>
        <option value="SELF_HELP">Self-Help</option>
        <option value="THRILLER">Thriller</option>
        <option value="TRAVEL">Travel</option>
    </select><br><br>

    <label for="price">Price</label>
    <input type="number" step="any" id="price" name="price" required><br><br>

    <button type="submit" class="btn btn-blue">Add Book</button>
</form>
</body>
</html>
