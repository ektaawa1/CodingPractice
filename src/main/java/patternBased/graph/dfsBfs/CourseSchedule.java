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
 *
 * My Approach:
 * Validate the input
 * Adjacency list where index = prereq course
 *    holds list of courses that depend on it
 * Indegree array tracking dependencies count
 * Queue starts with all courses having indegree 0
 * completedCourses counter
 * TC: O(C+P), SC: O(C+P) where C is course and P is the prerequisite course
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites == null || prerequisites.length == 0){
            return true; // no prereqs = can finish all
        }

        List<Integer>[] graph = new ArrayList[numCourses];//graph is an array, each index stores a list
        //example- graph[0] → [1,2] means for course 1 & 2 the prereq is course 0.

        // Step 1: Build adjacency list 0->1, 0->2
        for(int i = 0; i< numCourses; i++){
            //graph.add(new ArrayList<>());
            graph[i] = new ArrayList<>();
        }

        // Step 2: build indegree array
        //Track Number of Prerequisites or indegree
        int[] indegree = new int[numCourses];

        //Now fill the graph
        //example- graph = [[1,2],[3],[3],[]]
        for(int p[] : prerequisites){
            int course = p[0];
            int prereq = p[1];
            graph[prereq].add(course);
            indegree[course]++;
        }

        // Step 3: add all 0-indegree courses to queue
        //Initialize a Queue
        Queue<Integer> queue = new LinkedList<>();
        //Courses with no prerequisites can be taken immediately.
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        // Step 4: BFS
        //Now process the course
        int completedCourses = 0;
        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            //we take this course
            completedCourses++;
            //now reduce neighbor indgree since we finish a course, its dependent courses lose one prerequite.
            for(int nextCourse: graph[currCourse]){
                indegree[nextCourse]--;//decrement first

                if(indegree[nextCourse] == 0){ //then check if it becomes 0
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
 * prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 *
 * [1,0] means → must take 0 BEFORE 1
 *               so 0 → 1  (0 unlocks 1)
 *
 * adj[0] = [1, 2]   (0 unlocks courses 1 and 2)
 * adj[1] = [3]      (1 unlocks course 3)
 * adj[2] = [3]      (2 unlocks course 3)
 * adj[3] = []       (3 unlocks nothing)
 *
 * And indegree:
 * indegree[0] = 0  (no prerequisites)
 * indegree[1] = 1  (needs course 0)
 * indegree[2] = 1  (needs course 0)
 * indegree[3] = 2  (needs courses 1 AND 2)
 *
 * =======================================================================================================
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Build graph:
 * 0 → [1]
 * 1 → [0]
 * Start DFS from 0:
 * Seen = {0} → DFS(1) → Seen = {0,1} → DFS(0) → already in seen → cycle → return false 🚨
 * So output = false.
 */
