package com.savedata;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.classes.ImageDetails;
import com.classes.User;

public class ImageDao {
    public static List<ImageDetails> getImages(String username) {

        List<ImageDetails> images = new ArrayList<>();

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        User u = session.get(User.class, username);
        images = u.getList();
        tx.commit();
        session.close();
        factory.close();
        return images;
    }
}
