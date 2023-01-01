package ck.naver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.Properties;

public class TextToSpeech {

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("c:/Temp/naver.properties");
        Properties props = new Properties();
        props.load(is);
        is.close();
        
        String accessId = props.getProperty("accessId");
        String secretKey = props.getProperty("secretKey");
        
        String baseUrl = "https://naveropenapi.apigw.ntruss.com/voice-premium/v1/tts";
        URL url = new URL(baseUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", accessId);
        conn.setRequestProperty("X-NCP-APIGW-API-KEY", secretKey);
        
        // POST parameter
        String speaker = "nara";
        String text = URLEncoder.encode("안녕하세요? 만나서 반갑습니다.", "UTF-8"); 
        String volume = "0";        // -5: 0.5배 낮은 볼륨 ~ 5: 1.5배 큰 볼륨, default=0
        String speed = "0";         // -5: 2배 빠른 속도 ~ 5: 0.5배 느린 속도, default=0
        String pitch = "0";         // -5: 1.2배 높은 피치 ~ 5: 0.8배 낮은 피치, default=0
        int emotion = 0;            // 0: 기본, 1: 어두운 음성, 2: 밝은 음성, default=0
        String format = "mp3";      // mp3, wav
        String postParams = "speaker=nara" + "&volume=" + volume
                            + "&speed=" + speed + "&pitch=" + pitch
                            + "&emotion=" + emotion + "&format=" + format
                            + "&text=" + text;
        // 데이터 전송
        conn.setDoOutput(true);
        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
        dos.writeBytes(postParams);
        dos.flush();
        dos.close();
        
        // 결과 확인
        int responseCode = conn.getResponseCode();
        System.out.println("responseCode: " + responseCode);
        
        BufferedReader br;
        if (responseCode == 200) {
            is = conn.getInputStream();
            int count = 0;
            byte[] buffer = new byte[1024];
            // 랜덤한 이름으로 파일 생성
            String now = LocalDateTime.now().toString().substring(0,22).replaceAll("[-T:.]", "");
            String fname = "c:/Temp/ai/" + now + "." + format;
            File file = new File(fname);
            //file.createNewFile();
            OutputStream os = new FileOutputStream(file);
            while ((count = is.read(buffer)) != -1)
                os.write(buffer, 0, count);
            is.close();
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        }
        
    }

}
