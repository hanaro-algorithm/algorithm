import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_16937_두스티커 {
	static int H, W, N, max;
	static int [][] sticker;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		sticker = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			sticker[i][0] = h;
			sticker[i][1] = w;
		}
		
		// 첫번째 스티커
		for (int i = 0; i < N; i++) {
			int h = sticker[i][0];
			int w = sticker[i][1];
			
			if((h > H || w > W) && (w > H || h > W)) continue;
			
			int size = h*w;
			
			int newH = H - h;
			int newW = W - w;
			
			if(newH >= 0 && newW >= 0) {
				findSecond(i, newH, newW, size);
			}
			
			newH = H - w;
			newW = W - h;
			
			if(newH >= 0 && newW >= 0) {
				findSecond(i, newH, newW, size);
			}
		}
		
		System.out.println(max);

	}

	// 두번째 스티커
	private static void findSecond(int idx, int newH, int newW, int size) {
		for (int i = idx+1; i < N; i++) {
			int h = sticker[i][0];
			int w = sticker[i][1];
			
			// 남은 공간에 들어갈 때(회전했을 경우 포함)
			if((H >= h && newW >= w) || (W >= h && newH >= w) || (H >= w && newW >= h) || (W >= w && newH >= h)) {
				max = Math.max(max, size+h*w);
			}
		}
		
	}

}
