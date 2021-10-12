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
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<link href="<c:url value="/resources/css/common.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/listingStyle.css" />"
	rel="stylesheet">

</head>
<body>


	<c:if test="${uName!=null}">
		<div>
			<header>
				<h2 class="text-center m-5">
					Welcome
					<c:out value="${uName}" />
				</h2>
				<form method="post">
					<input type="submit" value="signOut" formaction="signOut"
						style="margin-top: 25px;" />
				</form>

			</header>
			<c:if test="${list.size()!=0 }">
				<div class="container">
					<fieldset class="reset-this redo-fieldset">
						<legend class="reset-this header">Employee Listing</legend>

						<div class="fieldsetHeader"
							style="display: flex; float: right; margin-bottom: 5px;">
							<form method="post">
								<input type="submit" value="Upload Employee Details"
									class="uploadButton" formaction="add" method="post"
									style="margin-right: 10px;"> <input type="submit"
									value="Download Employee Details" class="uploadButton"
									formaction="download" method="post" style="margin-right: 10px;">
							</form>

						</div>

						<table class="table w-75 mt-3">
							<tr class="border">
								<th>Employee Code</th>
								<th>Employee Name</th>
								<th>Location</th>
								<th>Email</th>
								<th>Date Of Birth</th>
								<th>Action</th>
							</tr>
							<c:forEach items="${list}" var="employee">
								<td>${employee.getEmployeeCode()}</td>
								<td>${employee.getEmployeeName() }</td>
								<td>${employee.getLocation()}</td>
								<td>${employee.getEmail()}</td>
								<td>${employee.getDate()}</td>
								<td>
									<form method="post">
										<input type="submit" value="edit" formaction="edit"> <input
											type="submit" value="delete" formaction="delete"> <input
											type="hidden" value="${employee.getEmployeeCode()}"
											name="employeeCode">
									</form>

								</td>

								</tr>
							</c:forEach>
						</table>
			</c:if>
			</fieldset>
			<c:if test="${list.size()==0 }">
				<script type="text/javascript">
					alert("server not found");
				</script>
				<marquee>
					<h1>Server Not Found</h1>
				</marquee>
			</c:if>
		</div>

		</div>
	</c:if>
</body>
</html>