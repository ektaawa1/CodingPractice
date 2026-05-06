package patternBased.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * A logistics network consists of N warehouses (nodes) and E roads (edges).
 * Each road has a "stress level" (weight). When a truck travels from a source U to a destination V,
 * the total stress of that specific path is defined as the maximum stress level among all individual roads
 * in that path.Your task is to find the minimum possible total stress required to travel from U to V.
 * If no path exists, return -1.
 */
public class MinimumStress {
    public int getMinimumStress(int n, int[][] edges, int start, int end) {
        // 1. Build Adjacency List using an Array of ArrayLists
        // Note: n+1 if the nodes are 1-indexed
        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for(int i = 0; i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[]{v,w});// neighbor node, edge weight
            graph[v].add(new int[]{u,w});// if undirected
        }
        // 2. PriorityQueue (Min-Heap) for Dijkstra
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        minHeap.offer(new int[]{start, 0});

        int[] minMaxStress = new int[n + 1];
        Arrays.fill(minMaxStress, Integer.MAX_VALUE);
        minMaxStress[start] = 0;

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > minMaxStress[u]) continue;
            if (u == end) return d;

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // The "Min-Max" (Bottleneck) Logic
                int potentialStress = Math.max(d, weight);

                if (potentialStress < minMaxStress[v]) {
                    minMaxStress[v] = potentialStress;
                    minHeap.offer(new int[]{v, potentialStress});
                }
            }
        }
        return -1;
    }
}
