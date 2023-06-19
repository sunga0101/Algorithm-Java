import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 반복횟수
        for (int i = 0; i < T; i++) {

            String[] s = br.readLine().split(" ");
            int H = Integer.parseInt(s[0]);
            int W = Integer.parseInt(s[1]);
            int N = Integer.parseInt(s[2]);

            int floor = 0;// 층수
            int room = 0; // 호수

            if (N%H != 0){
                floor = (N%H)*100;
                room = (N/H)+1;
            }
            else {
                floor = H*100;
                room = (N/H);
            }

            bw.write(floor+room+"\n");
        }
        bw.flush();
        br.close();
    }
}
