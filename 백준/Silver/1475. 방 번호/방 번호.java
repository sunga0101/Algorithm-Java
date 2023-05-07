
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] iNum = new double[10]; // 0~9
        int roomN = sc.nextInt();
        int extra = 0;
        double cntMax = 0;

        while (roomN > 0) {
            extra = roomN % 10 ;
            roomN = roomN / 10;
            if (extra == 6 || extra == 9) {
                iNum[6]+=0.5;
            } else {
                iNum[extra]+=1;
            }
        }
        
        cntMax = Arrays.stream(iNum).max().getAsDouble();
        long res;
        res = Math.round(cntMax);
        System.out.println(res);
    }
}
