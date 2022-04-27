package PROGRAMMERS;
import java.util.*;
import java.util.stream.Collectors;
/**
 * Created by bangjinhyuk on 2022/04/27.
 */
public class 파일명_정렬 {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        List<FileData> fileDataList = new ArrayList<>();
        for (String file : files) {
            boolean isnumber = false;
            FileData fileData = new FileData();
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < file.length() ; i++) {
                if(Objects.isNull(fileData.getNumber())&&file.charAt(i)>=48 && file.charAt(i) <= 57){
                    if(isnumber){
                        tmp.append(file.charAt(i));
                    }else{
                        isnumber = true;
                        fileData.setHead(tmp.toString());
                        tmp = new StringBuilder();
                        tmp.append(file.charAt(i));
                    }
                }else{
                    if(isnumber){
                        isnumber = false;
                        fileData.setNumber(tmp.toString());
                        tmp = new StringBuilder();
                        tmp.append(file.charAt(i));
                    }else{
                        tmp.append(file.charAt(i));
                    }
                }
            }
            if(isnumber)
                fileData.setNumber(tmp.toString());
            else
                fileData.setTail(tmp.toString());
            fileDataList.add(fileData);

        }
        System.out.println(fileDataList);
        List<FileData> sortedList = fileDataList.stream().sorted((f1, f2) -> {
            if (f1.getHead().toLowerCase().equals(f2.getHead().toLowerCase())) {
                return Integer.parseInt(f1.getNumber()) - Integer.parseInt(f2.getNumber());
            } else {
                return f1.getHead().toLowerCase().compareTo(f2.getHead().toLowerCase());
            }
        }).collect(Collectors.toList());

        String[] answer = sortedList.stream()
                .map(fileData1 -> {
                    if(Objects.nonNull(fileData1.getTail()))
                        return fileData1.getHead() + fileData1.getNumber() + fileData1.getTail();
                    else
                        return fileData1.getHead() + fileData1.getNumber();
                })
                .toArray(String[]::new);

        for (String s : answer) {
            System.out.println(s);
        }
    }
    public static class FileData{
        String head;
        String number;
        String tail;

        public String getHead() {
            return head;
        }


        public String getTail() {
            return tail;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public void setTail(String tail) {
            this.tail = tail;
        }

        @Override
        public String toString() {
            return "FileData{" +
                    "head='" + head + '\'' +
                    ", number=" + number +
                    ", tail='" + tail + '\'' +
                    '}';
        }
    }
}
