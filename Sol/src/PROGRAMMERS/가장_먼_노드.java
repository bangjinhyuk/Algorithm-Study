package PROGRAMMERS;

import java.util.*;

/**
 * Created by bangjinhyuk on 2022/05/05.
 */
public class 가장_먼_노드 {
    static List<List<Node>> graph;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
//        int[][] edge = {{3, 6}, {4, 6}, {3, 2}, {1, 3}, {1, 2}, {5, 2}};


        graph = new ArrayList<>();
        result = new int[n+1];
        visited = new boolean[n+1];

        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] ints : edge) {
            graph.get(ints[0]).add(new Node(ints[1], 1));
            graph.get(ints[1]).add(new Node(ints[0], 1));
        }

        dijkstra(1);

        int max = 0;
        int answer = 0;
        for (int i : result) {
            if(max < i){
                max = i;
                answer = 1;
            }else if(max == i){
                answer++;
            }
        }
        System.out.println(answer);

    }
    private static void dijkstra(int idx) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(idx,0));
        result[idx] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.index])
                continue;
            else
                visited[node.index] = true;

            for(Node sideNode : graph.get(node.index)){
                if(sideNode.distance + node.distance < result[sideNode.index]){
                    result[sideNode.index] = sideNode.distance + node.distance;
                    pq.add(new Node(sideNode.index, result[sideNode.index]));
                }
            }
        }


    }

    private static class Node implements Comparable<Node>{
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

}
