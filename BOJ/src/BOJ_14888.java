import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/09/26.
 */
public class BOJ_14888 {
    static int [] operator = new int[4];
    static int [] num;
    static Integer minNum = null;
    static Integer maxNum = null;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        var st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        findMin(num[0],1);
        System.out.println(maxNum+"\n"+minNum);
    }

    private static void findMin(int beforeResult,int nextIndex) {
        if(nextIndex == num.length){
            if(minNum == null || minNum> beforeResult) minNum = beforeResult;
            if(maxNum == null || maxNum< beforeResult) maxNum = beforeResult;
        }
        for(int i=0;i<4;i++){
            if(operator[i]>0){
                if(i==0){
                    operator[i]--;
                    findMin(beforeResult+num[nextIndex],nextIndex+1);
                }else if(i==1){
                    operator[i]--;
                    findMin(beforeResult-num[nextIndex],nextIndex+1);
                }else if(i==2){
                    operator[i]--;
                    findMin(beforeResult*num[nextIndex],nextIndex+1);
                }else{
                    operator[i]--;
                    findMin(beforeResult/num[nextIndex],nextIndex+1);
                }
                operator[i]++;
            }
        }

    }




}
