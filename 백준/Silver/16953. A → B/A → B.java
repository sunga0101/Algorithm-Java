import java.io.*;
/*
* B->A로 생각하면,
* 과정 중의 수는 모두 짝수이거나 %10 == 1 인 수이다
*
* */

public class Main {
    static int A, B, count;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        A = Integer.parseInt(s[0]); // 횟수
        B = Integer.parseInt(s[1]); // 횟수

        func();
    }

    public static void func(){

        while(true){
            if (B < A) {
                System.out.println(-1);
                break;
            }
            if (B == A) {
                System.out.println(count+1);
                break;
            }
            // 나머지 경우는 B가 A보다 큰 정상 진행상황
            if (B%10==1){
                B /= 10;
                count++;
            }
            else if (B%2==0){
                B /= 2;
                count++;
            }
            else {
                System.out.println(-1);
                break;
            }
        }
    }
}
