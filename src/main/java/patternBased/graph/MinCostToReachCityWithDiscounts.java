package patternBased.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
// Pattern- Shortest Path with State
/**
 * You are given: n cities (0 → n-1), highways[i] = [city1, city2, toll], discounts = number of discounts available
 * Rules:
 * Each highway has a toll cost.
 * You may apply a discount on a highway once, which halves the toll: discounted cost = toll / 2
 * You can use at most discounts discounts.
 * Goal: Return the minimum cost to travel from city 0 → city n-1
 * If impossible: return -1
 */
public class MinCostToReachCityWithDiscounts {
    // Its a Node with a state pattern
    //Example- City 3 with 0 discounts used
    //City 3 with 1 discount used so there are different states
    //Use Dijkstra with state expansion.
    //State becomes (city, costSoFar, discountsUsed)
    public int minimumCost(int n, int[][] highways, int discounts) {

        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] h : highways){
            int u = h[0];
            int v = h[1];
            int toll = h[2];

            graph[u].add(new int[]{v, toll});
            graph[v].add(new int[]{u, toll});
        }

        int[][] dist = new int[n][discounts + 1];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b)-> a[0]-b[0]);

        pq.offer(new int[]{0, 0, 0});
        // cost, city, discountsUsed

        dist[0][0] = 0;

        while(!pq.isEmpty()){

            int[] curr = pq.poll();

            int cost = curr[0];
            int city = curr[1];
            int used = curr[2];

            if(city == n-1){
                return cost;
            }

            for(int[] neighbor : graph[city]){

                int nextCity = neighbor[0];
                int toll = neighbor[1];

                // option 1: no discount
                int newCost = cost + toll;

                if(newCost < dist[nextCity][used]){
                    dist[nextCity][used] = newCost;
                    pq.offer(new int[]{newCost, nextCity, used});
                }

                // option 2: use discount
                if(used < discounts){

                    int discountCost = cost + toll/2;

                    if(discountCost < dist[nextCity][used+1]){
                        dist[nextCity][used+1] = discountCost;
                        pq.offer(new int[]{discountCost, nextCity, used+1});
                    }
                }
            }
        }

        return -1;
    }
}

/**
 * Example-
 * n = 5
 * highways =[[0,1,10],[1,2,10],[0,3,1],[3,4,10],[4,2,1]]
 * discounts = 1
 */

/**
 * Algo:
 * 1 Build graph
 * 2 MinHeap storing: (cost, city, discountsUsed)
 * 3 distance[city][discountsUsed]
 * 4 For each edge:
 *       OPTION 1 → pay full toll
 *       OPTION 2 → use discount
 */
//TC is O((V * D + E * D) log(V * D)) where V = cities, E = highways, D = discounts
//SC is O(V * D)