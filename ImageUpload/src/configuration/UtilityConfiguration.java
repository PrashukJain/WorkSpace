package configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.classes.ImageDetails;
import com.classes.User;

public class UtilityConfiguration {
    /*
     * This method is used to create the session using hibernate.
     */
    public Session getSession() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
                .addAnnotatedClass(ImageDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        return session;
    }
}
