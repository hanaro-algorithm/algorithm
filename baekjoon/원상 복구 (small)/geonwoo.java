import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_22858_원상복구_small {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 카드의 번호를 저장할 배열
		int [] arr = new int[N];
		// 카드 배치 순서를 저장할 배열
		int [] D = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			D[i] = Integer.parseInt(st.nextToken())-1;
		}
		
		for (int i = 0; i < K; i++) {
			// arr의 카드 상태를 D 배열을 참고하여 한 단계 복구할 배열
			int [] newArr = new int[N];
			
			for (int j = 0; j < N; j++) {
				// 정해진 순서에 따라 카드의 배치를 복구한다.
				newArr[D[j]] = arr[j];
			}
			
			// arr를 newArr로 덮어쓴다.
			arr = newArr;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]+" ");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}
