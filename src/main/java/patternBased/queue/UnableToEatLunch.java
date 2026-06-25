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
    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            // 1. Count the preferences of students
            int count0 = 0; // Prefers circular (0)
            int count1 = 0; // Prefers square (1)

            for (int student : students) {
                if (student == 0) count0++;
                else count1++;
            }

            // 2. Process the sandwiches
            for (int sandwich : sandwiches) {
                // Check if there's any student left who wants this sandwich type
                if (sandwich == 0) {
                    if (count0 > 0) {
                        count0--; // Student eats this sandwich
                    } else {
                        return count1; // No more circular lovers, return square lovers left
                    }
                } else {
                    if (count1 > 0) {
                        count1--; // Student eats this sandwich
                    } else {
                        return count0; // No more square lovers, return circular lovers left
                    }
                }
            }

            return 0; // All students ate
        }
    }

}
//Brute Force- the queue solution will be O(n^2)
//Worst case: O(n²) --> Because each student may rotate many times.
//SC --> O(n) for using queue
//Optimized- TC = O(n), SC = O(1)
