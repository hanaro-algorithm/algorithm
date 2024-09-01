import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] tri = new long[101];
        tri[1] = 1;
        tri[2] = 1;
        for(int i = 3; i <= 100; i++) {
            tri[i] = tri[i-2] + tri[i-3];
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            bw.write(String.valueOf(tri[Integer.parseInt(br.readLine())]));
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}