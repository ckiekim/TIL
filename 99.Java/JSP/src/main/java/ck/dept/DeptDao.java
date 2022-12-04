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

public class DeptDao {
    private String host;
    private String user;
    private String password;
    private String database;
    private String port;
    
    DeptDao() {
        try {
            InputStream is = new FileInputStream("d:/tmp/mysql.properties");
            Properties props = new Properties();
            props.load(is);
            is.close();
            
            host = props.getProperty("host");
            user = props.getProperty("user");
            password = props.getProperty("password");
            database = props.getProperty("database");
            port = props.getProperty("port", "3306");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Connection myGetConnection() {
        Connection conn = null;
        try {
            String connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
            conn = DriverManager.getConnection(connStr, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public List<Dept> getDepts() {
        Connection conn = myGetConnection();
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
