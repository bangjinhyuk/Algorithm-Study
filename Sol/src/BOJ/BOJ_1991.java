package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2022/05/09.
 */
public class BOJ_1991 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<String, Node> nodeMap = new HashMap<>();
        String root;
        String left;
        String right;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            root = st.nextToken();
            left = st.nextToken();
            right = st.nextToken();
            if(!nodeMap.containsKey(root))
                nodeMap.put(root,new Node(root));
            if(!left.equals(".")) {
                nodeMap.put(left, new Node(left));
                nodeMap.get(root).setLeftNode(nodeMap.get(left));
            }else
                nodeMap.get(root).setLeftNode(null);
            if(!right.equals(".")) {
                nodeMap.put(right, new Node(right));
                nodeMap.get(root).setRightNode(nodeMap.get(right));
            }else
                nodeMap.get(root).setRightNode(null);
        }
        preOrder(nodeMap.get("A"));
        System.out.println();
        inOrder(nodeMap.get("A"));
        System.out.println();
        postOrder(nodeMap.get("A"));

    }
    public static class Node{
        String data;
        Node leftNode;
        Node rightNode;

        public Node(String data) {
            this.data = data;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }
    }
    public static void preOrder(Node node){
        if(node != null){
            System.out.print(node.data);
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    public static void inOrder(Node node) {
        if(node != null) {
            inOrder(node.leftNode);
            System.out.print(node.data);
            inOrder(node.rightNode);
        }
    }
    public static void postOrder(Node node){
        if(node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print(node.data);
        }
    }
}
