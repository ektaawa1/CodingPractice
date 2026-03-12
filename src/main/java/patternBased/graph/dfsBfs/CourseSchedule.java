package patternBased.graph.dfsBfs;

//207. Course Schedule

/**
 * You have numCourses labeled from 0 to numCourses - 1.
 * prerequisites[i] = [a, b] → to take course a, you must first take course b.
 * Question: Can you finish all courses?
 * Essentially: detect if the directed graph has a cycle.
 */

import java.util.*;

/**
 * Intuition
 * Treat courses as nodes.
 * Treat prerequisites as directed edges b → a.
 * If the graph has a cycle, you cannot finish all courses.
 * If no cycle, all courses can be finished.
 *
 * Two common approaches:
 * DFS + Cycle Detection
 * BFS + Kahn’s Algorithm (Topological Sort)
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];//graph is an array, each index stores a list
        //example- graph[0] → [1,2] means for course 1 & 2 the prereq is course 0.

        // Step 1: Build adjacency list 0->1, 0->2
        for(int course = 0; course< numCourses; course++){
            //graph.add(new ArrayList<>());
            graph[course] = new ArrayList<>();
        }
        //Track Number of Prerequisites or indegree
        int[] indegree = new int[numCourses];

        //Now fill the graph
        //example- graph = [[1,2],[3],[3],[]]
        for(int prereq[] : prerequisites){
            int course = prereq[0];
            int prerequisiteCourse = prereq[1];
            graph[prerequisiteCourse].add(course);
            indegree[course]++;
        }

        //Initialize a Queue
        Queue<Integer> queue = new LinkedList<>();
        //Courses with no prerequisites can be taken immediately.
        for(int course = 0; course < numCourses; course++){
            if(indegree[course] == 0){
                queue.offer(course);
            }
        }
        //Now process the course
        int completedCourses = 0;
        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            //we take this course
            completedCourses++;
            //now reduce neighbor indgree since we finish a course, its dependent courses lose one prerequite.
            for(int nextCourse: graph[currCourse]){
                indegree[nextCourse]--;

                if(indegree[nextCourse] == 0){
                    queue.offer(nextCourse);
                }
            }
        }
        return completedCourses == numCourses;
    }
}
/**
 * | Metric | Value                                               |
 * | ------ | --------------------------------------------------- |
 * | Time   | O(V + E) → traverse all courses & prerequisites     |
 * | Space  | O(V + E) → adjacency list + recursion stack / queue |
 */

/**
 * Example B
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 *
 * Start: preReqs = [ [], [], [], [] ]
 * [1,0]: → [ [], [0], [], [] ]
 * [2,0]: → [ [], [0], [0], [] ]
 * [3,1]: → [ [], [0], [0], [1] ]
 * [3,2]: → [ [], [0], [0], [1,2] ]
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Build graph:
 * 0 → [1]
 * 1 → [0]
 * Start DFS from 0:
 * Seen = {0} → DFS(1) → Seen = {0,1} → DFS(0) → already in seen → cycle → return false 🚨
 * So output = false.
 */
