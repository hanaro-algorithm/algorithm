import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = 0;
        int now = 0;
        int changeIdx = 0;
        int pictureSize = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] student = new int[pictureSize];
        int[] recommend = new int[pictureSize];
        int[] time = new int[pictureSize];

        total = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < total; i++) {

            now = Integer.parseInt(st.nextToken());

            changeIdx = 0;


            for (int j = 0; j < pictureSize; j++) {
                if (student[j] == 0 || student[j]==now) {
                    changeIdx = y;
                    break;
                }

                if (recommend[changeIdx] > recommend[y] || (recommend[changeIdx] == recommend[y] && time[changeIdx] > time[y])) {
                    changeIdx = y;
                }
            }

            if(student[changeIdx]!=now){
                student[changeIdx] = now;
                recommend[changeIdx] = 0;
                time[changeIdx] = x;
            }

            recommend[changeIdx]++;
        }

        Arrays.sort(student);

        for(int x : student){
            if(x!=0)
                bw.write(String.valueOf(x)+" ");

        }

        bw.flush();
    }


}