import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by bangjinhyuk on 2021/10/25.
 */
public class BOJ_17298 {
    /**
     * 시나리오
     * 1. 주어진 수열 int[] 배열에 넣어주기
     * 2. 배열 인덱스 0 부터 차례로 다음 인덱스 수(a)와 비교
     *    - case1 a가 현재 인덱스 수보다 더 크면 해당 배열에 a 넣어주기
     *        - case 1-1 스택이 비어있지 않다면 peek를 통해 비교 해당 수와 a 비교
     *              - case 1-1-1 a가 크다면 스택에서 꺼내온 인덱스에 a 넣어주기 * 스택이 빌때까지 반복
     *              - case 1-1-2 a가 더 작다면 넘어가기
     *    - case2 다음 인덱스 수가 더 작다면 스택에 현재 (인덱스 숫자,인덱스 값) 저장
     * 3. 마지막수는 -1 넣어주기
     * 4. 만약 스택이 비어있지 않다면 하나씩 꺼내서 해당 배열에 -1 넣어주기
     * 5. 출력
     */
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        Stack<ArrNum> stack = new Stack<>();
        var st = new StringTokenizer(br.readLine()," ");
        int [] arr = new int[n];
        //1. 주어진 수열 int[] 배열에 넣어주기
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //2. 배열 인덱스 0 부터 차례로 다음 인덱스 수(a)와 비교
        for(int i=0;i<n-1;i++){
            //case1 a가 현재 인덱스 수보다 더 크면 해당 배열에 a 넣어주기
            if(arr[i]<arr[i+1]) {
                arr[i] = arr[i + 1];
                //case 1-1 스택이 비어있지 않다면 peek를 통해 비교 해당 수와 a 비교
                if(!stack.empty()){
                    while(!stack.empty()){
                        //case 1-1-1 a가 크다면 스택에서 꺼내온 인덱스에 a 넣어주기 * 스택이 빌때까지 반복
                        if(stack.peek().num<arr[i+1]){
                            arr[stack.peek().idx] = arr[i+1];
                            stack.pop();
                        }//case 1-1-2 a가 더 작다면 넘어가기
                        else break;
                    }
                }
            }
            //case2 다음 인덱스 수가 더 작다면 스택에 현재 인덱스 숫자와 인덱스 값 저장
            else stack.push(new ArrNum(arr[i],i));
        }
        //3. 마지막수는 -1 넣어주기
        arr[n-1] = -1;
        //4. 만약 스택이 비어있지 않다면 하나씩 꺼내서 해당 배열에 -1 넣어주기
        if(!stack.empty()) {
            while(!stack.empty()) {
                arr[stack.pop().idx] = -1;
            }
        }
        //5. 출력
        for(int i: arr)sb.append(i).append(" ");
        System.out.println(sb);
    }
    static class ArrNum{
        int num;
        int idx;

        public ArrNum(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
