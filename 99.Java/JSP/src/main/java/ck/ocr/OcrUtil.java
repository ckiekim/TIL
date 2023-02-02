package ck.ocr;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

public class OcrUtil {

    public Receipt getReceipt(String jsonStr) {
        JSONObject json = new JSONObject(jsonStr);
        JSONObject result = (JSONObject) ((JSONArray) json.getJSONArray("images")).getJSONObject(0);
        JSONArray fields = (JSONArray) result.getJSONArray("fields");
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (Object field: fields) {
            String text = ((JSONObject) field).getString("inferText");
            list.add(text);
//            System.out.print(text + ", ");
            if (text.length() <= 2)
                continue;
            if (map.containsKey(text)) {
                int val = map.get(text);
                map.put(text, val+1);
            } else {
                map.put(text, 1);
            }
        }
//        System.out.println();
        
        String shop="", date_="", price_="";
        for (int i=0; i<list.size()-2; i++) {
            if (list.get(i).contains("매장") || list.get(i).contains("상호")) {
                if (list.get(i+1).length() <= 1)
                    shop = list.get(i+2);
                else
                    shop = list.get(i+1);
                break;
            }
        }
        if (shop.equals("")) {
            for (int i=0; i<list.size()-3; i++) {
                if (list.get(i).equals("상")) {
                    if (list.get(i+1).contains("호")) {
                        if (list.get(i+2).length() <= 1)
                            shop = list.get(i+3);
                        else
                            shop = list.get(i+2);
                        break;
                    }
                }
            }
        }
//        System.out.println(shop);
        
        Pattern datePattern = Pattern.compile("^\\d{4}[-/년]\\d{2}[-/월]\\d{2}");
        for (String token: list) {
            if (token.length() < 10)
                continue;
            Matcher matcher = datePattern.matcher(token);
            boolean matchFound = matcher.find();
            if (matchFound) {
                date_ = token;
                break;
            }
        }
//        System.out.println(date_);
        String dateStr = date_.substring(0,4) + "-" + date_.substring(5, 7) + "-" + date_.substring(8, 10);
//        System.out.println(dateStr);
        
        Set<String> keySet = map.keySet();
        int maxVal = 0;
        for (String key: keySet) {
            if (map.get(key) > maxVal) {
                maxVal = map.get(key);
                price_ = key;
            }
        }
//        System.out.println(price_);
        int price = Integer.parseInt(price_.replaceAll(",", ""));
        
        Receipt rec = new Receipt(shop, LocalDate.parse(dateStr), price);
//        System.out.println(rec);
        
        return rec;
    }
    
}
