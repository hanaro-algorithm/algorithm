import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int left = 1;
        int right = num * 5;

        boolean check = false;

        while (left <= right){
            int mid = (left + right) / 2;
            if(find(mid) > num){
                right = mid - 1;
            } else if(find(mid) == num){
                right = mid - 1;
                check = true;
            } else {
                left = mid + 1;
            }
        }
        if(check){
            System.out.println(left);
        } else {
            System.out.println(-1);
        }
    }
    private static int find(int mid){
        int cnt = 0;
        for(int i = 5; i <= mid; i*=5){
            cnt += (mid / i);
        }
        return cnt;
    }
}