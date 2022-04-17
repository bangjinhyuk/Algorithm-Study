package PROGRAMMERS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bangjinhyuk on 2022/04/17.
 */
public class 신규_아이디_추천 {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        new_id = new_id.toLowerCase();
        List<String> allow = new ArrayList<>();
        allow.add("-");
        allow.add(".");
        allow.add("_");
        for(int i = 0; i < new_id.length(); i++){
            if(!allow.contains(String.valueOf(new_id.charAt(i))) && ((int)(new_id.charAt(i)) < 97 || (int)(new_id.charAt(i)) > 122) && ((int)(new_id.charAt(i)) < 48 || (int)(new_id.charAt(i)) > 57)){
                new_id = new_id.replace(String.valueOf(new_id.charAt(i)), "+");
            }
        }
        new_id = new_id.replaceAll("\\+", "");
        System.out.println(new_id);

        for(int i = 0; i < 14; i++){
            if(new_id.equals(new_id.replaceAll("\\.\\.", "."))){
                break;
            }else{
                new_id = new_id.replaceAll("\\.\\.", ".");
            }
        }
        if(new_id.startsWith("."))
            new_id = new_id.substring(1);
        if(new_id.endsWith("."))
            new_id = new_id.substring(0,new_id.length()-1);
        if(new_id.length() == 0)
            new_id = "aaa";
        if(new_id.length() >15)
            new_id = new_id.substring(0,15);
        if(new_id.endsWith("."))
            new_id = new_id.substring(0,new_id.length()-1);
        if(new_id.length() == 1){
            new_id = new_id + new_id + new_id;
        }
        if(new_id.length() == 2){
            new_id = new_id + new_id.charAt(1);
        }

        System.out.println(new_id);

    }
}
