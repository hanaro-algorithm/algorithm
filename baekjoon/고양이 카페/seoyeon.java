import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 고양이 수
        long k = Long.parseLong(st.nextToken()); // 한 명 최대 무게

        ArrayList<Long> weight = new ArrayList<>(); // 고양이 무게 저장
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            weight.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(weight);

        int temp = weight.size() - 1;  // 행복해질 수 있는 사람 최댓값
        int count = 0;

        while (!weight.isEmpty() && 0 < temp && weight.get(0) <= k) {
            if (weight.get(0) + weight.get(temp) <= k) {
                weight.remove(temp);
                weight.remove(0);
                temp = weight.size() - 1;
                count++;
            }
            else {
                temp--;
            }
        }
        System.out.println(count);
    }
}