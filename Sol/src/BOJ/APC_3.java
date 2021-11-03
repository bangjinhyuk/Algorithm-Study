package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/30.
 */
// 시간 초과 deque 사용
public class APC_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int [] cache = new int[n];
        for(int i = 0;i<n;i++){
            cache[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> front = new LinkedList<>();
        Deque<Integer> back = new LinkedList<>();
        boolean [] exist;
        int tmpCacheSize = 0, frontCache = 0 ;
        int now = 0;
        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine()," ");
            String method =st.nextToken();
            if (method.equals("B")) {
                if (!back.isEmpty() && now!=0) {
                    front.addLast(now);
                    frontCache += cache[now-1];
                    now = back.pollFirst();
                }
            } else if (method.equals("F")) {
                if (!front.isEmpty() && now!=0) {
                    back.addFirst(now);
                    now = front.pollLast();
                }
            } else if (method.equals("A")) {
                front = new LinkedList<>();
                tmpCacheSize -= frontCache;
                frontCache = 0;
                if(now ==0) {
                    now = Integer.parseInt(st.nextToken());
                    tmpCacheSize += cache[now-1];
                }
                else {
                    back.addFirst(now);
                    now = Integer.parseInt(st.nextToken());
                    tmpCacheSize += cache[now-1];
                    while(tmpCacheSize>c) {
                        if(!back.isEmpty()){
                            tmpCacheSize -= cache[back.pollLast()];
                        }
                    }
                }
            } else {
                exist = new boolean[n];
                int size = back.size();
                for(int j=0;j<size;j++){
                    if(!back.isEmpty()){
                        if (exist[back.peekFirst() - 1]) {
                            tmpCacheSize -= cache[back.pollFirst() - 1];
                        } else {
                            exist[back.peekFirst() - 1] = true;
                            back.addLast(back.pollFirst());
                        }
                    }
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(now).append("\n");
        if(back.isEmpty()) sb.append(-1);
        else {
            while (!back.isEmpty()) {
                sb.append(back.pollFirst()).append(" ");
            }
        }
        sb.append("\n");
        if(front.isEmpty()) sb.append(-1);
        else{
            while(!front.isEmpty()){
                sb.append(front.pollFirst()).append(" ");
            }
        }
        System.out.println(sb);
    }
}
