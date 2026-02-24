package patternBased.queue;
//1700. Number of Students Unable to Eat Lunch

import java.util.LinkedList;
import java.util.Queue;

/**
 * Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
 * Output: 0
 * Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * Output: 3
 */
public class UnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        //0 is circular sandwich and 1 is square sandwich
        //1 queue for Students
        //return the no. of students that are unable to eat

        Queue<Integer> q = new LinkedList<>();
        for(int student: students){
            q.offer(student);//pushing students to a queue
        }
        //if using stack for sandwiches, do this way- reverse way
//        Stack<Integer> stack = new Stack<>();
//        for(int i = sandwiches.length-1; i >= 0; i--)
//            stack.push(sandwiches[i]);

        int i = 0;
        int rotations = 0; //count of failed attempts- How many consecutive students refused the current sandwich?
        while(!q.isEmpty() && rotations < q.size()){
            if(q.peek() == sandwiches[i]){
                q.poll();
                i++;
                rotations = 0; //reset it, We start fresh for the next sandwich as Previous refusals don’t matter anymore
            } else {
                q.offer(q.poll());
                rotations++;
            }
        }
        return q.size();
    }
    //Optimized Solution- Use Counting Method
    //Count students who want circular (0) and square (1)
    //Iterate sandwiches from top
    //If sandwich type has students available → decrement count
    //Else → stop and return remaining students
    public int countStudentsOptimized(int[] students, int[] sandwiches) {

        int ones = 0; //count of students who prefer type1
        int zeros = 0; //count of students who prefer type0

        for (int stud : students) {
            if(stud == 0){
                zeros++;
            }else {
                ones++;
            }
        }

        for (int s : sandwiches) {

            if (s == 0) { // if sandwich is of type0
                if(zeros == 0){ // if no student wants a type0 sandwich
                    return ones;
                }
                zeros--;
            }else {
                if(ones == 0){
                    return zeros;
                }
                ones--;
            }
        }

        return 0;
    }
}
//Brute Force- the queue solution will be O(n^2)
//Worst case: O(n²) --> Because each student may rotate many times.
//SC --> O(n) for using queue
//Optimized- TC = O(n), SC = O(1)
