import java.util.*;
import java.io.*;
public class Main(){
    static int[] num;
    public static void main(String[] args) throws IOException{
        BufferReader br = new BufferReader(new InputStreamReader(Sysetm.in));
        BufferWriter bw = new BufferWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num); //오름차순

        int x = Integer.parseInt(br.readLine());
        int result = sum(n, x);
        bw.write(result + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static int sum(int n, int x){
        int start= 0;
        int end = n-1;

        int cnt = 0;
        while(start < end){
            int tmp = num[start] + num[end];
            if(tmp > x){
                end--;
            }
            else{
                if(tmp == x){
                    cnt++;
                }
                start++;
            }
        }
        return cnt;
    }
}