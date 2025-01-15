import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_15312_이름궁합 {
	static final int [] alpha = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		int len = A.length();
		
		int [] arr = new int[2*len];
		for (int i = 0; i < len; i++) {
			arr[2*i] = alpha[A.charAt(i) - 'A'];
			arr[2*i+1] = alpha[B.charAt(i) - 'A'];
		}
		
		len *= 2;
		
		while(len > 2) {
			for (int i = 0; i < len-1; i++) {
				arr[i] = (arr[i] + arr[i+1]) % 10;
			}
			
			len--;
		}
		
		System.out.println(arr[0]+""+arr[1]);
		
	}

}
