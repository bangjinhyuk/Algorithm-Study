package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2022/05/09.
 */
public class BOJ_1753 {
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        visited = new boolean[v+1];
        result = new int[v+1];

        Arrays.fill(result, Integer.MAX_VALUE);


        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < v+1; i++) {
            Collections.sort(graph.get(i));
        }
        dijkstra(start);

        for (int i = 1; i < result.length; i++) {
            if(result[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(result[i]);
        }

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        result[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.index])
                continue;
            else
                visited[node.index] = true;

            for (Node sideNode : graph.get(node.index)) {
                if(node.distance + sideNode.distance < result[sideNode.index]){
                    result[sideNode.index] = node.distance + sideNode.distance;
                    pq.add(new Node(sideNode.index,node.distance + sideNode.distance));
                }
            }

        }



    }

    public static class Node implements Comparable<Node>{
        int index;
        int distance;

        public Node(int destination, int distance) {
            this.index = destination;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
