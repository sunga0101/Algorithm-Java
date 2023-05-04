
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc= new Scanner(System.in);
        int iSum = 0;
        int sumOfLiers = 0;
        int[] iNum = new int[9];
        for (int i = 0; i < 9; i++) {
            iNum[i] = sc.nextInt();
            iSum += iNum[i];
        }
        sumOfLiers = iSum - 100;

        // 두명의 키 합이 전체-100과 동일한 사람을 찾는다
        loop:
        for (int i = 0; i < iNum.length-1; i++) {
            for (int j = i+1; j < iNum.length; j++) {
                if (iNum[i]+iNum[j]==sumOfLiers) {
                    iNum[i]=0;
                    iNum[j]=0;
                    break loop;
//                  System.out.printf("%d번과 %d번은 난쟁이가 아닙니다\n", i,j);
                }
            }
        }
        //난쟁이만 출력
        Arrays.sort(iNum);
        for (int i = 0; i < iNum.length ; i++) {
            if (iNum[i] != 0)
                System.out.printf("%d\n",iNum[i]);
        }
    }
}