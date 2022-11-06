package unit04;

public class Reverse {

    public static void main(String[] args) {
        String str = "안녕하세요????";
        System.out.println(reverse(str));
        System.out.println(count(str, "?"));
        String[] arr = {"감", "밤", "귤"};
        System.out.println(join(arr));
    }

    static String reverse(String src) {
        int len = src.length();
        String dst = "";
        for (int i=1; i<=len; i++) {
            dst += src.charAt(len - i);
        }
        return dst;
    }
    
    static int count(String src, String target) {
        int len = src.length();
        String eliminated = src.replace(target, "");
        System.out.println(eliminated);
        return len - eliminated.length();
    }
    
    static String join(String[] strArr) {
        String dst = "";
        for (String str : strArr)
            dst += str + " ";
        return dst;
    }
}
