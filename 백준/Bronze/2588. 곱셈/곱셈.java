
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());

        sb.append(first*(second%10)+"\n");
        sb.append(first*((second%100)/10)+"\n");
        sb.append(first*(second/100)+"\n");
        sb.append(first*second+"\n");
        System.out.print(sb);
        br.close();
    }
}