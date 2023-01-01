package ck.naver;

public class Place {
    private double lat;
    private double lng;
    private String type;
    private String size;
    private String label;
    public Place(double lat, double lng, String type, String size, String label) {
        this.lat = lat;
        this.lng = lng;
        this.type = type;
        this.size = size;
        this.label = label;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
}
