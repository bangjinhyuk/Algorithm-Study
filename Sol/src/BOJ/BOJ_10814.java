import java.io.*;
import java.util.*;

/**
 * Created by bangjinhyuk on 2021/09/22.
 */
public class BOJ_10814 {
    public static void main(String[] args) throws IOException {

        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        StringTokenizer st;
        List<UserData> userDataList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            userDataList.add(new UserData(Integer.parseInt(st.nextToken()),st.nextToken(),i));
        }
        Collections.sort(userDataList);
        for(UserData userData : userDataList){
            sb.append(userData.age).append(" ").append(userData.name).append("\n");
        }
        System.out.println(sb);
    }
    public static class UserData implements Comparable<UserData>{
        private int age;
        private String name;
        private int order;

        public UserData(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }

        @Override
        public int compareTo(UserData o) {
            if(this.age>o.age) return 1;
            else if(this.age==o.age){
                if (this.order>o.order) return 1;
                else return -1;
            }else return -1;
        }
    }
}
