package seminar1;

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
        int roundBraket = 0;
        int squareBraket = 0;
        int figureBraket = 0;
        int n = sequence.length();
        for (int i = 0; i < n; i++) {
            if (sequence.charAt(i) == LEFT_PAREN) {
                roundBraket++;
            }
            if (sequence.charAt(i) == RIGHT_PAREN) {
                roundBraket--;
            }
            if (sequence.charAt(i) == LEFT_BRACE) {
                figureBraket++;
            }
            if (sequence.charAt(i) == RIGHT_BRACE) {
                figureBraket--;
            }
            if (sequence.charAt(i) == LEFT_BRACKET) {
                squareBraket++;
            }
            if (sequence.charAt(i) == RIGHT_BRACKET) {
                squareBraket--;
            }

        }

        return (roundBraket == 0 && squareBraket == 0 && figureBraket == 0);
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
