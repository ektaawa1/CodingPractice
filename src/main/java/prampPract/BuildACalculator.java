package prampPract;

import java.util.ArrayDeque;
import java.util.Deque;

public class BuildACalculator {
    public static double calc(String expr) {
        // your code goes here
        double result = 0;
        double num = 0;
        double lastNum = 0;
        char op = '+'; //default value

        for(int i = 0; i< expr.length(); i++){
            char ch = expr.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            if((!Character.isDigit(ch) && ch != ' ') || i == expr.length() -1){
                switch(op){
                    case '+':
                        result += lastNum;
                        lastNum = num;
                        break;
                    case '-':
                        result += lastNum;
                        lastNum = -num;
                        break;
                    case '*':
                        lastNum *= num;
                        break;
                    case '/':
                        lastNum /= num;
                        break;
                }
                op = ch;
                num = 0;
            }
        }
        result += lastNum;
        return result;
    }

    public static double calcStack(String expr) { // "5/2-2*3"
        // your code goes here
        Deque<Double> stack = new ArrayDeque<>(); // stack intermediate results store karega.
        double num = 0; // num current number store karega.
        double result = 0;
        char op = '+'; // op previous operator track karega. Default '+' hai taaki pehla number stack mei push ho jaye.

        for(int i = 0; i<expr.length(); i++){
            char ch = expr.charAt(i);

            if(Character.isDigit(ch)){
                //for multi-digit numbers eg: "123 + 45" so each char will be read- 0*10 + 1 = 1, 1*10 + 2 = 12, 12*10 + 3 = 123
                num = num * 10 + (ch-'0'); //[5], [2.5], [2.5, -2], [2.5, -6]
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == expr.length() - 1){
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                op = ch;
                num = 0;
            }
        }
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        // debug your code below
        System.out.println(calc("1 + 1"));
    }
}

/**
 * calc("1 + 1")       # => 2
 * calc("5 - 1 - 1")   # => 3
 * calc("84 / 1 / 2")  # => 42
 * calc("5/2 - 2*3")   # => -3.5
 */

/**
 * We want to build a simple calculator that can solve arithmetic expressions like
 * 2 + 2 or 4 * 5 - 10 * 2. Write a function calc(expr) that accepts a string as input and
 * returns the answer as a number. It should follow the normal order of operations and support
 * addition, subtraction, multiplication, and division. Don't worry about parentheses or improperly
 * formatted strings.
 */
/**
 * My Understanding-
 * agar character number hai toh usko stack mei push kardo warna agar operator hai toh switch case
 * ke hisab se manipulate karo. Starting mei num ko 0 initialize kiya hai, aur default operator is '+'.
 * Jab switch case khatam ho, usse pehle operator variable ko update karo aur num ko phir se default set
 * kardo for next iteration. Jab loop complete ho jaye to stack se ek ek element pop karo aur result me
 * add karte jao.
 */
