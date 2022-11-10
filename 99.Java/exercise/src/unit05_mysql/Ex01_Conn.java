package unit05_mysql;

import java.sql.*;

public class Ex01_Conn {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false", 
                    "eseven", "eseven");
            st = conn.createStatement();
            String sql = "select * from dept;";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int deptId = rs.getInt(1);
                String name = rs.getString(2);
                System.out.printf("%d %s\n", deptId, name);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}
