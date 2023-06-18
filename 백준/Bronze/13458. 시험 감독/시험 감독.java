
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 시험장 개수
        int[] classPeople = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            classPeople[i] = Integer.parseInt(s[i]);
        }
        s = br.readLine().split(" ");
        int head = Integer.parseInt(s[0]);
        int assistant = Integer.parseInt(s[1]);

        long result = 0;
        for (int i = 0; i < N; i++) {
            result++; // head
            int people = classPeople[i]-head;
            if (people <= 0) continue;
            result+=(people/assistant);
            if (people % assistant != 0) {
                result++;
            }

        }
        bw.write(result+"");
        bw.flush();
        br.close();
    }
}
