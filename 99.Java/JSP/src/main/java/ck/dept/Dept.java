package ck.dept;

public class Dept {
    private int did;
    private String name;
    
    public Dept() { }
    public Dept(int did, String name) {
        this.did = did;
        this.name = name;
    }
    public int getDid() {
        return did;
    }
    public void setDid(int did) {
        this.did = did;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Dept [did=" + did + ", name=" + name + "]";
    }
}
