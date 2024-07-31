import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        //오름차순 정렬 -> 가장 약한 로프 중량이 한계치 결정
        Arrays.sort(arr);
        //조합 다 찾아봄
        for(int i = 0; i < N; i++){
            //현재 로프 중량 * 현재 로프 포함 그 뒤 로프 개수
            int cur = arr[i] * (N - i);
            if(max < cur) max = cur;
        }
        System.out.println(max);
    }
}