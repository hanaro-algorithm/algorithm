import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();  // 개총 시작시간
        String E = st.nextToken();  // 개총 끝난시간
        String Q = st.nextToken();  // 개총 스트리밍 끝난 시간

        String str = null;  // 하나씩 확인할 채팅

        Set<String> before = new HashSet<>();  // 개총 시작 전 참여자
        Set<String> after = new HashSet<>();  // 개총 끝나고
        Set<String> nameSet = new HashSet<>();   // ?

        // 입력받고 쪼개는 로직
        while ((str = br.readLine()) != null){   // 입력
            String[] arr = str.split(" ");  // 빈칸을 기준으로 나눠줌
            String time = arr[0];
            String name = arr[1];

            nameSet.add(name);
            if(S.compareTo(time) >= 0){
                before.add(name);
            }
            else if(E.compareTo(time) <= 0 && Q.compareTo(time) >= 0){
                after.add(name);
            }
        }
        int answer = 0;
        for(String name : nameSet){
            if(before.contains(name) && after.contains(name)){
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}