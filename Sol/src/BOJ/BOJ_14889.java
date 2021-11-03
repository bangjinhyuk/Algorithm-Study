import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/09/26.
 */
public class BOJ_14889 {
    static int [][] ability;
    static int [] member;
    static int start;
    static int link;
    static Integer min= null;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ability = new int[n][n];
        member = new int[n];
        for(int i=0;i<n;i++){
            var st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        start =0;
        link =0;
        getMin(0);
        System.out.println(min);
    }

    private static void getMin(int index) {
        if(index == member.length){
            int startAbility=0;
            int linkAbility=0;

            for(int i=0;i<member.length;i++){
                for(int j=i+1;j<member.length;j++){
                    if(member[i] == member[j] && member[i] == 1){
                        startAbility = startAbility+ ability[i][j]+ability[j][i];
                    }else if(member[i] == member[j] && member[i] == 2){
                        linkAbility = linkAbility+ ability[i][j]+ability[j][i];
                    }
                }
            }
            if (min == null || min> Math.abs(startAbility-linkAbility)) {
                min = Math.abs(startAbility - linkAbility);
            }
            return;
        }

        for(int i=1;i<3;i++){
            if(i ==1){
                if(start<member.length/2){
                    start++;
                    member[index] = i;
                    getMin(index+1);
                    start--;
                }
            }else{
                if(link<member.length/2){
                    link++;
                    member[index] = i;
                    getMin(index+1);
                    link--;
                }
            }
            member[index] = 0;
        }
    }
}
