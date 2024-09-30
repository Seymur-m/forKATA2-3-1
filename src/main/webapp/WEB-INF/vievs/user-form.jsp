<html>
<head>
    <title>User Form</title>
</head>
<body>
<h2>User Form</h2>
<form action="save" method="post">
    <input type="hidden" name="id" value="${user.id}" />
    <label>Name:</label>
    <input type="text" name="name" value="${user.name}" />
    <label>Email:</label>
    <input type="text" name="email" value="${user.email}" />
    <button type="submit">Save</button>
</form>
</body>
</html>
