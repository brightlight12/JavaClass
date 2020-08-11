<!DOCTYPE html>
<%@page import="com.cubicit.controller.Login"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
  <title>Login Data Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<style>
.center {
  margin-left: auto;
  margin-right: auto;
}
</style>
<body>

<header style="height: 30px; background-color: tomato;">
</header>

<div class="container">
   <img alt="kids login" src="img/kids_login.png" style="height:100px;">
   <div style="text-align: center;">
   <span style="font-size: 36px; color: dodgerblue; font-weight: bold;">Login Data</span>
   <hr>
   <span style="font-size: 18px; color: red; font-style: italics;">${message}</span>
   </div>
   <div class="center" style="width: 70%; text-align: center;">
   
   <table class="table table-bordered">
    <thead>
      <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>D.O.E</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    <%
    List<Login> loginlist = (List<Login>)request.getAttribute("logindata");
    for(Login loginn:loginlist){
    %>
      <tr>
        <td style="background-color: dodgerblue;"><%=loginn.getId() %></td>
        <td><%=loginn.getUsername() %></td>
        <td><%=loginn.getPassword() %></td>
        <td><%=loginn.getDoe() %>
        <td>
        <a href="deletebyid?id=<%=loginn.getId() %>">
        <img src="img/delete_icon.jpg" style="height: 20px;">
        </a>
        <a href="editlogin?did=<%=loginn.getId() %>">
        <img src="img/edit.png" style="height: 30px;">
        </a>
        </td>
      </tr>
    <% } %> 
     
    </tbody>
  </table>
   
  </div>
</div>
<div style="max-width: 800px; margin: auto; text-align:center;">
    <a href="oauth" style="padding:20px;">
    <button type="button" class="btn btn-secondary">Go to login page</button>
    </a>
     <a href="myinput" style="padding:20px;">
    <button type="button" class="btn btn-primary">Add New User Login</button>
    </a>
    </div>
</body>
</html>