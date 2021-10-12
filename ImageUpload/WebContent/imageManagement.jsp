<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="configuration.UtilityConfiguration"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="java.util.*"%>
<%@page import="com.classes.ImageDetails"%>
<%@page import="com.savedata.ImageDao" %>
<%@page import="com.classes.User"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link href="styleImageManagement.css" rel="stylesheet">
</head>
<body>
<%
	    User user = (User) session.getAttribute("user");
	%>
 <div class="form" action="addImage">
        <header>
            Image Management Utility
        </header>
        <div class="inside_form">
            <br />
            <p>Please select an image file to upload(Max Size 1MB)</p>
           
                <div class="row">
				<div class="col-sm-6">
					<form action="uploadfile" method="post"
						enctype="multipart/form-data">
						<input type="text" name="filename" /> <input type='file'
							name="image" id="getFile">
				</div>
				<div class="col-sm-6">
					<input type="submit" value="Submit" />&nbsp;&nbsp;&nbsp; <input
						type="reset" value="Cancel" />
				</div>
			</div>
			</form>
        
                <br />
                <h5>Uploaded Images</h5>
                <br />
                <table class="table">
                    <tr>
                        <th>S.No.</th>
                        <th>Name</th>
                        <th>Size</th>
                        <th>Preview</th>
                        <th>Actions</th>
                    </tr>
                    	<%
                    	List<ImageDetails> images=ImageDao.getImages(user.getUserName());
				int i=0;
				if (images!=null) {
				for(ImageDetails image:images){
				    i++;
			
				%>
			<tr>
				<td><%=i%></td>
				<td><%=image.getImageName()%></td>
				<td>'<%=image.getImageSize()%>'</td>
				<td><img src="ImageRetriever?imageId=<%=image.getId()%>" height="90" width="90"></td>
					<td><a href="imageEdit.jsp?imageid=<%=image.getId()%>"
							class="btn btn-outline-info a-btn-slide-text">Edit</a>
							 <a
							href="ImageDelete?imageid=<%=image.getId()%>"
							class="btn btn-outline-danger a-btn-slide-text"> <span><strong>Delete</strong></span>
						</a></td>
			</tr>
		<%
				}
				}
		%>
             
                </table>

</form>
    </div>
    </div>
</body>
</html>