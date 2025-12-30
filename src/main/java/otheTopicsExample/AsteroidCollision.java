package otheTopicsExample;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        //Stack
        Stack<Integer> stack = new Stack<>();
        for(int a: asteroids){
            boolean destroyed = false;
            while(!stack.isEmpty() && a < 0 && stack.peek() > 0){
                int top = stack.peek();

                if(Math.abs(top)< Math.abs(a)){
                    stack.pop();
                }else if(Math.abs(top) == Math.abs(a)){
                    stack.pop();
                    destroyed = true;
                    break;
                }else {
                    destroyed = true;
                    break;
                }
            } //end of while loop
            if(!destroyed){
                stack.push(a);
            }
        } //end of for loop
        int[] result = new int[stack.size()];
        for(int i = result.length-1; i>=0; i--){
            result[i] = stack.pop();//LIFO
        }
        return result;
    }
}
/**
 Collision happens-
 right-moving asteroid  (+)
 followed by
 left-moving asteroid   (-)
 Other scenarios-
 + + → moving same direction → no collision

 - - → moving same direction → no collision

 - + → moving away → no collision
 */

//TC = O(n), SC = O(n)
