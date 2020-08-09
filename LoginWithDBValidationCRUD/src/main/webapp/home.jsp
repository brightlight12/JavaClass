<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Auth Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<header style="height:30px; background-color:tomato;"></header>

<div class="container">
<div style="text-align: center;">
  <h2>Welcome Home!</h2>
  
  <img alt="welcome picture" src="img/welcome.jpg" style="width:80%;">
  </div>
</div>

<div style="max-width: 800px; margin: auto; text-align:center; padding-top: 10px;">
    <a href="myinput" style="padding:20px;">
    <button type="button" class="btn btn-danger">Add New User Login</button>
    </a>
     <a href="showlogin" style="padding:20px;">
    <button type="button" class="btn btn-warning">Show All User Logins</button>
    </a>
</div>

</body>
</html>
