
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int result;
        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            int inputA = Integer.parseInt(s[0]);
            int inputB = Integer.parseInt(s[1]);
            result = 1;
            for (int j = 0; j < inputB; j++) {
                result = (result*inputA)%10;
            }
            if(result == 0) {
                System.out.println(10);
            }else {
                System.out.println(result);
            }
        }
    }
}
