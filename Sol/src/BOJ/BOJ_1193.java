package BOJ;

import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/18.
 */
public class BOJ_1193 {
    public static String cal(int x){
        int i = 1,tmp;
        while (i+i*i<x*2){
            i++;
        }
        i--;
        tmp = x-(i+i*i)/2;
        return i%2 !=0? tmp+"/"+(i+2-(tmp)) : (i+2-(tmp))+"/"+tmp;
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(cal(Integer.parseInt(br.readLine())));
    }
}
