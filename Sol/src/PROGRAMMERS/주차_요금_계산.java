package PROGRAMMERS;
import java.util.*;
import java.util.stream.*;
/**
 * Created by bangjinhyuk on 2022/04/29.
 */
public class 주차_요금_계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<Integer,CarDetail> carDetails = new HashMap<>();

        String tmpTime;
        String carNum;
        String inOut;
        CarDetail CarDetail;
        for(int i = 0; i < records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i], " ");
            tmpTime = st.nextToken();
            carNum = st.nextToken();
            inOut = st.nextToken();
            if(inOut.equals("IN")){
                if(!carDetails.containsKey(Integer.parseInt(carNum))){
                    CarDetail = new CarDetail();
                    CarDetail.setInTime(tmpTime);
                    carDetails.put(Integer.parseInt(carNum),CarDetail);
                }else
                    carDetails.get(Integer.parseInt(carNum)).setInTime(tmpTime);
            }
            else{
                carDetails.get(Integer.parseInt(carNum)).setOutTime(tmpTime);
            }
        }
        List<Integer> keyList = carDetails.keySet().stream().sorted().collect(Collectors.toList());
        int[] answer = new int[keyList.size()];
        int tmp = 0;
        for(int key : keyList){
            if(carDetails.get(key).inTime !=-1){
                carDetails.get(key).setOutTime("23:59");
            }

            int resultTimeMinusBasic = carDetails.get(key).resultTime-basicTime;
            if(resultTimeMinusBasic <= 0)
                answer[tmp] = basicFee;
            else{
                int resultFee = resultTimeMinusBasic%unitTime==0 ? (resultTimeMinusBasic/unitTime)*unitFee :  (((resultTimeMinusBasic)/unitTime)+1)*unitFee;
                answer[tmp] = resultFee + basicFee;
            }

            tmp++;
        }
        for (int i : answer) {
            System.out.println(i);
        }
    }
    public static class CarDetail{
        int inTime = -1;
        int resultTime = 0;

        public void setInTime(String inTime){
            StringTokenizer st = new StringTokenizer(inTime, ":");
            this.inTime = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
        }

        public void setOutTime(String outTime){
            StringTokenizer st = new StringTokenizer(outTime, ":");
            int tmpOutTime = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            resultTime += tmpOutTime-inTime;
            inTime = -1;
        }

        public String toString(){
            return inTime + "->" + resultTime;
        }

    }
}
