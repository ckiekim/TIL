package ck.naver;

import java.util.Arrays;
import java.util.List;

public class Detection {
    private int label; 
    private String name;
    private double score;
    private List<Double> box;
    
    public Detection(int label, String name, double score, List<Double> box) {
        this.label = label;
        this.name = name;
        this.score = score;
        this.box = box;
    }
    @Override
    public String toString() {
        return "Detection [label=" + label + ", name=" + name + ", score=" + score + ","
                + " box=" + Arrays.toString(box.toArray()) + "]";
    }
    public int getLabel() {
        return label;
    }
    public void setLabel(int label) {
        this.label = label;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public List<Double> getBox() {
        return box;
    }
    public void setBox(List<Double> box) {
        this.box = box;
    }
}
