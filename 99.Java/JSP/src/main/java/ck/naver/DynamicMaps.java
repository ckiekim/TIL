package ck.naver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class DynamicMaps {

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("c:/Temp/naver.properties");
        Properties props = new Properties();
        props.load(is);
        is.close();
        
        String accessId = props.getProperty("accessId");
        String secretKey = props.getProperty("secretKey");
        System.out.println("accessId: " + accessId);
        System.out.println("secretKey: " + secretKey);
    }

}
