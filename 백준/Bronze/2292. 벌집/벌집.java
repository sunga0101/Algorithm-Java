import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());
        int sum = 1;
        int k = 1;
        while (sum < target){
            sum = sum+k*6;
            k++;
        }

        bw.write(k+"");
        bw.flush();
        br.close();
    }
}