package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/11/12.
 */
public class BOJ_1920 {
    static int [] a;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        a = new int[n];
        var stA = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n;i++){
            a[i] = Integer.parseInt(stA.nextToken());
        }
        Arrays.sort(a);
        var m = Integer.parseInt(br.readLine());
        var stM = new StringTokenizer(br.readLine()," ");
        var sb = new StringBuilder();
        for(int i = 0;i < m;i++){
            sb.append(getNum(Integer.parseInt(stM.nextToken()),0,a.length-1)).append("\n");
        }
        System.out.println(sb);
    }

    private static int getNum(int num,int startIdx,int endIdx) {
        if(a[(endIdx+startIdx)/2] == num) return 1;
        if(startIdx == endIdx) return 0;
        if(startIdx == endIdx -1){
            if(a[endIdx] == num) return 1;
            return 0;
        }
        else if(a[(endIdx+startIdx)/2] > num) return getNum(num,startIdx,(endIdx+startIdx)/2);
        else return getNum(num,(endIdx+startIdx)/2,endIdx);
    }
}
