package ck.cookie;

public class Users {
    private String uid;
    private String pwd;
    private String name;
    
    public Users(String uid, String pwd, String name) {
        this.uid = uid;
        this.pwd = pwd;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users [uid=" + uid + ", pwd=" + pwd + ", name=" + name + "]";
    }
}
