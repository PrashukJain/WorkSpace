package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/world";
        String uName="root";
        String pass = "root";
        // String query = "Select * from city where Name='Rafah' ";
        String query = "insert into city values(4081,\"ludhiana\",\"IND\",\"Ludhiana\",13001)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uName, pass);
        Statement st = con.createStatement();
        // ResultSet rs = st.executeQuery(query);
        int count = st.executeUpdate(query);
        // rs.next();
        // // while(rs.next()) {
        // System.out.println(rs.getString(2) + " " + rs.getString(4) + " " + rs.getLong("Population"));
        // // }
        System.out.println(count + "row's affected");
con.close();
    }
}
