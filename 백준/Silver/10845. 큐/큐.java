
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> q = new LinkedList<Integer>();
        int lastNum=0;
        int iNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < iNum; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                // 정수 추가 연산
                case "push":
                    lastNum=Integer.parseInt(st.nextToken());
                    q.offer(lastNum);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append(-1+"\n");
                    } else {
                        sb.append(q.poll()+"\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()+"\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1+"\n");
                    }
                    else {
                        sb.append(0+"\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append(-1+"\n");

                    }
                    else {
                        sb.append(q.peek()).append("\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append(-1+"\n");
                    }
                    else {
                        sb.append(lastNum+"\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}