
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iVal1 = sc.nextInt();
        int iVal2= sc.nextInt();
        int iVal3 = sc.nextInt();

        // 같은 눈 3개
        if (iVal1== iVal2 && iVal2==iVal3) {
            System.out.println(10000+iVal1*1000);
        }

        // 같은 눈 2개
        if (iVal1== iVal2 && iVal2!=iVal3) {
            System.out.println(1000+iVal1*100);
        }
        else if (iVal2== iVal3 && iVal3!=iVal1) {
            System.out.println(1000+iVal2*100);
        }else if (iVal1== iVal3 && iVal3!=iVal2) {
            System.out.println(1000+iVal1*100);
        }

        // 다른 3개
        if (iVal1!=iVal2 && iVal2!=iVal3 && iVal3!=iVal1) {
            int maxVal = Math.max(iVal1, iVal2);
            System.out.println(Math.max(maxVal,iVal3)*100);
        }

    }
}
