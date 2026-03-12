package patternBased.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are given: n → number of courses labeled 1 to n, relations[i] = [prevCourse, nextCourse]
 * You can take multiple courses in the same semester if their prerequisites are satisfied.
 * Return: Minimum number of semesters needed to complete all courses. If it's impossible, return -1.
 * Input:
 * n = 3, relations = [[1,3],[2,3]]
 * Output: 2
 * Reason:
 * Sem 1 --> take course 1 and 2
 * Sem 2 --> take course 3 so output = 2
 *
 * Input:
 * n = 3
 * relations = [[1,2],[2,3],[3,1]]
 * Output: -1 since its a cycle
 */
public class ParallelCourses {
    //This is Topological Sort (BFS). Each BFS level = one semester.
    public int minimumSemesters(int n, int[][] relations) {

        // Step 1: Build graph
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        // Step 2: Indegree array
        int[] indegree = new int[n + 1];

        // Step 3: Fill graph
        for(int[] relation : relations){
            int prerequisite = relation[0];
            int nextCourse = relation[1];

            graph[prerequisite].add(nextCourse);
            indegree[nextCourse]++;
        }

        // Step 4: Queue
        Queue<Integer> queue = new LinkedList<>();

        for(int course = 1; course <= n; course++){
            if(indegree[course] == 0){
                queue.offer(course);
            }
        }

        int semesters = 0;
        int coursesCompleted = 0;

        // Step 5: BFS
        while(!queue.isEmpty()){

            int size = queue.size();
            semesters++;

            for(int i = 0; i < size; i++){

                int currentCourse = queue.poll();
                coursesCompleted++;

                for(int nextCourse : graph[currentCourse]){

                    indegree[nextCourse]--;

                    if(indegree[nextCourse] == 0){
                        queue.offer(nextCourse);
                    }
                }
            }
        }

        // Step 6: Cycle check
        if(coursesCompleted == n){
            return semesters;
        }

        return -1;
    }
}
/**
 * Dry Run
 * Input: n = 3
 * relations = [[1,3],[2,3]]
 *
 * Graph
 * 1 → 3
 * 2 → 3
 *
 * Indegree
 * 1 → 0
 * 2 → 0
 * 3 → 2
 *
 *
 * Queue [1,2]
 * Semester 1
 * Take:1,2
 * Reduce indegree:
 * 3 → 0
 * Queue: [3]
 * Semester 2
 * Take:3
 * Queue empty.
 * Answer:2
 *
 * Time Complexity
 * O(V + E) Where V = courses, E = relations
 * Space Complexity
 * O(V + E) For: graph, indegree, queue
 */
