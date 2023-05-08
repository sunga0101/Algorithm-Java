
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int iCnt = Integer.parseInt(br.readLine());

        // 한 케이스에 대해서
        for (int j = 0; j < iCnt; j++) {
        String pwd = br.readLine(); // <<BP<A>>Cd-       ThIsIsS3Cr3t
        Stack<Character> stLeft = new Stack<Character>(); // 커서 앞
        Stack<Character> stRight = new Stack<Character>(); // 커서 뒤

            for (int i = 0; i < pwd.length(); i++) {

                switch (pwd.charAt(i)) {
                    case '<':
                        if(stLeft.isEmpty()) break;
                        stRight.push(stLeft.pop());
                        break;
                    case '>':
                        if(stRight.isEmpty()) break;
                        stLeft.push(stRight.pop());
                        break;
                    case '-':
                        if(stLeft.isEmpty()) break;
                        stLeft.pop();
                        break;
                    default:
                        stLeft.push(pwd.charAt(i));
                        break;
                }}



        while (!stLeft.isEmpty()) {
            stRight.push(stLeft.pop());
        }

        while (!stRight.isEmpty()) {
            bw.write(stRight.pop());
        }
        bw.newLine();
    }
        bw.flush();
        bw.close();

    }}
