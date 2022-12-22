import java.time.LocalDateTime;

public class Date {

    public static void main(String[] args) {
        String now = LocalDateTime.now().toString().substring(0,22);
        System.out.println(now.replaceAll("[-T:.]", ""));
        
        String fn = "cat.jpg";
        int idx = fn.lastIndexOf('.');
        System.out.println(fn.substring(idx));
    }

}
