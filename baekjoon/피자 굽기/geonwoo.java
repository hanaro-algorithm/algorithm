import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_1756_피자굽기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [] oven = new int[D+1];
        oven[0] = Integer.MAX_VALUE;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < D+1; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
            oven[i] = Math.min(oven[i-1], oven[i]);
        }
        
        int ans = D;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int len = Integer.parseInt(st.nextToken());
            
            boolean check = false;
            
            for (int j = ans; j > 0; j--) {
                if (len <= oven[j]) {
                    ans = j;
                    oven[j] = 0;
                    check = true;
                    break;
                }
            }

            if (!check) {
                ans = 0;
                break;
            }
        }

        System.out.println(ans);

	}

}
