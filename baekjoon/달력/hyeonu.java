import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[366];
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            for (int i = S; i <= E; i++) {
                cnt[i]++;
            }
        }
        int w = 0, h = 0, ans = 0;
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] == 0) {
                ans+=w*h;
                w=0;
                h=0;
            }

            if(cnt[i] > 0){
                w++;
                h = Math.max(h, cnt[i]);
            }
        }
        ans+=w*h;
        System.out.println(ans);
    }
}
