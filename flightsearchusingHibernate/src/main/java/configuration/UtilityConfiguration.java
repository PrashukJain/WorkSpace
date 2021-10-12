package configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import details.FlightDetails;

public class UtilityConfiguration {
    /*
     * This method is used to create the session using hibernate.
     */
    public Session getSession() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FlightDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        return session;
    }
}
