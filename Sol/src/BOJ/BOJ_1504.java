package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2022/05/09.
 */
public class BOJ_1504 {
    static List<List<Node>> graph = new ArrayList<>();
    static int[] result;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        var n = Integer.parseInt(st.nextToken());
        var e = Integer.parseInt(st.nextToken());

        result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine()," ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());


        dijkstra(v1);
        long v1To1 = result[1];
        long v1ToN = result[n];
        long v1ToV2 = result[v2];
        Arrays.fill(result, Integer.MAX_VALUE);
        dijkstra(v2);
        long v2To1 = result[1];
        long v2ToN = result[n];

        long answer = Math.min(v1To1 + v2ToN + v1ToV2 , v1ToN + v2To1 + v1ToV2);
        if(answer >= Integer.MAX_VALUE)
            answer = -1;

        System.out.println(answer);



    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        result[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(result[node.index] <  node.distance)
                continue;

            for (Node sideNode : graph.get(node.index)) {
                if(result[sideNode.index] > sideNode.distance + node.distance){
                    result[sideNode.index] = sideNode.distance + node.distance;
                    pq.add(new Node(sideNode.index, sideNode.distance + node.distance));
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
