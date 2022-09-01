import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;

        Map<String, String> inMap = new HashMap<>();        //number, time(String)
        Map<String, Integer> timeMap = new HashMap<>();     //number, time(integer)

        //cal time
        for (String record : records) {
            String[] recordInfo = record.split(" ");
            String key = recordInfo[1];
            if (recordInfo[2].equals("IN")) {   //IN
                inMap.put(key, recordInfo[0]);
            } else {                            //OUT
                String inTime = inMap.remove(key);
                int time = convertTime(recordInfo[0]) - convertTime(inTime);
                if (timeMap.containsKey(key)) { //add fee
                    time += timeMap.get(key);
                }
                timeMap.put(key, time);
            }
        }
        if (!inMap.isEmpty()) {
            String[][] inArr = inMap.entrySet().stream().map(m -> new String[] {m.getKey(), m.getValue()})
                .toArray(String[][]::new);
            for (int i = 0; i < inArr.length; i++) {
                String key = inArr[i][0];
                int time = convertTime("23:59") - convertTime(inArr[i][1]);
                if (timeMap.containsKey(key)) { //add fee
                    time += timeMap.get(key);
                }
                timeMap.put(key, time);
            }
        }

        //cal fee
        Map<Integer, Integer> feeMap = new HashMap<>();     //number, time
        for (String key : timeMap.keySet()) {
            int fee = calculateFee(fees, timeMap.get(key));
            feeMap.put(Integer.parseInt(key), fee);
        }

        answer = feeMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).mapToInt(Map.Entry::getValue).toArray();
        return answer;
    }

    private int convertTime(String time) {
        int[] timeArr = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return (timeArr[0] * 60 + timeArr[1]);
    }

    private int calculateFee(int[] feeInfo, int time) {
        int fee = feeInfo[1];
        if (time <= feeInfo[0]) {
            return fee;
        }
        fee += feeInfo[3] * Math.ceil((time - feeInfo[0]) / (double)feeInfo[2]);
        return fee;
    }
}
