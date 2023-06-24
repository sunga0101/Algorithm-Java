import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum=1;
        int N = Integer.parseInt(br.readLine());
        if (N>0){
        for (int i= N; i>= 1; i--){
            sum *= i;}}
        else sum=1;
        System.out.print(sum);
        }

    }
