
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<Integer>();
        int secondN = 0;
        int iCnt = Integer.parseInt(br.readLine());
        for (int i = 1; i <= iCnt; i++) {
            q.offer(i);
        }

        while(q.size() > 1) {
            q.poll();
            secondN = q.poll();
            q.offer(secondN);

        }
        System.out.println(Math.max(secondN, 1)); // 1일 경우 고려
    }
}