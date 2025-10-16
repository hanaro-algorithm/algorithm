import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2313_보석구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long ans = 0;

        for (int i = 0; i < N; i++) {
            int L = Integer.parseInt(br.readLine());
            long [] jewels = new long[L];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < L; j++) {
                jewels[j] = Long.parseLong(st.nextToken());
            }

            long max = jewels[0];
            long sum = jewels[0];
            int maxL = 0;
            int maxR = 0;
            int left = 0;

            for (int j = 1; j < L; j++) {
                if(sum <= 0) {
                	sum = jewels[j];
                	left = j;
                } else {
                	sum += jewels[j];
                }

                if(sum > max) {
                    max = sum;
                    maxL = left;
                    maxR = j;
                } else if(sum == max && ((maxR-maxL) > (j-left))) {
                    maxL = left;
                    maxR = j;
                }

            }

            ans += max;
            sb.append((maxL + 1)).append(" ").append(maxR + 1).append("\n");
        }

        System.out.println(ans);
        System.out.println(sb.toString());

    }
}