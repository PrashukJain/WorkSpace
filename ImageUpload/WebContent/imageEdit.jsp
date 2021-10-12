<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="styleImageManagement.css" rel="stylesheet">
</head>
<body>
<%
	session.setAttribute("Id", request.getParameter("imageid"));
%>

<div class="form">
		<header> Image Management Utility </header>
		<div class="inside_form">
			<br />
			<p>Please select an image file to upload(Max Size 1MB)</p>

			<div class="row">
				<div class="col-sm-6">
					<form action="ImageEdit" method="post"
						enctype="multipart/form-data">
						<input type="text" name="filename" /> <input type='file'
							name="image" id="getFile">
				</div>
				<div class="col-sm-6">
					<input type="submit" value="Submit" />&nbsp;&nbsp;&nbsp; <input
						type="submit" value="Cancel" />
				</div>
			</div>
			</form>
			</div>
</body>
</html>