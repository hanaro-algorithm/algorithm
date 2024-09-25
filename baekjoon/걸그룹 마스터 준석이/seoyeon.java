import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 걸그룹 수
        int m = Integer.parseInt(st.nextToken()); // 퀴즈의 수
        Map<String, List<String>> map = new HashMap<>(); // 걸그룹 정보를 저장할 Map

        // 각 걸그룹 정보를 입력받고 map에 저장
        for (int i = 0; i < n; i++) {
            String group = br.readLine(); // 팀 이름
            int num = Integer.parseInt(br.readLine()); // 걸그룹의 인원 수
            List<String> list = new ArrayList<>(); // 멤버의 이름을 저장할 List
            for (int j = 0; j < num; j++) {
                list.add(br.readLine()); // 멤버의 이름을 List에 추가
            }
            map.put(group, list); // 팀의 이름과 멤버 목록을 map에 저장
        }
        StringBuilder sb = new StringBuilder(); // 출력 결과를 저장할 StringBuilder

        // M개의 퀴즈에 대한 답을 처리
        for (int i = 0; i < m; i++) {
            String name = br.readLine(); // 퀴즈에 해당하는 팀의 이름 또는 멤버의 이름
            int member = Integer.parseInt(br.readLine()); // 퀴즈의 종류 (0 또는 1)

            // 퀴즈의 종류가 1일 경우 (멤버 이름으로 팀 찾기)
            if (member == 1) {
                for (String group : map.keySet()) { // 모든 팀을 순회하며
                    if (map.get(group).contains(name)) { // 해당 멤버가 포함되어 있는 팀을 찾음
                        sb.append(group + "\n"); // 해당 팀의 이름을 출력 결과에 추가
                        break;
                    }
                }
            // 퀴즈의 종류가 0일 경우 (팀 이름으로 멤버 찾기)
            } else {
                List<String> list = map.get(name); // 해당 팀의 멤버 목록을 가져옴
                Collections.sort(list); // 멤버 이름을 사전순으로 정렬
                for (String memberName : list) {
                    sb.append(memberName + "\n"); // 멤버의 이름을 출력 결과에 추가
                }
            }
        }

        System.out.println(sb);

    }

}