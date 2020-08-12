<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Data Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
  <h2 style="color:DodgerBlue; text-align:center;">Add Data</h2>
  <span style="font-size: 18; font-style: italic; color: seagreen;">${message}</span>
  <span style="font-size: 18; font-style: italic; color: red;">${dangermessage}</span>
  <div style="max-width: 500px; margin: auto;">
  
  <form action="myinput" method="POST" enctype="multipart/form-data">
    <div class="form-group">
    <i class="fa fa-user-circle-o" style="font-size:15px; color:red; text-align:center;"></i>
      <label for="uname">Username:</label>
      <input type="text" class="form-control" id="uname" placeholder="Enter Username" name="username">
    </div>
    
    <div class="form-group">
    <i class="fa fa-key" style="font-size:15px; color:red"></i>
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
    </div>
    
     <div class="form-group">
    <i class="far fa-file" style="font-size:15px; color:red"></i>
      <label for="photo">Photo:</label>
      <input type="file" class="form-control" id="file" name="file" multiple="multiple">
    </div>
    
    <div style="text-align: center;">
    <button type="submit" class="btn btn-primary">Add</button>  
    <button type="reset" class="btn btn-danger">Cancel</button>  
    </div>
    
  </form>
  </div>
</div>

<hr>

<div style="max-width: 800px; margin: auto; text-align:center;">
    <a href="oauth" style="padding:20px;">
    <button type="button" class="btn btn-secondary">Go to login page</button>
    </a>
     <a href="showlogin" style="padding:20px;">
    <button type="button" class="btn btn-warning">Show All User Logins</button>
    </a>
</div>
<hr>

</body>
</html>
