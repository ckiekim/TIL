package unit04;

public class SelfNumber {

    public static void main(String[] args) {
        int[] selfNum = new int[100];
        for (int n = 1; n < 100; n++) {
            int dn = n;
            while(dn < 100) {
                dn = dn + dn / 10 + dn % 10;
                if (dn < 100)
                    selfNum[dn] = 1;
            }
        }
        for (int i = 1; i < 100; i++) {
            if (selfNum[i] == 0)
                System.out.println(i);
        }
    }

}
