package otheTopicsExample;

import java.util.ArrayList;
import java.util.Stack;

//Input: strs = ["flower","flow","flight"]
//Output: "fl"
public class MyTodayTest {
    public static void main(String args[]){
        ArrayList<String> strs = new ArrayList<>();
        strs.add("flower");
        strs.add("flow");
        strs.add("flight");
        String output = "";
        Stack<String> stack = new Stack<>();
        //String curr = strs.get(0);//flower
        for(int i = 0; i<strs.size(); i++){
            while(!stack.isEmpty()){//flow
                //do something
                String curr = strs.get(i);//flight
                int len = curr.length();//6
                String newS = "";
                if(len < stack.peek().length()) {//6
                     newS = stack.pop().substring(0, len);
                } else {
                    curr = curr.substring(0,stack.peek().length());
                }

//                if(newS.equals(curr)){
//                    output = newS;//flow
//                    stack.push(newS);//flow
//                }
            }
            stack.push(strs.get(i));//flower
        }
        System.out.print(output);
    }
}
