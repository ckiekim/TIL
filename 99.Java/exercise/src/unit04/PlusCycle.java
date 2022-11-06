package unit04;

import java.util.Scanner;

public class PlusCycle {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("1~99 정수> ");
        int num = scan.nextInt();
        scan.close();
        
        int originalNum = num;
        int cycle = 0;
        while (true) {
            cycle++;
            int digit10 = (num < 10) ? 0 : num / 10;
            int digit1 = num % 10;
            num = digit1 * 10 + (digit10 + digit1) % 10;
            System.out.println(num +", "+digit10+", "+digit1);
            if (num == originalNum)
                break;
        }
        System.out.println(cycle);
    }

}
