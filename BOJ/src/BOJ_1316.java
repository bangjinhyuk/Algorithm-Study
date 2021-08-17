import java.io.*;

/**
 * Created by bangjinhyuk on 2021/08/17.
 */
public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = n;
        String word;
        int tmp;
        for(int i =0;i<n;i++){
            word = br.readLine();
            for(int j=0;j<word.length();j++){
                if(j+1<word.length()){
                    if (word.charAt(j) == word.charAt(j + 1) && j+1<word.length()) continue;
                    else {
                        tmp = word.lastIndexOf(word.charAt(j));
                        if ( tmp != j && tmp != -1) {
                            result--;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
