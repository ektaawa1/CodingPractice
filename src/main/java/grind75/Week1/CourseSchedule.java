package grind75.Week1;

//207. Course Schedule

/**
 * You have numCourses labeled from 0 to numCourses - 1.
 * prerequisites[i] = [a, b] → to take course a, you must first take course b.
 * Question: Can you finish all courses?
 * Essentially: detect if the directed graph has a cycle.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        List<List<Integer>> prereqs = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        // Step 1: Build adjacency list
        for(int i = 0; i<numCourses; i++){
            prereqs.add(new ArrayList<>());
        }

        for(int pair[] : prerequisites){
            int course = pair[0];
            int p = pair[1];
            prereqs.get(course).add(p);
        }

        // Step 2: Cycle detection using DFS + seen set
        for(int i = 0; i<numCourses; i++){
            if(hasCycle(i, seen, prereqs)){
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int course, HashSet<Integer> seen, List<List<Integer>> prereqs){
        // If this course is already in the current DFS path, we found a back-edge → cycle.
        if(seen.contains(course)) return true; //cycle detected

        // If this course has no prerequisites (either originally or cleared earlier),
        // then from this node there can’t be a cycle. Early exit.
        if(prereqs.get(course).isEmpty()) return false; // cycle not detected as already processed

        // Enter this node in the current DFS path (push onto recursion stack).
        seen.add(course);

        // Explore all prerequisites. If any path reports a cycle, bubble it up.
        for(int p : prereqs.get(course)){
            if(hasCycle(p, seen, prereqs)){
                return true;
            }
        }

        // We’re done exploring this node with no cycle found through it:
        // 1) remove it from the current DFS path (pop from stack),
        seen.remove(course);

        // 2) memoize: mark this course as safe by clearing its prereq list,
        //    so future visits return immediately via the isEmpty() check above.
        prereqs.get(course).clear();

        // No cycle found starting from this course.
        return false;
    }
}
//Complexity: Time: O(V + E) → each edge visited once
//Space: O(V + E) for graph + O(V) for recursion + O(V) for seen set

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
