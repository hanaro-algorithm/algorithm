import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G5_25401_카드바꾸기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                int diff = nums[j] - nums[i];

                if(diff % (j-i) != 0) continue;

                int k = diff / (j-i);

                int cnt = 0;

                for (int l = 0; l < N; l++) {
                    int expect = nums[i] + (l-i)*k;
                    if(nums[l] != expect) cnt++;
                }

                min = Math.min(min, cnt);

            }
        }

        System.out.println(min);
    }

}
