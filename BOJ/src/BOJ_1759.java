import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/20.
 */
public class BOJ_1759 {
    static String [] alphabet;
    static StringBuilder sb = new StringBuilder();
    static int l;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()," ");
        l = Integer.parseInt(st.nextToken());
        var c = Integer.parseInt(st.nextToken());
        alphabet = new String[c];
        st = new StringTokenizer(br.readLine()," ");
        for(int i =0;i<c;i++){
            alphabet[i] = st.nextToken();
        }
        Arrays.sort(alphabet);
        getPassword(0,"",0);
        System.out.println(sb);
    }

    private static void getPassword(int idx, String tmp,int vowel) {
        // 길이가 l과 같으면 모음 자음 개수 조건 성립시 sb에 넣어주고 아니면 그냥 리턴
        if(tmp.length()==l) {
            if(vowel>=1&&l-vowel>=2){
                sb.append(tmp).append("\n");
                return;
            }
            return;
        }
        //끝까지 갔을때 리턴
        if(idx == alphabet.length) return;
        //현재 선택하여 넣는 경우에서 모음이라면 모음+1 아니면 그냥 모음을 그대로 파라미터에 추가
        if("aeiou".contains(alphabet[idx])) getPassword(idx+1,tmp+alphabet[idx],vowel+1);
        else getPassword(idx+1,tmp+alphabet[idx],vowel);
        //현재 인덱스를 추가하지 않고 다음껄로 넘김
        getPassword(idx+1,tmp,vowel);
    }
}
