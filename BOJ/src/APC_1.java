import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bangjinhyuk on 2021/10/30.
 */
public class APC_1 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var birth = br.readLine();
        var n = Integer.parseInt(br.readLine());
        var max = 0;
        List<Date> maxList = new ArrayList<>();
        for(int i = 0; i<n;i++){
            var date = br.readLine();
            int temp=0,result=1;
            for(int j = 0;j<8;j++){
                temp += Math.pow(Integer.parseInt(String.valueOf(birth.charAt(j))) - Integer.parseInt(String.valueOf(date.charAt(j))),2);
                if(j ==3||j ==5||j==7) {
                    result *= temp;
                    temp =0;
                }
            }
            if(max<result){
                max= result;
                maxList = new ArrayList<>();
                maxList.add(new Date(date));
            }else if(max == result) maxList.add(new Date(date));
        }
        maxList.sort(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                if(Integer.parseInt(o1.date.substring(0,4))!=Integer.parseInt(o2.date.substring(0,4))) return Integer.parseInt(o1.date.substring(0,4))-Integer.parseInt(o2.date.substring(0,4));
                else if(Integer.parseInt(o1.date.substring(4,6))!=Integer.parseInt(o2.date.substring(4,6))) return Integer.parseInt(o1.date.substring(4,6))-Integer.parseInt(o2.date.substring(4,6));
                else return Integer.parseInt(o1.date.substring(6,8))-Integer.parseInt(o2.date.substring(6,8));
            }
        });
        System.out.println(maxList.get(0).date);

    }
    static class Date{
        String date;

        public Date(String date) {
            this.date = date;
        }
    }
}
