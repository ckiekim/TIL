package ck.naver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtil {

    public List<List<String>> readCsv(String filename) {
        return readCsv(filename, ",", 0);
    }
    
    public List<List<String>> readCsv(String filename, String separator) {
        return readCsv(filename, separator, 0);
    }
    
    public List<List<String>> readCsv(String filename, String separator, int skipLine) {
        List<List<String>> csvList = new ArrayList<List<String>>();
        File csv = new File(filename);
        BufferedReader br = null;
        String line = "";
        int lineNo = 0;
        
        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                if (skipLine > lineNo++)
                    continue;
                List<String> aLine = new ArrayList<String>();
                String[] lineArray = line.split(separator);
                aLine = Arrays.asList(lineArray);
                csvList.add(aLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvList;
    }
    
    public void writeCsv(String filename, List<List<String>> dataList) {
        writeCsv(filename, dataList, ",");
    }
    
    public void writeCsv(String filename, List<List<String>> dataList, String separator) {
        File csv = new File(filename);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(csv));
//            bw = new BufferedWriter(new FileWriter(csv, true));     // append
            for (List<String> data: dataList) {
                String line = "";
                for (int i=0; i<data.size(); i++) {
                    line += data.get(i);
                    if (i < data.size() - 1)
                        line += ",";
                }
                bw.write(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.flush();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
