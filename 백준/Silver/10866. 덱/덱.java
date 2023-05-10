import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int iRepeat = Integer.parseInt(br.readLine());
        int last = 0;

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < iRepeat; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front":
                    last = Integer.parseInt(st.nextToken());
                    dq.offerFirst(last);
                    break;
                case "push_back":
                    last = Integer.parseInt(st.nextToken());
                    dq.offerLast(last);
                    break;
                case "pop_front":
                    if (dq.isEmpty()){
                        sb.append(-1+"\n");
                    }else{
                    sb.append(dq.pollFirst()+"\n");}
                    break;
                case "pop_back" :
                    if (dq.isEmpty()){
                        sb.append(-1+"\n");
                    }else{
                        sb.append(dq.pollLast()+"\n");}
                    break;
                case "size":
                    sb.append(dq.size()+"\n");
                    break;
                case "empty":
                    if (dq.isEmpty()){
                        sb.append(1+"\n");
                    }else{
                        sb.append(0+"\n");}
                    break;
                case "front":
                    if (dq.isEmpty()){
                        sb.append(-1+"\n");
                    }else{
                        sb.append(dq.peekFirst()+"\n");}
                    break;
                case "back":
                    if (dq.isEmpty()){
                        sb.append(-1+"\n");
                    }else{
                        sb.append(dq.peekLast()+"\n");}
                    break;
            }
        }
        System.out.println(sb);
    }
}
