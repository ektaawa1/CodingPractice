package patternBased.graph.dfsBfs;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
 * take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them. If it is impossible to finish all courses,
 * return an empty array.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * We use Kahn’s Algorithm (BFS) for topological sorting:
 * Build a graph and an array to store the in-degree (number of prerequisites) of each course.
 * Start with all courses having in-degree = 0, i.e., no prerequisites.
 * Process each course, reduce the in-degree of its neighbors, and if any neighbor’s in-degree becomes zero, add it to the processing queue.
 * If we can process all nodes, return the order; otherwise, return an empty array.
 * Kahn’s Algorithm is basically:
 * “Keep peeling off the courses that are unlocked until no more can be peeled.
 * If you peel all → success; otherwise → cycle.”
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create graph
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        // Step 2: Create indegree array
        int[] indegree = new int[numCourses];

        // Step 3: Build graph + indegree
        for(int[] prereq : prerequisites){
            int course = prereq[0];
            int prerequisiteCourse = prereq[1];

            graph[prerequisiteCourse].add(course);
            indegree[course]++;
        }
        // Step 4: Add courses with 0 prerequisites to queue
        Queue<Integer> queue = new LinkedList<>();

        for(int course = 0; course < numCourses; course++){
            if(indegree[course] == 0){
                queue.offer(course);
            }
        }

        // Step 5: Store order
        int[] courseOrder = new int[numCourses];
        int index = 0;

        // Step 6: BFS
        while(!queue.isEmpty()){

            int currentCourse = queue.poll();

            courseOrder[index++] = currentCourse;

            for(int nextCourse : graph[currentCourse]){

                indegree[nextCourse]--;

                if(indegree[nextCourse] == 0){
                    queue.offer(nextCourse);
                }
            }
        }

        // Step 7: Check if all courses finished
        if(index == numCourses){
            return courseOrder;
        }

        return new int[0];
    }
}
//Time complexity: O(V+E)
//V = number of courses (vertices)
//E = number of prerequisites (edges)
//Space complexity: O(V+E)
//For the adjacency list and in-degree array
/**
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]], Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 *
 * Example 2:
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]], Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 *
 * Example 3:
 * Input: numCourses = 1, prerequisites = [], Output: [0]
 */

/**
 * Example Walkthrough
 *
 * Suppose: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]   That means:
 * 0 → 1, 0 → 2, 1 → 3, 2 → 3
 * Step 1: inDegree
 * inDegree = [0,1,1,2]
 * Course 0 needs nothing → inDegree=0
 * Course 1 needs 0 → inDegree=1
 * Course 2 needs 0 → inDegree=1
 * Course 3 needs 1 & 2 → inDegree=2
 *
 * Step 2: Queue
 * queue = [0]
 *
 * Step 3: Process
 * Take 0 → order = [0]
 * Reduce inDegree[1]=0 → add 1
 * Reduce inDegree[2]=0 → add 2
 * → queue = [1,2]
 * Take 1 → order = [0,1]
 * Reduce inDegree[3]=1 (not zero yet)
 * Take 2 → order = [0,1,2]
 * Reduce inDegree[3]=0 → add 3
 * → queue = [3]
 * Take 3 → order = [0,1,2,3]
 * Step 4: Done → valid order.
 */
