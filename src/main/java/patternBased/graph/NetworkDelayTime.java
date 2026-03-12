package patternBased.graph;
//743. Network Delay Time

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel
 * from source to target. We will send a signal from a given node k.
 * Return the minimum time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        //STEP 1: Build the graph (adjacency list) something like this
        // node -> list of neighbors with travel time
        int totalNodes = n;
        //int startNode = k;
        List<int[]>[] graph = new ArrayList[totalNodes+1]; //since nodes are from 1 to n & not 0 to n
        for(int i = 1; i<= totalNodes; i++){
            graph[i] = new ArrayList<>();
        }

        //Fill the graph
        for(int[] edge : times){
            int source = edge[0];
            int destination = edge[1];
            int travelTime = edge[2];
            graph[source].add(new int[]{destination, travelTime});
        }

        //STEP 2: Build a Distance array
        //This keeps track of shortest time from start node to every node.
        //Initially we assume distance to every node = infinity
        int[] shortestTime = new int[totalNodes + 1];
        Arrays.fill(shortestTime, Integer.MAX_VALUE);
        //Now set the start node to 0
        shortestTime[k] = 0;

        //STEP 3: Create a Min Heap to pick the node with the smallest distance first.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        //time 0 to reach startNode
        minHeap.offer(new int[]{0, k});//starting node storing [timeToReachNode , node]

        //STEP 4: Main Loop
        while(!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentTime = current[0];
            int currentNode = current[1];

            //Explore neighbors
            for(int[] neighbor : graph[currentNode]) {
                int nextNode = neighbor[0];//destination
                int travelTime = neighbor[1];
                // If going through currentNode is faster than what we previously knew
                if(currentTime + travelTime < shortestTime[nextNode]) {
                    shortestTime[nextNode] = currentTime + travelTime;//We found a faster path.
                    minHeap.offer(new int[]{shortestTime[nextNode], nextNode});
                }
            }
        }
        //STEP 5: Find final Answer
        int result = 0;
        for(int node = 1; node <= totalNodes; node++) {

            if(shortestTime[node] == Integer.MAX_VALUE)
                return -1;

            result = Math.max(result, shortestTime[node]);
        }
        //Why max?
        //Because signal spreads gradually.
        //The last node receiving the signal determines total time.
        return result;
    }
}
//Example of building graph:
//2 -> (1,1) where 1 is the destination node v and 1 is the weight w
//2 -> (3,1) where 3 is the destination node v and 1 is the weight w
//3 -> (4,1) where 4 = v & 1 = w
/**
 * Imagine:
 * You drop a signal at node K.
 * It spreads through wires.
 * Each wire takes time.
 *
 * Dijkstra always expands the fastest signal wave first.
 * So the algorithm behaves like water spreading through pipes.
 */
/**
 * Example-Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2,    Output: 2
 * | Node | Time from 2 |
 * | ---- | ----------- |
 * | 2    | 0           |
 * | 1    | 1           |
 * | 3    | 1           |
 * | 4    | 2           |
 *
 * When has every node received the signal?
 * Node 1 → time 1
 * Node 3 → time 1
 * Node 4 → time 2
 * The last node receives it at time 2.
 * So answer = 2.
 */
