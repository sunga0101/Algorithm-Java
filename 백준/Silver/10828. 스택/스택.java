import java.io.*;
import java.util.*;

public class Main {
    static int N, X;
    static Stack<Integer> stack = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 횟수

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            if (s.length > 1){
                X = Integer.parseInt(s[1]);
            }
            punc(s[0]);
        }

        bw.flush();
        br.close();
    }

    public static void punc(String command) throws IOException {
        switch (command){
            case "push":
                stack.push(X);
                break;
            case "pop":
                if (stack.isEmpty()) bw.write(-1+"\n");
                else bw.write(stack.pop()+"\n");
                break;
            case "size":
                bw.write(stack.size()+"\n");
                break;
            case "empty":
                if (stack.isEmpty()) bw.write(1+"\n");
                else bw.write(0+"\n");
                break;
            case "top":
                if (stack.isEmpty()) bw.write(-1+"\n");
                else bw.write(stack.peek()+"\n");
                break;
        }
    }
}
