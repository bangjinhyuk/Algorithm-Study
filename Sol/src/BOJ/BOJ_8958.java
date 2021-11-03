import java.io.*;
/**
 * Created by bangjinhyuk on 2021/08/16.
 */
public class BOJ_8958 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String s;
        int tmp=1, score = 0;
        for(int i = 0; i<n;i++){
            s = br.readLine();
            for(int j = 0;j< s.length();j++){
                if(Character.toString(s.charAt(j)).equals("O")){
                    score += tmp;
                    tmp++;
                }else tmp =1;
            }
            sb.append(score+"\n");
            score = 0;
            tmp = 1;
        }
        System.out.println(sb);
    }
}
