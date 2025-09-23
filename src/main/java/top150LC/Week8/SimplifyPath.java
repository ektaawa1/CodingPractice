package top150LC.Week8;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String paths[] = path.split("/");

        for(String p : paths){
            if(p.equals("") || p.equals(".")){
                continue;
            } else if(p.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        return "/" + String.join("/", stack);
    }
    public String simplifyPath1(String path) {
        Deque<String> stack = new LinkedList<>(); //works as stack
        String paths[] = path.split("/");

        for(String p : paths){
            if(p.equals("") || p.equals(".")){
                continue;
            } else if(p.equals("..")){
                if(!stack.isEmpty()){
                    stack.removeLast(); // go one dir up
                }
            } else {
                stack.addLast(p);
            }
        }
        return "/" + String.join("/", stack);
    }
    public String simplifyPath2(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue; // skip empty and "."
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop(); // go up one dir
            } else {
                stack.push(part); // valid folder name
            }
        }

        // Rebuild path
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.insert(0, "/" + dir); // prepend since stack is reversed
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}

//TC is O(n)
/**
 * Why did I use Deque<String> instead of Stack<String>?
 * In Java, Stack is very old (it extends Vector and is synchronized → slower).
 * Deque (like ArrayDeque) is preferred for stack-like behavior (push, pop, peek) because it’s faster and more modern.
 * But yes → you can absolutely use Stack<String> here and your code will work fine. It’s just about best practices.
 */
/**
 * Solution 3 Explanation-
 * Example
 * Suppose after processing path we have:
 * /a/b/c → stack = ["c", "b", "a"]
 * (because we did push in order: "a", "b", "c").
 * Step by step:
 * Start sb = ""
 * dir = "c" → insert(0, "/c") → sb = "/c"
 * dir = "b" → insert(0, "/b") → sb = "/b/c"
 * dir = "a" → insert(0, "/a") → sb = "/a/b/c"
 */
