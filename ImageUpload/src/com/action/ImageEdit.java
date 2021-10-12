package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.classes.ImageDetails;
import com.classes.User;

import configuration.UtilityConfiguration;

@WebServlet("/ImageEdit")
public class ImageEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    

        int ImageId = Integer.parseInt((String) request.getSession().getAttribute("Id"));
	    System.out.println("ID"+ImageId);
        try (Session session = new UtilityConfiguration().getSession()) {
            Transaction tx = session.beginTransaction();
            ImageDetails image = session.load(ImageDetails.class, ImageId);
	        
	        String imageName = "";
	        byte bytes[] = null;
	        double imageSize = 0;

	        if (ServletFileUpload.isMultipartContent(request)) {

	            try {
	                List<FileItem> fileitems = new ServletFileUpload(new DiskFileItemFactory())
	                        .parseRequest(new ServletRequestContext(request));

	                for (FileItem items : fileitems) {
	                    if (items.isFormField()) {
	                        imageName = items.getString();
	                    } else {
	                        imageSize = items.getSize() / 1024;
	                        bytes = items.get();
	                    }
	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

            User user = (User) request.getSession().getAttribute("user");
            ImageDetails ud = new ImageDetails();
            ud.setImagePreview(bytes);
	        ud.setImageName(imageName);
            ud.setImageSize("" + imageSize);
            ud.setId(ImageId);
            ud.setUser(user);
	        
            String username = user.getUserName();
	        image=ud;
	        System.out.println("Image size"+ImageUtility.getTotalImageSize(username));

            if (Double.parseDouble(ud.getImageSize()) < 1024) {
	            if (ImageUtility.getTotalImageSize(username) < 10240) {
	                System.out.println("uploaded successfully");
	                
	                    
	                    session.update(image);
                        tx.commit();
                        response.sendRedirect("imageManagement.jsp");
	                    // request.getRequestDispatcher("ImageManagementpage.jsp").forward(request, response);
	                
	            } else {
	                System.out.println("Total image size exceeded");
	            }
	        } else {
	            System.out.println("image size exceeded");
	        }

	        

	    }

	        
	    }
	}


