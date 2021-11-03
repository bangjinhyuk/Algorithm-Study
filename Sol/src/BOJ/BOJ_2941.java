import java.io.*;
/**
 * Created by bangjinhyuk on 2021/08/17.
 */
public class BOJ_2941 {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String [] sa = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(String s: sa){
            if(str.contains(s)) {
                str = str.replaceAll(s, "*");
            }
        }
        System.out.println(str.length());
    }
//    public static void main(String[] args) throws IOException {
//        var br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        int result =0;
//        String tmp;
//        for (int i=0;i<str.length();i++){
//            if(i+1<str.length()){
//                tmp = String.valueOf(str.charAt(i))+String.valueOf(str.charAt(i+1));
//                if(tmp.equals("c=")||tmp.equals("c-")||tmp.equals("d-")||tmp.equals("lj")||tmp.equals("nj")||tmp.equals("s=")||tmp.equals("z=")){
//                    result++;
//                    i++;
//                    continue;
//                }
//            }
//            if(i+2<str.length()){
//                tmp = String.valueOf(str.charAt(i))+String.valueOf(str.charAt(i+1))+String.valueOf(str.charAt(i+2));
//                if(tmp.equals("dz=")){
//                    result++;
//                    i+=2;
//                    continue;
//                }
//            }
//            result++;
//        }
//        System.out.println(result);
//    }
}
