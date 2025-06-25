import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G3_2473_세용액 {
	static int N;
	static int [] arr, ansArr;
	static long ansMin;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		ansMin = Long.MAX_VALUE;
		ansArr = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			if(ansMin == 0) break;
			
			find(i);
		}
		
		Arrays.sort(ansArr);
		
		StringBuilder sb = new StringBuilder();
		
		for(int n : ansArr) {
			sb.append(n+" ");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}


	private static void find(int idx) {
		int left = 0;
		int right = N-1;
		long pick = arr[idx];
		
		while(left < right) {
			if(left == idx) {
				left++;
				continue;
			} else if(right == idx) {
				right--;
				continue;
			}
			
			long sum = arr[left] + arr[right] + pick;
			
			if(Math.abs(sum) < ansMin) {
				ansMin = Math.abs(sum);
				ansArr[0] = (int)pick;
				ansArr[1] = arr[left];
				ansArr[2] = arr[right];
			}			
			
			if(sum > 0) {
				right--;
			} else if(sum < 0) {
				left++;
			} else {
				break;
			}
			
		}
		
	}

}
