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

public class JSONTest {

    public static void main(String[] args) {
        String jsonStr = "{\"version\":\"V2\",\"requestId\":\"5accdc5f-1751-4c54-a6c9-94de9c6b4fa9\",\"timestamp\":1675343055153,\"images\":[{\"uid\":\"9cf68f81e3d140fd8df2500c0fe8a194\",\"name\":\"demo\",\"inferResult\":\"SUCCESS\",\"message\":\"SUCCESS\",\"validationResult\":{\"result\":\"NO_REQUESTED\"},\"convertedImageInfo\":{\"width\":683,\"height\":910,\"pageIndex\":0,\"longImage\":false},\"fields\":[{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":215.0,\"y\":25.0},{\"x\":280.0,\"y\":25.0},{\"x\":280.0,\"y\":96.0},{\"x\":215.0,\"y\":96.0}]},\"inferText\":\"영\",\"inferConfidence\":0.9988,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":333.0,\"y\":28.0},{\"x\":393.0,\"y\":28.0},{\"x\":393.0,\"y\":87.0},{\"x\":333.0,\"y\":87.0}]},\"inferText\":\"수\",\"inferConfidence\":1.0,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":439.0,\"y\":18.0},{\"x\":508.0,\"y\":18.0},{\"x\":508.0,\"y\":90.0},{\"x\":439.0,\"y\":90.0}]},\"inferText\":\"증\",\"inferConfidence\":0.9991,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":51.0,\"y\":163.0},{\"x\":88.0,\"y\":163.0},{\"x\":88.0,\"y\":199.0},{\"x\":51.0,\"y\":199.0}]},\"inferText\":\"상\",\"inferConfidence\":0.9998,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":108.0,\"y\":163.0},{\"x\":153.0,\"y\":163.0},{\"x\":153.0,\"y\":194.0},{\"x\":108.0,\"y\":194.0}]},\"inferText\":\"호:\",\"inferConfidence\":0.9987,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":161.0,\"y\":158.0},{\"x\":421.0,\"y\":154.0},{\"x\":421.0,\"y\":191.0},{\"x\":162.0,\"y\":195.0}]},\"inferText\":\"이삭토스트(고대점)\",\"inferConfidence\":0.9965,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":51.0,\"y\":198.0},{\"x\":210.0,\"y\":194.0},{\"x\":211.0,\"y\":232.0},{\"x\":52.0,\"y\":235.0}]},\"inferText\":\"사업자번호:\",\"inferConfidence\":0.9997,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":214.0,\"y\":195.0},{\"x\":395.0,\"y\":191.0},{\"x\":395.0,\"y\":225.0},{\"x\":215.0,\"y\":229.0}]},\"inferText\":\"209-12-84764\",\"inferConfidence\":0.9998,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":416.0,\"y\":189.0},{\"x\":520.0,\"y\":187.0},{\"x\":520.0,\"y\":224.0},{\"x\":417.0,\"y\":225.0}]},\"inferText\":\"대표자:\",\"inferConfidence\":0.9998,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":532.0,\"y\":187.0},{\"x\":620.0,\"y\":186.0},{\"x\":620.0,\"y\":223.0},{\"x\":532.0,\"y\":225.0}]},\"inferText\":\"김인선\",\"inferConfidence\":0.9994,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":55.0,\"y\":233.0},{\"x\":87.0,\"y\":233.0},{\"x\":87.0,\"y\":268.0},{\"x\":55.0,\"y\":268.0}]},\"inferText\":\"주\",\"inferConfidence\":0.9999,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":110.0,\"y\":233.0},{\"x\":154.0,\"y\":233.0},{\"x\":154.0,\"y\":265.0},{\"x\":110.0,\"y\":265.0}]},\"inferText\":\"소:\",\"inferConfidence\":0.9992,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":163.0,\"y\":232.0},{\"x\":224.0,\"y\":232.0},{\"x\":224.0,\"y\":268.0},{\"x\":163.0,\"y\":268.0}]},\"inferText\":\"서울\",\"inferConfidence\":0.9922,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":235.0,\"y\":228.0},{\"x\":321.0,\"y\":228.0},{\"x\":321.0,\"y\":265.0},{\"x\":235.0,\"y\":265.0}]},\"inferText\":\"성북구\",\"inferConfidence\":0.9963,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":332.0,\"y\":228.0},{\"x\":465.0,\"y\":224.0},{\"x\":466.0,\"y\":261.0},{\"x\":333.0,\"y\":265.0}]},\"inferText\":\"안암동5가\",\"inferConfidence\":0.9991,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":54.0,\"y\":268.0},{\"x\":87.0,\"y\":268.0},{\"x\":87.0,\"y\":303.0},{\"x\":54.0,\"y\":303.0}]},\"inferText\":\"전\",\"inferConfidence\":1.0,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":110.0,\"y\":268.0},{\"x\":156.0,\"y\":268.0},{\"x\":156.0,\"y\":301.0},{\"x\":110.0,\"y\":301.0}]},\"inferText\":\"화:\",\"inferConfidence\":0.9995,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":161.0,\"y\":266.0},{\"x\":326.0,\"y\":264.0},{\"x\":326.0,\"y\":298.0},{\"x\":162.0,\"y\":300.0}]},\"inferText\":\"02)921-2248\",\"inferConfidence\":0.9998,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":49.0,\"y\":337.0},{\"x\":254.0,\"y\":336.0},{\"x\":255.0,\"y\":370.0},{\"x\":50.0,\"y\":372.0}]},\"inferText\":\"2013년02월05일\",\"inferConfidence\":0.9998,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":265.0,\"y\":336.0},{\"x\":339.0,\"y\":336.0},{\"x\":339.0,\"y\":366.0},{\"x\":265.0,\"y\":366.0}]},\"inferText\":\"13.34\",\"inferConfidence\":0.9915,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":348.0,\"y\":337.0},{\"x\":391.0,\"y\":337.0},{\"x\":391.0,\"y\":363.0},{\"x\":348.0,\"y\":363.0}]},\"inferText\":\"No:\",\"inferConfidence\":0.9908,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":387.0,\"y\":332.0},{\"x\":453.0,\"y\":332.0},{\"x\":453.0,\"y\":365.0},{\"x\":387.0,\"y\":365.0}]},\"inferText\":\"0029\",\"inferConfidence\":0.9998,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":455.0,\"y\":331.0},{\"x\":651.0,\"y\":326.0},{\"x\":652.0,\"y\":363.0},{\"x\":456.0,\"y\":368.0}]},\"inferText\":\"01-초기사용자\",\"inferConfidence\":0.9844,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":56.0,\"y\":408.0},{\"x\":129.0,\"y\":408.0},{\"x\":129.0,\"y\":439.0},{\"x\":56.0,\"y\":439.0}]},\"inferText\":\"메 뉴\",\"inferConfidence\":0.9921,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":138.0,\"y\":405.0},{\"x\":171.0,\"y\":405.0},{\"x\":171.0,\"y\":440.0},{\"x\":138.0,\"y\":440.0}]},\"inferText\":\"명\",\"inferConfidence\":0.9999,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":375.0,\"y\":400.0},{\"x\":438.0,\"y\":400.0},{\"x\":438.0,\"y\":438.0},{\"x\":375.0,\"y\":438.0}]},\"inferText\":\"단가\",\"inferConfidence\":0.9999,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":446.0,\"y\":400.0},{\"x\":509.0,\"y\":400.0},{\"x\":509.0,\"y\":436.0},{\"x\":446.0,\"y\":436.0}]},\"inferText\":\"수량\",\"inferConfidence\":0.9999,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":589.0,\"y\":396.0},{\"x\":650.0,\"y\":396.0},{\"x\":650.0,\"y\":435.0},{\"x\":589.0,\"y\":435.0}]},\"inferText\":\"금액\",\"inferConfidence\":1.0,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":68.0,\"y\":475.0},{\"x\":173.0,\"y\":472.0},{\"x\":174.0,\"y\":509.0},{\"x\":69.0,\"y\":512.0}]},\"inferText\":\"햄,치즈\",\"inferConfidence\":0.9964,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":359.0,\"y\":470.0},{\"x\":440.0,\"y\":470.0},{\"x\":440.0,\"y\":504.0},{\"x\":359.0,\"y\":504.0}]},\"inferText\":\"2,000\",\"inferConfidence\":0.9999,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":485.0,\"y\":470.0},{\"x\":509.0,\"y\":470.0},{\"x\":509.0,\"y\":500.0},{\"x\":485.0,\"y\":500.0}]},\"inferText\":\"2\",\"inferConfidence\":1.0,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":572.0,\"y\":469.0},{\"x\":654.0,\"y\":469.0},{\"x\":654.0,\"y\":502.0},{\"x\":572.0,\"y\":502.0}]},\"inferText\":\"4,000\",\"inferConfidence\":0.9998,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":56.0,\"y\":543.0},{\"x\":277.0,\"y\":540.0},{\"x\":278.0,\"y\":579.0},{\"x\":57.0,\"y\":582.0}]},\"inferText\":\"판매금액\",\"inferConfidence\":1.0,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":502.0,\"y\":539.0},{\"x\":651.0,\"y\":537.0},{\"x\":652.0,\"y\":573.0},{\"x\":502.0,\"y\":575.0}]},\"inferText\":\"4,000\",\"inferConfidence\":0.9997,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":310.0,\"y\":574.0},{\"x\":424.0,\"y\":574.0},{\"x\":424.0,\"y\":612.0},{\"x\":310.0,\"y\":612.0}]},\"inferText\":\"과세금액\",\"inferConfidence\":0.9999,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":573.0,\"y\":573.0},{\"x\":654.0,\"y\":573.0},{\"x\":654.0,\"y\":605.0},{\"x\":573.0,\"y\":605.0}]},\"inferText\":\"3,637\",\"inferConfidence\":1.0,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":208.0,\"y\":612.0},{\"x\":425.0,\"y\":608.0},{\"x\":425.0,\"y\":645.0},{\"x\":209.0,\"y\":649.0}]},\"inferText\":\"부가세(VAT)금액\",\"inferConfidence\":0.9977,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":601.0,\"y\":608.0},{\"x\":656.0,\"y\":608.0},{\"x\":656.0,\"y\":640.0},{\"x\":601.0,\"y\":640.0}]},\"inferText\":\"363\",\"inferConfidence\":1.0,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":56.0,\"y\":685.0},{\"x\":276.0,\"y\":682.0},{\"x\":277.0,\"y\":720.0},{\"x\":57.0,\"y\":724.0}]},\"inferText\":\"받을금액\",\"inferConfidence\":0.9993,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":505.0,\"y\":679.0},{\"x\":652.0,\"y\":676.0},{\"x\":653.0,\"y\":713.0},{\"x\":506.0,\"y\":716.0}]},\"inferText\":\"4,000\",\"inferConfidence\":0.9997,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":56.0,\"y\":721.0},{\"x\":277.0,\"y\":718.0},{\"x\":277.0,\"y\":757.0},{\"x\":56.0,\"y\":760.0}]},\"inferText\":\"내신금액\",\"inferConfidence\":0.9998,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":506.0,\"y\":715.0},{\"x\":652.0,\"y\":713.0},{\"x\":653.0,\"y\":749.0},{\"x\":506.0,\"y\":751.0}]},\"inferText\":\"4,000\",\"inferConfidence\":0.9995,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":312.0,\"y\":754.0},{\"x\":342.0,\"y\":754.0},{\"x\":342.0,\"y\":788.0},{\"x\":312.0,\"y\":788.0}]},\"inferText\":\"현\",\"inferConfidence\":1.0,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":396.0,\"y\":752.0},{\"x\":427.0,\"y\":752.0},{\"x\":427.0,\"y\":786.0},{\"x\":396.0,\"y\":786.0}]},\"inferText\":\"금\",\"inferConfidence\":1.0,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":576.0,\"y\":748.0},{\"x\":656.0,\"y\":748.0},{\"x\":656.0,\"y\":782.0},{\"x\":576.0,\"y\":782.0}]},\"inferText\":\"4,000\",\"inferConfidence\":0.9997,\"type\":\"NORMAL\",\"lineBreak\":true},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":142.0,\"y\":868.0},{\"x\":185.0,\"y\":868.0},{\"x\":185.0,\"y\":885.0},{\"x\":142.0,\"y\":885.0}]},\"inferText\":\"***\",\"inferConfidence\":0.9988,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":197.0,\"y\":862.0},{\"x\":314.0,\"y\":860.0},{\"x\":315.0,\"y\":894.0},{\"x\":198.0,\"y\":896.0}]},\"inferText\":\"재발행된\",\"inferConfidence\":0.9995,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":324.0,\"y\":858.0},{\"x\":499.0,\"y\":854.0},{\"x\":500.0,\"y\":890.0},{\"x\":324.0,\"y\":894.0}]},\"inferText\":\"영수증입니다\",\"inferConfidence\":0.9987,\"type\":\"NORMAL\",\"lineBreak\":false},{\"valueType\":\"ALL\",\"boundingPoly\":{\"vertices\":[{\"x\":510.0,\"y\":861.0},{\"x\":553.0,\"y\":861.0},{\"x\":553.0,\"y\":878.0},{\"x\":510.0,\"y\":878.0}]},\"inferText\":\"***\",\"inferConfidence\":0.9981,\"type\":\"NORMAL\",\"lineBreak\":true}]}]}";
        JSONObject json = new JSONObject(jsonStr);
        JSONObject result = (JSONObject) ((JSONArray) json.getJSONArray("images")).getJSONObject(0);
        JSONArray fields = (JSONArray) result.getJSONArray("fields");
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int count = 1;
        for (Object field: fields) {
            String text = ((JSONObject) field).getString("inferText");
            list.add(text);
            if (map.containsKey(text)) {
                int val = map.get(text);
                map.put(text, val+1);
            } else {
                map.put(text, 1);
            }
            System.out.print(text + ", ");
            if (count % 10 == 0)
                System.out.println();
            count++;
        }
        System.out.println();
        
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
        System.out.println(shop);
        
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
        System.out.println(date_);
        String dateStr = date_.substring(0,4) + "-" + date_.substring(5, 7) + "-" + date_.substring(8, 10);
        System.out.println(dateStr);
        
        Set<String> keySet = map.keySet();
        int maxVal = 0;
        for (String key: keySet) {
            if (map.get(key) > maxVal) {
                maxVal = map.get(key);
                price_ = key;
            }
        }
        System.out.println(price_);
        int price = Integer.parseInt(price_.replaceAll(",", ""));
        
        Receipt rec = new Receipt(shop, LocalDate.parse(dateStr), price);
        System.out.println(rec);
    }

}
