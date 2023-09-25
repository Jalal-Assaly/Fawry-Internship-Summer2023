<!DOCTYPE html>
<html>
<head>
    <title>Delete Confirmation</title>
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

        form {
            text-align: center;
            margin-top: 20px;
        }

        input[type="submit"] {
            background-color: red;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
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
<h1>Delete Confirmation</h1>
<p>Are you sure you want to delete ${bookName}</p>

<form action="${pageContext.request.contextPath}/home/books/delete" method="post">
    <input type="hidden" name="iban" value="${iban}">
    <input type="hidden" name="bookName" value="${bookName}">
    <input type="submit" value="Delete">
</form>

<button onclick="cancelDelete()">Cancel</button>

<script>
    function cancelDelete() {
        window.location.href = "/home/books";
    }
</script>
</body>
</html>
