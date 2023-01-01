package ck.naver;

import java.util.List;

public class CsvTest {

    public static void main(String[] args) {
        CsvUtil cu = new CsvUtil();
        List<List<String>> df = cu.readCsv("c:/Temp/pima-indians-diabetes.csv", ",", 9);
        System.out.println(df.size());
        
        cu.writeCsv("c:/Temp/pima.csv", df);
    }

}
