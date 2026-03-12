package patternBased.graph;
//787. Cheapest Flights Within K Stops

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * There are n cities connected by some number of flights.
 * You are given an array flights where flights[i] = [fromi, toi, pricei] indicates
 * that there is a flight from city fromi to city toi with cost pricei.
 * You are also given three integers src, dst, and k,
 * return the cheapest price from src to dst with at most k stops.
 * If there is no such route, return -1.
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] graph = new ArrayList[n];//An ARRAY of ArrayLists
        //example-
        // graph[0] → [ [1,4], [2,7] ] we can quickly find neighbors of a node
        //graph[1] → [ ]
        //graph[2] → [ [3,3] ]
        //graph[3] → [ ]
        for(int i = 0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph[from].add(new int[]{to, price});
        }

        int[] minStops = new int[n];//minimum stops used to reach this city so far
        Arrays.fill(minStops, Integer.MAX_VALUE);


        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[1]-b[1]);//based on price
        minHeap.offer(new int[]{src, 0, 0});//city, flight price, stops used

        while(!minHeap.isEmpty()){
            int curr[] = minHeap.poll();
            int currCity = curr[0];
            int currPrice = curr[1];
            int currStopsUsed = curr[2];

            if(currCity == dst){
                return currPrice;//minHeap give the minimum price
            }
            if(currStopsUsed > k){ //no need to explore its neighbors
                continue;
            }
            if(currStopsUsed > minStops[currCity]) {
                continue;
            }
            minStops[currCity] = currStopsUsed; //This ensures we don't explore worse paths.

            //explore neighbors of this node
            for(int neighbor[] : graph[currCity]){
                int nextCity = neighbor[0];
                int nextPrice = neighbor[1];

                int newPrice = currPrice + nextPrice;
                minHeap.offer(new int[]{nextCity, newPrice, currStopsUsed+1});
            }
        }
        return -1;
    }
}
//TC is O(E * k log(E * k)) ==> Since k < n typically: Often simplified as O(E log E)
//SC is O(E * k)
/**
 * For MinHeap Operation
 * TC = O(log EK)
 * For Building Graph- O(E)
 * For Pushing in Priority Queue- O(E*K)
 */