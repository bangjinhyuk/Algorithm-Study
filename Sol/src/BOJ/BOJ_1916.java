package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2022/05/11.
 */
public class BOJ_1916 {
    static List<List<Node>> graph;
    static int[] result;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var m = Integer.parseInt(br.readLine());

        result = new int[n+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[0] = 0;

        graph = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(result[end]);



    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        result[start] = 0;

        while (!pq.isEmpty()){
            Node node = pq.poll();

            if(result[node.index] < node.distance)
                continue;

            for (Node sideNode : graph.get(node.index)) {
                if(result[sideNode.index] > node.distance + sideNode.distance){
                    result[sideNode.index] = node.distance + sideNode.distance;
                    pq.add(new Node(sideNode.index, node.distance + sideNode.distance));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
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
