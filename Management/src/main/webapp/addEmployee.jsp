<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/common.css" />"
	rel="stylesheet">
</head>
<body>

	<c:if test="${uName!=null}">
		<header style="display: flex; justify-content: flex-end;">
			<h2 class="text-center m-5">
				Welcome
				<c:out value="${uName}" />
			</h2>
			<form method="post">
				<input type="submit" value="SignOut" formaction="signOut"
					class="signOutButton" />
			</form>

		</header>
		<section class="container">
			<fieldset class="reset-this redo-fieldset">
				<legend class="reset-this header">Add Employee Details</legend>
				<form action="addEmployee" method="post">
					<div class="form-group row ms-5">
						<label for="inputEmployeeCode"
							class="col-sm-2 col-form-label mt-2 mb-2">Employee Code:</label>
						<div class="col-sm-8">
							<input type="number" class="form-control mb-2 mr-5 mt-2 pr-2"
								id="inputEmployeeCode" placeholder="Code" name="employeeCode">
						</div>
					</div>
					<div class="form-group row ms-5">
						<label for="inputEmployeeName"
							class="col-sm-2 col-form-label mt-2 mb-2">Employee Name:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control mb-2 mr-5 mt-2 pr-2"
								id="inputEmployeeName" placeholder="Name" name="employeeName">
						</div>
					</div>
					<div class="form-group row ms-5">
						<label for="inputEmployeeLocation"
							class="col-sm-2 col-form-label mt-2 mb-2">Employee
							Location:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control mb-2 mr-5 mt-2 pr-2"
								id="inputEmployeeLocation" placeholder="Location"
								name="employeeLocation">
						</div>
					</div>
					<div class="form-group row ms-5">
						<label for="inputEmployeeEmail"
							class="col-sm-2 col-form-label mt-2 mb-2">Email:</label>
						<div class="col-sm-8">
							<input type="email" class="form-control mb-2 mr-5 mt-2 pr-2"
								id="inputEmployeeEmail" placeholder="Email" name="employeeEmail">
						</div>
					</div>
					<div class="form-group row ms-5">
						<label for="inputEmployeeDOB"
							class="col-sm-2 col-form-label mt-2 mb-2">Date Of Birth</label>
						<div class="col-sm-8">
							<input type="date" class="form-control mb-2 mr-5 mt-2 pr-2"
								id="inputEmployeeCode" name="employeeDOB">
						</div>
					</div>
					<div class="form-group row ms-5">
						<div class="col-sm-2">
							<input type="submit" value="Save" />
						</div>

						<div class="col-sm-2">
							<input type="reset" value="cancel" />
						</div>

					</div>
				</form>
			</fieldset>
		</section>
	</c:if>
</body>
</html>