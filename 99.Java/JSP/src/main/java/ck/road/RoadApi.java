package ck.road;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

// json-simple-1.1.1.jar, https://code.google.com/archive/p/json-simple/downloads
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RoadApi {

    public static void main(String[] args) throws Exception {
        int currentPage = 1;
        int countPerPage = 10;
        String resultType = "json";
        String confmKey = "U01TX0FVVEgyMDIwMTExOTEwMjMzNTExMDQzNzg=";
        String keyword = URLEncoder.encode("광진구청", "utf-8");
        String apiUrl = "https://business.juso.go.kr/addrlink/addrLinkApi.do?currentPage="
                        + currentPage + "&countPerPage=" + countPerPage + "&keyword=" + keyword
                        + "&confmKey=" + confmKey + "&resultType=" + resultType;
        
        URL url = new URL(apiUrl);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
        StringBuffer sb = new StringBuffer();
        String tempStr = null;
        
        while(true) {
            tempStr = br.readLine();
            if(tempStr == null) 
                break;
            sb.append(tempStr);                             // 응답결과 JSON 저장
        }
        br.close();
        
        System.out.println(sb);
        
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(sb.toString());
        JSONObject results = (JSONObject) object.get("results");
        JSONObject common = (JSONObject) results.get("common");
        String errorMessage = (String) common.get("errorMessage");
        System.out.println(errorMessage);
        JSONArray juso = (JSONArray) results.get("juso");
        System.out.println(juso.size());
        JSONObject jusoVal = (JSONObject) juso.get(0);
        String roadAddr = (String) jusoVal.get("roadAddr");
        System.out.println(roadAddr);
    }

}
