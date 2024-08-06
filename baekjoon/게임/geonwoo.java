import java.util.Scanner;

public class BOJ_S3_1072_게임 {
	// 입력 값의 최대인 1000000000, 980000000이 들어왔을 때의 최대 판수는 1000000000이다.
	static final int INF = 1000000000;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int X = scann.nextInt();
		int Y = scann.nextInt();
		// Y*100을 하면 int의 범위를 벗어날 수 있으므로 long으로 선언한다.
		long Z = Y*100L/X;
		
		// 승률이 이미 99% 이상이면 아무리 게임을 해도 승률을 올릴 수 없다.
		if(Z >= 99) {
			System.out.println(-1);
			System.exit(0);
		}
		
		// 최소 1판은 이겨야 승률이 바뀔 수 있다.
		long left = 1;
		// 최대 1000000000을 이겨야 승률이 바뀔 수 있다.
		long right = INF;
		long ans = INF;
		
		// 이분탐색 알고리즘 사용
		while(left <= right) {
			long mid = (left + right) / 2;
			
			// mid판 만큼 추가로 했을 때 승률이 오르는지 확인한다.
			// 오른다면 right를 mid-1로, 오르지 않는다면 right를 mid+1로 바꿔준다.
			if((Y+mid)*100/(X+mid) >= Z+1) {
				ans = mid;
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		
		System.out.println(ans);

	}

}
