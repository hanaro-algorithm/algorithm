import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String startTime = st.nextToken();  // 개강총회 시작 시간
        String endTime = st.nextToken();    // 개강총회 끝난 시간
        String streamingEndTime = st.nextToken();  // 스트리밍 끝난 시간

        Set<String> attendees = new HashSet<>();  // 개강총회에 입장한 사람들
        Set<String> presentUntilEnd = new HashSet<>();  // 끝까지 남아있는 사람들

        String log;
        while ((log = br.readLine()) != null) {
            st = new StringTokenizer(log);
            String time = st.nextToken();
            String student = st.nextToken();

            // 개강총회 시작 전에 입장한 경우 기록
            if (time.compareTo(startTime) <= 0) {
                attendees.add(student);
            }
            // 개강총회 종료 이후부터 스트리밍 끝날 때까지의 퇴장 기록 확인
            if (time.compareTo(endTime) >= 0 && time.compareTo(streamingEndTime) <= 0) {
                if (attendees.contains(student)) {
                    presentUntilEnd.add(student);
                }
            }
        }

        System.out.println(presentUntilEnd.size());
    }
}
