import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_G5_13549_숨바꼭질3 {

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);

        int N = scann.nextInt();
        int K = scann.nextInt();

        Deque<int []> deq = new ArrayDeque<>();
        deq.add(new int[]{N, 0});
        boolean [] v = new boolean[100001];
        v[N] = true;
        int ans = -1;

        while(!deq.isEmpty()) {
            int [] cur = deq.pollFirst();
            int l = cur[0];

            if(l == K) {
                ans = cur[1];
                break;
            }

            if(l*2 <= 100000 && !v[l*2]) {
                deq.addFirst(new int[]{l*2, cur[1]});
                v[l*2] = true;
            }

            if(l-1 >= 0 && !v[l-1]) {
                deq.add(new int[]{l-1, cur[1] + 1});
                v[l-1] = true;
            }

            if(l+1 <= 100000 && !v[l+1]) {
                deq.add(new int[]{l+1, cur[1] + 1});
                v[l+1] = true;
            }

        }

        System.out.println(ans);

    }

}
