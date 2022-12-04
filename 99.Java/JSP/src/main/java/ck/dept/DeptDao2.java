package ck.dept;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DeptDao2 {
    public static Connection getConnection() {
        Connection conn;
        try {
            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/test");
            conn = ds.getConnection();
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
        return conn;
    }
    
    public List<Dept> getDepts() {
        Connection conn = getConnection();
        List<Dept> list = new ArrayList<>();
        String sql = "SELECT * FROM dept;";
        try {
            Statement stmt = conn.createStatement();
            
            // Select 실행
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Dept d = new Dept();
                d.setDid(rs.getInt(1));
                d.setName(rs.getString(2));
                list.add(d);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return list;
    }
}
