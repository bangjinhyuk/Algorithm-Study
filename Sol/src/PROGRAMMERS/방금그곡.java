package PROGRAMMERS;
import java.util.*;
import java.util.stream.*;
/**
 * Created by bangjinhyuk on 2022/05/01.
 */
public class 방금그곡 {
    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        List<Music> musics = new ArrayList<>();
        for(int i = 0; i< musicinfos.length; i++){
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            musics.add(new Music(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken()));
        }

        musics = musics.stream().sorted((m1,m2) -> m2.min-m1.min).collect(Collectors.toList());

        for(Music music : musics){
            if(music.sheetMusic.contains(getLowerSheet(m)))
                System.out.println(music.title);
        }
        System.out.println("(None)");
    }
    static public String getLowerSheet(String sheet){
        sheet = sheet.replaceAll("C#", "c");
        sheet = sheet.replaceAll("D#", "d");
        sheet = sheet.replaceAll("F#", "f");
        sheet = sheet.replaceAll("G#", "g");
        sheet = sheet.replaceAll("A#", "a");
        return sheet;

    }

    static public class Music{
        int min;
        String title;
        String sheetMusic;

        public Music(String startTime, String endTime, String title, String sheetMusic){
            StringTokenizer st = new StringTokenizer(startTime, ":");
            int tmpStart = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            st = new StringTokenizer(endTime, ":");
            int tmpEnd = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            this.min = tmpEnd - tmpStart;
            this.title = title;
            sheetMusic = getLowerSheet(sheetMusic);
            while(sheetMusic.length() < this.min){
                sheetMusic += sheetMusic;
            }
            this.sheetMusic = sheetMusic.substring(0,this.min);

        }
    }
}
