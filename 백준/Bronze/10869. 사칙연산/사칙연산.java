import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iVal1 = sc.nextInt();
        int iVal2 = sc.nextInt();
        System.out.printf("%d\n%d\n%d\n%d\n%d", iVal1 + iVal2, iVal1 - iVal2, iVal1 * iVal2, iVal1 / iVal2, iVal1 % iVal2);
    }
}
