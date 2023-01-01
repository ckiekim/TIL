package ck.naver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Geocode {

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("c:/Temp/naver.properties");
        Properties props = new Properties();
        props.load(is);
        is.close();
        
        String accessId = props.getProperty("accessId");
        String secretKey = props.getProperty("secretKey");
        String baseUrl = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode";
        String query = "서울특별시 중구 세종대로 110(태평로1가)";
        query = URLEncoder.encode(query, "utf-8");
        String coordinate = "127.0824,37.5383";   // 37.5383, 127.0824
        String reqUrl = baseUrl + "?query=" + query;
//        String reqUrl = baseUrl + "?query=" + query + "&coordinate=" + coordinate;
        
        URL url = new URL(reqUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
        /* 헤더 설정 */
        conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", accessId);
        conn.setRequestProperty("X-NCP-APIGW-API-KEY", secretKey);
//        conn.setDoInput(true);
        int responseCode = conn.getResponseCode();
        System.out.println("responseCode: " + responseCode);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String inputLine = null;
        while((inputLine = br.readLine()) != null) {
            sb.append(inputLine);                             // 응답결과 JSON 저장
        }
        br.close();
        
        System.out.println(sb);
        
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(sb.toString());
        System.out.println(object.size());
//        JSONArray results = (JSONArray) object.get("addresses");
//        JSONObject result = (JSONObject) results.get(0);
        JSONObject result = (JSONObject) ((JSONArray) object.get("addresses")).get(0);
        String lng_ = (String) result.get("x");
        String lat_ = (String) result.get("y");
        Double lng = Double.parseDouble(lng_);
        Double lat = Double.parseDouble(lat_);
        System.out.println("경도: " + lng + ", 위도: " + lat);
    }

}
