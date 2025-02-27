import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, k;
        int[] arr, D, temp;
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        arr = new int[n + 1];
        D = new int[n + 1];

        s = br.readLine().split(" ");
        //k번 섞은 배열
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(s[i-1]);
        }

        s = br.readLine().split(" ");
        //D 배열
        for (int i = 1; i <= n; i++) {
            D[i] = Integer.parseInt(s[i-1]);
        }

        for (int i = 0; i < k; i++) {
            temp = new int[n+1];
            for (int j = 1; j <= n; j++) {
                temp[D[j]] = arr[j];
            }
            arr = temp;
        }

        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]+ " ");
        }
        System.out.println(sb.toString());

    }

}