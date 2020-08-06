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
<style>
body {
background-color: lightgrey;
}
.container {
  max-width: 300px;
  margin: auto;
}
</style>
<body>
<header style="height:30px; background-color:tomato;"></header>

<div class="container">
  <h2 style="color:tomato; text-align:center;">Login Form</h2>
  <hr>
  <span style="font-size: 18; color: Dodgerblue; font-weight: bold;">${message}</span>
  <hr>
  <img alt="kids login" src="img/kids_login.png" style="height:100px;">
  
  <div style="max-width: 500px; margin: auto;">
  <form action="authUser" method="POST">
    <div class="form-group">
    <i class="fa fa-user-circle-o" style="font-size:15px; color:red; text-align:center;"></i>
      <label for="uname">Username:</label>
      <input type="text" class="form-control" id="uname" placeholder="Enter Username" name="uname">
    </div>
    <div class="form-group">
    <i class="fa fa-key" style="font-size:15px; color:red"></i>
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <button type="submit" class="btn btn-danger">Submit</button>
  </form>
  </div>
</div>

</body>
</html>
