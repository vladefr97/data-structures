package seminar1;

import seminar1.collections.LinkedStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. пустая строка — правильная скобочная последовательность;
 * 2. правильная скобочная последовательность,
 * взятая в скобки одного типа — правильная скобочная последовательность;
 * 3. правильная скобочная последовательность,
 * к которой приписана слева или справа правильная скобочная последовательность
 * — тоже правильная скобочная последовательность.
 */
public class ParenthesesSequenceExt {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    // sequence = "()()" | "(({}[]))[[[" | "{}" | ...
    private static boolean isBalanced(String sequence) {
        /* TODO: implement it */
        LinkedStack<Character> linkedStack = new LinkedStack<>();
        int n = sequence.length();
        char ch;
        for (int i = 0; i < n; i++) {
            ch = sequence.charAt(i);
            switch (ch){
                case LEFT_PAREN:
                    linkedStack.push(ch);
                    break;
                case RIGHT_PAREN:
                    if(linkedStack.isEmpty() || linkedStack.pop() != LEFT_PAREN) return false;
                    break;
                case LEFT_BRACE:
                    linkedStack.push(ch);
                    break;
                case RIGHT_BRACE:
                    if(linkedStack.isEmpty() || linkedStack.pop() != LEFT_BRACE) return false;
                    break;
                case LEFT_BRACKET:
                    linkedStack.push(ch);
                    break;
                case RIGHT_BRACKET:
                    if(linkedStack.isEmpty() || linkedStack.pop() != LEFT_BRACKET) return false;
                    break;
            }

        }

        return linkedStack.isEmpty();
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(isBalanced(sequence) ? "YES" : "NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
