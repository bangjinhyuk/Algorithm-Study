package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bangjinhyuk on 2022/01/21.
 */
public class BOJ_1342 {
    static int result = 0;
    static int size;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var s = br.readLine();
        char[] chars = s.toCharArray();
        size = chars.length;

        Map<Character,Integer> characters = new HashMap<>();
        for(char c : chars){
            if(characters.get(c) == null){
                characters.put(c,1);
                continue;
            }
            characters.put(c,characters.get(c)+1);
        }

        characters.forEach((character, integer) -> {
            if(integer>0){
                // 현재 문자열, map, 선택된 문자
                getResult("",characters, character);
            }
        });

        System.out.println(result);
    }

    private static void getResult(String s, Map<Character, Integer> characters, char select) {
        //종료 조건
        if(s.length()==size-1){
            result++;
            return;
        }
        //map 복제
        Map<Character, Integer> tmpCharacters = new HashMap<>();
        tmpCharacters.putAll(characters);
        // select 넘어온것 복제한 map에서 삭제
        if(tmpCharacters.get(select) == 1)
            tmpCharacters.remove(select);
        else
            tmpCharacters.put(select,tmpCharacters.get(select)-1);
        //문자열 복제
        s += select;
        String finalS = s;

        tmpCharacters.forEach((character, integer) -> {
            if(integer>0 && !finalS.endsWith(String.valueOf(character))){
                getResult(finalS,tmpCharacters, character);
            }
        });
    }
}
