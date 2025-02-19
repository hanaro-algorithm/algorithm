import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S3_25418_정수a를k로만들기 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int a = scann.nextInt();
		int k = scann.nextInt();
		
		boolean [] v = new boolean[k+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(a);
		
		int ans = 0;
		
		outer:
			while(!q.isEmpty()) {
				int size = q.size();
				
				for (int i = 0; i < size; i++) {
					int cur = q.poll();
					
					if(cur == k) break outer;
					
					int plus = cur+1;
					if(plus <= k && !v[plus]) {
						v[plus] = true;
						q.add(plus);
					}
					
					int multi = cur*2;
					if(multi <= k && !v[multi]) {
						v[multi] = true;
						q.add(multi);
					}
				}
				
				ans++;
				
			}
		
		System.out.println(ans);
		
	}

}
