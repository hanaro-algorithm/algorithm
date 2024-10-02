import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_S2_19583_싸이버개강총회 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 개강총회 시작 전에 채팅을 친 사람을 저장할 set
        Set<String> before = new HashSet<>();
        // 주어진 조건을 모두 만족하여 출석처리가 된 사람을 저장할 set
        Set<String> attend = new HashSet<>();

        String [] str1 = st.nextToken().split(":");
        String [] str2 = st.nextToken().split(":");
        String [] str3 = st.nextToken().split(":");

        // 시작 시간
        int start = Integer.parseInt(str1[0])*60 + Integer.parseInt(str1[1]);
        // 끝낸 시간
        int end = Integer.parseInt(str2[0])*60 + Integer.parseInt(str2[1]);
        // 스트리밍 끝낸 시간
        int stream = Integer.parseInt(str3[0])*60 + Integer.parseInt(str3[1]);

        String input = null;

        while((input = br.readLine()) != null) {
        	// arr[0]: 채팅 시간, arr[1]: 닉네임
            String [] arr = input.split(" ");
            String [] tmp = arr[0].split(":");

            // 채팅 시간을 초단위로 변경
            int time = Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
            // 개강총회 시작 전에 채팅을 쳤으면 before에 추가한다.
            if(time <= start) {
               before.add(arr[1]);
            // 개강총회 종료와 스트리밍 종료 사이에 채팅을 쳤고, 시작 전에 채팅을 쳤으면 attend에 추가한다.
            } else if(time >= end && time <= stream) {
               if(before.contains(arr[1])) {
            	  attend.add(arr[1]);
               }
            // 채팅 기록이 스트리밍 종료시간 이후라면 더이상 확인이 필요없으므로 break 해준다.
            } else if(time > stream) break;
        }
        
        // attend의 size 만큼 출석처리가 된다.
        System.out.println(attend.size());

    }

}