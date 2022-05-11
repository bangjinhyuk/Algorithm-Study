package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2022/05/11.
 */
public class BOJ_11779 {
    static List<List<Node>> graph;
    static int[] result;
    static int[] city;
    static String[] route;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var m = Integer.parseInt(br.readLine());

        result = new int[n+1];
        city = new int[n+1];
        route = new String[n+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[0] = 0;

        graph = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), "", 0));
        }

        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(result[end]);
        System.out.println(city[end]);
        System.out.println(route[end]);



    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0, start + " ", 1));
        result[start] = 0;

        while (!pq.isEmpty()){
            Node node = pq.poll();

            if(result[node.index] < node.distance)
                continue;

            for (Node sideNode : graph.get(node.index)) {
                if(result[sideNode.index] > node.distance + sideNode.distance){
                    result[sideNode.index] = node.distance + sideNode.distance;
                    city[sideNode.index] = node.city + 1;
                    route[sideNode.index] = node.route + sideNode.index + " ";
                    pq.add(new Node(sideNode.index, node.distance + sideNode.distance, node.route + sideNode.index + " ", node.city+1));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int index;
        int distance;
        String route;
        int city;

        public Node(int index, int distance, String route, int city) {
            this.index = index;
            this.distance = distance;
            this.route = route;
            this.city = city;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
