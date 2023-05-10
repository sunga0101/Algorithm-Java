
import java.io.*;
import java.util.*;


public class Main {

    public static Stack<Character> stack;

    public static int isGood(String word) {
        stack = new Stack<>();
        if (word.length() % 2 == 1) { // 1글자 문자 이면
            return 0;
        }
        
        stack.push(word.charAt(0)); // 0번 인덱스 값 스택에 넣기
        for (int i = 1; i < word.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(word.charAt(i));
            } else {
                if (stack.peek() == word.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(word.charAt(i));
                }
            }
        }
        if (stack.isEmpty())
            return 1;
        else 
            return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res = 0;
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            res += isGood(word);
        }
        System.out.println(res);

    }
}

