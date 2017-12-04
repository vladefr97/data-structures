package seminar1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) ) ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 * <p>
 * Считаем, что операции деления на ноль отсутствуют
 */
public class Solver {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char TIMES = '*';
    private static final char DIVISION = '/';
    private static Stack<String> stringStack = new Stack<>();
    private static Stack<Double> doubleStack = new Stack<>();


    private static double evaluate(String[] values) {
        /* TODO: implement it */
        // Double.valueOf(values[i])
        values = infixToPostfix(values);
        int arrayLength = values.length;
        double a;
        double b;
        for (int i = 0; i < arrayLength; i++) {
            switch (values[i]) {
            case "+":
                a = doubleStack.pop();
                b = doubleStack.pop();
                double c = a + b;
                doubleStack.push(c);

                break;

            case "-":
                a = doubleStack.pop();
                b = doubleStack.pop();
                doubleStack.push(b - a);
                break;

            case "*":
                a = doubleStack.pop();
                b = doubleStack.pop();
                doubleStack.push(a * b);
                break;
            case "/":
                a = doubleStack.pop();
                b = doubleStack.pop();
                doubleStack.push(b / a);
                break;
            case "":
                break;

            default:
                doubleStack.push(Double.parseDouble(values[i]));
                break;

            }
        }
        return doubleStack.pop();
    }

    private static String[] infixToPostfix(String[] stringArray) {


        int n = stringArray.length;
        String str = "";
        String symbol = "";
        for (int i = 0; i < n; i++) {
            switch (stringArray[i]) {
            case "(":
                stringStack.push("(");
                break;
            case ")":
                while (symbol != "(" && stringStack.size() != 0) {
                    symbol = stringStack.pop();
                    if (symbol != "(") {
                        str += " " + symbol;
                    }
                }
                symbol = "";
                //while ()
                break;

            case "+":
                stringStack.push("+");
                break;

            case "*":
                stringStack.push("*");
                break;
            case "-":
                stringStack.push("-");
                break;
            case "/":
                stringStack.push("/");
                break;
            default:
                str += " " + stringArray[i];
                break;

            }
        }
        if (stringStack.size() != 0) {
            str += " " + stringStack.pop();
        }
        return str.split(" ");
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {


                System.out.println(evaluate(sequence.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
