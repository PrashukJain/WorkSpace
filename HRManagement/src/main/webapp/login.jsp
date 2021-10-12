<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>
<div class="container">
    <form class="w-75" action="login" method="post">
        <fieldset class="reset-this redo-fieldset">
            <legend class="reset-this header">Login</legend>
    
  <div class="form-group row ms-5"> 
            <label for="inputUserName" class="col-sm-2 col-form-label mt-2 mb-2">Username</label>
    <div class="col-sm-8">
      <input type="text"  class="form-control mb-2 mr-5 mt-2 pr-2" id="inputUserName" placeholder="Username" name="userName">
    </div>
  </div>
  <div class="form-group row ms-5">
    <label for="inputPassword" class="col-sm-2 col-form-label mt-2 mb-2 ">Password</label>
    <div class="col-sm-8">
      <input type="password" class="form-control mb-2 mr-5 mt-2" id="inputPassword " placeholder="Password" name="password">
    </div>
  </div>
  <div class="footer">
    <input type="button" class="btn btn-secondary btn-lg" value="Signup" onclick="window.location='signup.jsp'" >
    <button class="btn btn-primary btn-lg" type="submit">login</button>
  </div>
        </fieldset>
    </form>
</div>

</body>
</html>