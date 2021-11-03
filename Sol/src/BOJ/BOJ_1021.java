package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/27.
 */
public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        var n = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());
        var location = br.readLine();
        Deque<Integer> numbers = new LinkedList<>();
        for(int i = 1;i<n+1;i++){
            numbers.add(i);
        }
        int [] locationArr = new int[m];
        st = new StringTokenizer(location," ");
        for(int i=0;i<m;i++){
            locationArr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for(int i: locationArr){
           if(!numbers.isEmpty()){
               if(numbers.peekFirst().equals(i)) numbers.pollFirst();
               else{
                   int count = 0;
                   while(!numbers.peekFirst().equals(i)){
                       numbers.add(numbers.pollFirst());
                       count++;
                   }
                   if(numbers.size()-count<count) count = numbers.size()-count;
                   result +=count;
                   numbers.pollFirst();
               }
           }
        }
        System.out.println(result);
    }

}
