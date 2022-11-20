package unit05_mysql;

import org.mindrot.jbcrypt.BCrypt;

/**
 * http://www.java2s.com/example/jar/j/download-jbcrypt04jar-file.html
 * $2a (bcrypt 버전 정보)
 * $10 (라운드 정보)
 * salt + hashed
 * 공격자가 암호를 유추할 수 없도록, 
 * 평문 데이터에 의미 없는 데이터를 뿌려 넣는데, 이것을 salt라고 함.
 */
public class BCryptExample {

    public static void main(String[] args) {
        String password = "1234asdf";
        String cryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(cryptedPassword);
        System.out.println(cryptedPassword.length());
        
        if (BCrypt.checkpw(password, cryptedPassword))
            System.out.println("true");
        else
            System.out.println("false");
        
        String cryptedPassword2 = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(cryptedPassword2);
        
        String salt = BCrypt.gensalt();
        System.out.println(salt.length() + ": " + salt);
        String salt2 = BCrypt.gensalt();
        System.out.println(salt2.length() + ": " + salt2);
        
        String cp = BCrypt.hashpw(password, salt);
        String cp2 = BCrypt.hashpw(password, salt);
        System.out.println(cp.equals(cp2));
    }

}
