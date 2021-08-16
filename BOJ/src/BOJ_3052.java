import java.io.*;
/**
 * Created by bangjinhyuk on 2021/08/16.
 */
public class BOJ_3052 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int [] is = new int[10];
        for(int i =0; i<10;i++) is[i] = Integer.parseInt(br.readLine());
        int [] is2 = new int[42];
        for(int i: is){
            is2[i%42]++;
        }
        int tmp=0;
        for(int i : is2) if(i ==0) tmp++;
        System.out.println(42-tmp);
    }
}
