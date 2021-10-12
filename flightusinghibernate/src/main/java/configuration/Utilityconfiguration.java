package configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import details.FlightDetails;

public class Utilityconfiguration {
    public Session getConfiguration() {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FlightDetails.class);
    SessionFactory sf = con.buildSessionFactory();
    Session session = sf.openSession();
    return session;
}
}
