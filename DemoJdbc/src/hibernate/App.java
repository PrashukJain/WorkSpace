package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {
Laptop laptop=new Laptop();
laptop.setBrand("Hp");
laptop.setId(102);
        StudentName name = new StudentName();
        name.setFirstName("Prashuk");
        name.setLastName("Jain");
        Student student = new Student();
        student.setName(name);
        student.setRollNumber(193);
        student.setDepartment("Java");
        student.getLaptop().add(laptop);
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        // session.save(student);
        // session.save(laptop);

        // for fetching data
        student = session.get(Student.class, 194);
        System.out.println(student);
        tx.commit();
        // System.out.println(student);
      

    }

}
