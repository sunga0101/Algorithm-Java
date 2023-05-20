

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb.append((1<<n)-1).append("\n"); // 일반항 2의 n승 - 1(초항)
        move(1,3,n);
        System.out.println(sb);
    }

    public static void move(int a, int b, int n){
        if(n==1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        move(a, 6-a-b, n-1);  // 1~k-1을 1->2에옮겨두고
        sb.append(a).append(" ").append(b).append("\n");  // k을 1->3에옮기고
        move(6-a-b,b,n-1);   // 1~k-1을 2->3에옮김
    }
}
