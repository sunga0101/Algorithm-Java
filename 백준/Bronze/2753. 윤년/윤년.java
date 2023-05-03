
import java.util.Scanner;
// 윤년 -> 4의 배수 and !100의 배수 
// 윤년 -> 400의 배수

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iYear = sc.nextInt();
        if (iYear % 4 == 0 && iYear % 100 != 0) {
            System.out.println(1);
        } else if (iYear % 400 == 0) {
            System.out.println(1);
        } else
            System.out.println(0);
    }
}