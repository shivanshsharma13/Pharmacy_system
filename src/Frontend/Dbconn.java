package Frontend;
import java.sql.*;

public class Dbconn {

    public Connection con() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eps_system","root","Shivansh@13");
        return conn;
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery("select * from drug");
//        rs.next();
//        String s = rs.getString("Drug_name");

//        System.out.println(s);

//        st.close();
//        conn.close();
    }

}
