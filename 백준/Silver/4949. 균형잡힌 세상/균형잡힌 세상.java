
import java.io.*;
import java.util.*;

public class Main {
    public static Stack<Character> stack;
    public static String yesOrNo(String word) {
        stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '('||word.charAt(i) == ')'||
                    word.charAt(i) == '['||word.charAt(i) == ']')
            {
                if (stack.isEmpty())  {    stack.push(word.charAt(i));   }
                else { // !isEmpty
                    if (stack.peek()=='(' && word.charAt(i) ==')') {
                        stack.pop();
                    }
                    else if (stack.peek()=='[' && word.charAt(i) ==']'){
                        stack.pop();
                    }
                    else {    stack.push(word.charAt(i));
                    }
                }
            }
        }
        if (stack.isEmpty())
            return "yes";
        else
            return "no";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String word = br.readLine();
            if(word.equals("."))  break;
            System.out.println(yesOrNo(word));
        }
    }
}