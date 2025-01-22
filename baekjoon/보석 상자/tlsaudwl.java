import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 보석 색상 수

        int[] jewels = new int[M];
        int maxJewel = 0;

        for(int i=0; i<M; i++){
            jewels[i] = Integer.parseInt(br.readLine());
            maxJewel = Math.max(maxJewel, jewels[i]);
        }

        int left =1;
        int right = maxJewel;

        while(left<right){
            int mid = (left+right)/2;

            int student = 0; // mid를 기준으로 필요한 학생 수
            for(int jewel : jewels){
                student = student + (jewel + mid - 1) / mid;
            }

            if(student <= N){
                right = mid;
            } else{
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
