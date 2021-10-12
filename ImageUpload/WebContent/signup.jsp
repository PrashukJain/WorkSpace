<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link href="style.css" rel="stylesheet">
</head>
<body class="w-75 border">
<%
String message=(String)request.getAttribute("msg");
            System.out.println(message);
%>
<script type="text/javascript">
function alert(){
var msg="<%=message%>";
if(<%=message!=null%>&&msg&&!msg.equals("")){
alert(msg);
}
}
</script>
 <header class="border h2 p-2">
  SignUp
  </header class="border border-primary">
<div class="container">
 
<form class="w-75" action="signUp">

  <div class="form-group row ms-5">
 
    <label for="inputUserName" class="col-sm-2 col-form-label mt-2 mb-2">Username</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control mb-2 mr-5 mt-2 pr-2" id="inputUserName" placeholder="Username" name="userName">
    </div>
  </div>
  <div class="form-group row ms-5">
    <label for="inputPassword" class="col-sm-2 col-form-label mt-2 mb-2 ">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control mb-2 mr-5 mt-2" id="inputPassword " placeholder="Password" name="password">
    </div>
  </div>
  <footer class="border">
  <button class="btn btn-primary" type="submit"  onsubmit="return alert()">Signup</button>
  </footer>
</form>

</div>

</body>

</html>