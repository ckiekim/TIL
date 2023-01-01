package ck.naver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ObjectDetect {

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("c:/Temp/naver.properties");
        Properties props = new Properties();
        props.load(is);
        is.close();
        
        String accessId = props.getProperty("accessId");
        String secretKey = props.getProperty("secretKey");
        StringBuffer sb = new StringBuffer();
        String baseUrl = "https://naveropenapi.apigw.ntruss.com/vision-obj/v1/detect";
        File uploadFile = new File("c:/Temp/yolo-test.jpg");
        
        URL url = new URL(baseUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setUseCaches(false);
        conn.setDoOutput(true);
        conn.setDoInput(true);
//        conn.setRequestMethod("POST");
        
        // multipart request
        String boundary = "---" + System.currentTimeMillis() + "---";
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", accessId);
        conn.setRequestProperty("X-NCP-APIGW-API-KEY", secretKey);
        
        OutputStream os = conn.getOutputStream();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(os, "utf-8"), true);
        String lf = "\n";
        
        // file 추가
        String fileName = uploadFile.getName();
        out.append("--" + boundary).append(lf);
        out.append("Content-Disposition: form-data; name=\"image\"; filename=\"" + fileName + "\"").append(lf);
        out.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append(lf);
        out.append(lf);
        out.flush();
        
        // 파일을 읽어서 전송
        FileInputStream fis = new FileInputStream(uploadFile);
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while((bytesRead = fis.read(buffer)) != -1)
            os.write(buffer, 0, bytesRead);         // buf, offset, byesRead
        os.flush();
        fis.close();
        
        out.append(lf).flush();
        out.append("--" + boundary + "--").append(lf);
        out.close();
        
        // 결과 확인
        int responseCode = conn.getResponseCode();
        System.out.println("responseCode: " + responseCode);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        String inputLine = null;
        sb = new StringBuffer();
        while((inputLine = br.readLine()) != null) {
            sb.append(inputLine);                             // 응답결과 JSON 저장
        }
        br.close();
        
        System.out.println(sb);
        
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(sb.toString());
        JSONArray results = (JSONArray) object.get("predictions");
        JSONObject result = (JSONObject) results.get(0);

        long num = (Long) result.get("num_detections");
        System.out.println(num);
        JSONArray classes = (JSONArray) result.get("detection_classes");
        JSONArray names = (JSONArray) result.get("detection_names");
        JSONArray scores = (JSONArray) result.get("detection_scores");
        JSONArray boxes = (JSONArray) result.get("detection_boxes");
        
        List<Detection> detectList = new ArrayList<>();
        for (int i=0; (long)i<num; i++) {
            int label = (int) ((double) classes.get(i));
            String name = (String) names.get(i);
            double score = (double) scores.get(i);
            JSONArray jBox = (JSONArray) boxes.get(i);
            List<Double> box = new ArrayList<>();
            for (int k=0; k<4; k++)
                box.add((double) jBox.get(k));
            detectList.add(new Detection(label, name, score, box));
        }
        detectList.forEach(x -> System.out.println(x));
    }

}
