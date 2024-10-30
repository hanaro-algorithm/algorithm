import java.util.Scanner;

public class BOJ_S1_14888_연산자끼워넣기 {
	
	static int N;
	static int [] nums;
	static int [] sign = new int[4];
	static int max;
	static int min;
	static boolean [] v;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = scann.nextInt();
		}
		
		for (int i = 0; i < 4; i++) {
			sign[i] = scann.nextInt();
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		perm(1, nums[0]);
		
		System.out.println(max);
		System.out.println(min);		
		
	}

	private static void perm(int cnt, int value) {
		if(cnt == N) {
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(sign[i] <= 0) continue;
			sign[i]--;
			
			switch (i) {
			case 0:
				perm(cnt+1, value+nums[cnt]);
				break;

			case 1:
				perm(cnt+1, value-nums[cnt]);
				break;
				
			case 2:
				perm(cnt+1, value*nums[cnt]);
				break;
				
			case 3:
				perm(cnt+1, value/nums[cnt]);
			}
			
			sign[i]++;
		}
	}

}