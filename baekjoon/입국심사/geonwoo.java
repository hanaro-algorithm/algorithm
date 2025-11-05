import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_3079_입국심사 {
	static int N, M;
	static int [] T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    T = new int[N];
	    
	    long min = Long.MAX_VALUE;
	    
	    for (int i = 0; i < N; i++) {
	    	T[i] = Integer.parseInt(br.readLine());
	    	
	    	min = Math.min(min, T[i]);
	    }
	    
	    System.out.println(biSearch(min*M));
	    
	}
	
	static long biSearch(long min){
		long start = 0;
	    long end = min;
	    
	    while (start <= end) {
	    	long mid = (start + end) / 2;

	    	if(check(mid)) {
	    		end = mid-1;
	    	} else {
	    		start = mid+1;
	    	}
	    }
	    
	    return end+1;
	    
	  	}

	static boolean check(long mid){
		long sum = 0;
		
	    for (int i = 0; i < N; i++){
	    	sum += mid / T[i];
	    }
	    
	    return sum >= M;
	    
	}
	
}