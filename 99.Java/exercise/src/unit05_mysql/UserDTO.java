package unit05_mysql;

import java.time.LocalDate;

public class UserDTO {
    private String uid;
    private String password;
    private String name;
    private String email;
    private LocalDate regDate;
    private int isDeleted;

    public UserDTO() {}
    public UserDTO(String password, String name, 
            String email, LocalDate regDate, int isDeleted) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.regDate = regDate;
        this.isDeleted = isDeleted;
    }
    public UserDTO(String uid, String password, String name, 
            String email, LocalDate regDate, int isDeleted) {
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.email = email;
        this.regDate = regDate;
        this.isDeleted = isDeleted;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getRegDate() {
        return regDate;
    }
    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }
    public int getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
    @Override
    public String toString() {
        return "UserDTO [uid=" + uid + ", password=" + password + ", name=" + name + ", email=" + email + ", regDate="
                + regDate + ", isDeleted=" + isDeleted + "]";
    }
}
