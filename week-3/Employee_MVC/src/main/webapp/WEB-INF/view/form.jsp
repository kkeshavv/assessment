<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="submitForm2" method="post">

		<label>ID:</label><br>
    	<input type="number" name="id" required><br><br>
        
        <label>Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Phone:</label><br>
        <input type="tel" name="phone" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>
        
        

        

        <input type="submit" value="Submit">

    </form>

</body>
</html>