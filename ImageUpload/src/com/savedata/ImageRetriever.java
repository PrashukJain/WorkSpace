package com.savedata;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.classes.ImageDetails;

import configuration.UtilityConfiguration;

/**
 * Servlet implementation class ImageRetriever
 */
@WebServlet("/ImageRetriever")
public class ImageRetriever extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("In retriever");
        int ImageId = Integer.parseInt(request.getParameter("imageId"));
        System.out.println("ImageId=" + ImageId);
        ImageDetails image = null;
        try (Session session = new UtilityConfiguration().getSession()) {

            image = session.get(ImageDetails.class, ImageId);


        } catch (Exception e) {
            e.printStackTrace();
        }
        if (image != null) {
            response.setContentType("image/jpeg, image/jpg, image/png");
            try {
                System.out.println(image.getImageName());
                response.getOutputStream().flush();
                response.getOutputStream().write(image.getImagePreview());
                response.getOutputStream().close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
