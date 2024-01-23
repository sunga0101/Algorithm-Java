

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int idx = s.length();

        LinkedList<String> list = new LinkedList<>();
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for (int i=0;i<s.length();i++){
            left.push(String.valueOf(s.charAt(i)));
        }

        int T = Integer.parseInt(br.readLine()); // 명령어 개수
        for (int i=0; i<T;i++){
            String[] command = br.readLine().split(" ");
            if (command[0].equals("P"))  {
                left.push(command[1]);
            }
            else if (command[0].equals("L"))  {
                if (!left.isEmpty()){
                    right.push(left.pop());
                }
            }
            else if (command[0].equals("D"))  {
                if (!right.isEmpty()){
                    left.push(right.pop());
                }
            }
            else if (command[0].equals("B"))  {
                if (!left.isEmpty()){
                    left.pop();
                }
            }
        }


        while(!left.isEmpty())
            right.push(left.pop());

        while(!right.isEmpty())
            bw.write(right.pop()+"");


        bw.flush();
        br.close();

    }
}