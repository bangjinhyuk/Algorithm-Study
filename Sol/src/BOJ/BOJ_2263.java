package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bangjinhyuk on 2022/03/01.
 */
public class BOJ_2263 {
    static StringBuilder sb = new StringBuilder();
    static List<Integer> inOrder = new ArrayList<>();
    static List<Integer> postOrder = new ArrayList<>();
    static Map<Integer,Integer> inOrderIdx = new HashMap<>();
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());

        var st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            inOrder.add(tmp);
            inOrderIdx.put(tmp,i);
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            postOrder.add(Integer.parseInt(st.nextToken()));
        }
        int root = inOrder.indexOf(postOrder.get(n-1));
        sb.append(postOrder.get(n-1)).append(" ");
        getResult(new Data(0,root-1,root+1,n-1, 0,root-1,root,n-2));
        System.out.println(sb);
    }

    private static void getResult(Data data) {
        //TODO Left
        if(data.postOrderLeft2 >= data.postOrderLeft1){
            sb.append(postOrder.get(data.postOrderLeft2)).append(" ");
            if(data.inOrderLeft2-data.inOrderLeft1 != 0){
                int root = inOrderIdx.get(postOrder.get(data.postOrderLeft2));
                int leftTreeNum = root-1 - data.inOrderLeft1;
                getResult(new Data(data.inOrderLeft1,root-1,root+1, data.inOrderLeft2, data.postOrderLeft1, data.postOrderLeft1 + leftTreeNum,data.postOrderLeft1 + leftTreeNum+1, data.postOrderLeft2 -1));
            }
        }
        //TODO Right
        if(data.postOrderRight2 >= data.postOrderRight1) {
            sb.append(postOrder.get(data.postOrderRight2)).append(" ");
            if (data.inOrderRight2 - data.inOrderRight1 != 0) {
                int root = inOrderIdx.get(postOrder.get(data.postOrderRight2));
                int leftTreeNum = root - 1 - data.inOrderRight1;
                getResult(new Data(data.inOrderRight1, root - 1, root + 1, data.inOrderRight2, data.postOrderRight1, data.postOrderRight1 + leftTreeNum, data.postOrderRight1 + leftTreeNum + 1, data.postOrderRight2 - 1));
            }
        }
    }

    public static class Data {
        int inOrderLeft1;
        int inOrderLeft2;
        int inOrderRight1;
        int inOrderRight2;
        int postOrderLeft1;
        int postOrderLeft2;
        int postOrderRight1;
        int postOrderRight2;

        public Data(int inOrderLeft1, int inOrderLeft2, int inOrderRight1, int inOrderRight2, int postOrderLeft1, int postOrderLeft2, int postOrderRight1, int postOrderRight2) {
            this.inOrderLeft1 = inOrderLeft1;
            this.inOrderLeft2 = inOrderLeft2;
            this.inOrderRight1 = inOrderRight1;
            this.inOrderRight2 = inOrderRight2;
            this.postOrderLeft1 = postOrderLeft1;
            this.postOrderLeft2 = postOrderLeft2;
            this.postOrderRight1 = postOrderRight1;
            this.postOrderRight2 = postOrderRight2;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "inOrderLeft1=" + inOrderLeft1 +
                    ", inOrderLeft2=" + inOrderLeft2 +
                    ", inOrderRight1=" + inOrderRight1 +
                    ", inOrderRight2=" + inOrderRight2 +
                    ", postOrderLeft1=" + postOrderLeft1 +
                    ", postOrderLeft2=" + postOrderLeft2 +
                    ", postOrderRight1=" + postOrderRight1 +
                    ", postOrderRight2=" + postOrderRight2 +
                    '}';
        }
    }
}
