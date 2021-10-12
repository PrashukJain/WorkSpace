package com.action;

import java.util.List;

import org.hibernate.Session;

import com.classes.ImageDetails;
import com.classes.User;

import configuration.UtilityConfiguration;

public class ImageUtility {
    
    public static double getTotalImageSize(String username) {
        double totalSize=0;
        try (Session session = new UtilityConfiguration().getSession()) {
            User user = session.get(User.class, username);
            List<ImageDetails> images = user.getList();
            for (ImageDetails image : images) {
                totalSize += Double.parseDouble(image.getImageSize());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return totalSize;
    }

}
