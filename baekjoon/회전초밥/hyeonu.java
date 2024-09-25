import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        int[] arr = new int[N+k-1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0;
        for(int i = N; i < arr.length; i++){
            arr[i] = arr[idx++];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length - k; i++) {
            set.clear();
            for (int j = 0 ; j < k; j++) {
                set.add(arr[i+j]);
            }
            set.add(c);
            if(max < set.size())
                max = set.size();
        }
        System.out.println(max);
    }
}