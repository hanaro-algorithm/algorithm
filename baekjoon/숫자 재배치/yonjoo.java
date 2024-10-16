import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static Set<Integer> numbers; // 중복 제거를 위해 Set 사용
    static String A;

    public static void DFS(String s, int depth) {
        if (depth == 0) {
            // 첫 번째 숫자가 '0'인 경우는 무시
            if (s.charAt(0) != '0') {
                numbers.add(Integer.parseInt(s));
            }
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true; // 현재 숫자를 사용 중으로 표시
                DFS(s + A.charAt(i), depth - 1); // 현재 숫자를 추가하고 깊이를 줄임
                visited[i] = false; // 사용 후 다시 원래 상태로 복구
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int lenA = A.length();

        if(Integer.parseInt(A) > B) {
            System.out.println(-1);
            return;
        }

        numbers = new HashSet<>(); // Set으로 중복 제거
        visited = new boolean[lenA];

        for (int i = 1; i <= lenA; i++) {
            DFS("", i); // 각 자리수 길이에 대해 DFS 수행
        }

        // 정렬 후 출력
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers, Collections.reverseOrder());
//        for(int i : sortedNumbers){
//            System.out.println(i);
//        }

        int ans = -1;
        for (int num : sortedNumbers) {
            if(num < B) {
                ans = num;
                System.out.println(num);
                return;
            }
        }
    }
}
