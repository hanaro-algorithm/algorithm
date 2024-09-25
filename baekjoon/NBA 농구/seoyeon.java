import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferReader br = new BufferReader(new InputStreamReader(System.in));
        BufferReader bw = new BufferReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int score1 = 0;
        int score2 = 0;

        int lastLeadChangeTime = 0;

        int leadTime1 = 0;
        int leadTime2 = 0;

        int endTime = 60 * 48;

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt();

            String[] strTime = st.nextToken().split(":");
            int scoreTime = Integer.parseInt(strTime[0]) * 60 + Integer.parseInt(strTime[1]);

            if(score1 > score2){
                leadTime1 += scoreTime - lastLeadChangeTime;
            } else if(score2 > score1){
                leadTime2 += scoreTime - lastLeadChangeTime;
            }

            if(team == 1){
                score1++;
            } else {
                score2++;
            }
            lastLeadChangeTime = scoreTime;
        }
        if(score1 > score2){
            leadTime1 += endTime - lastLeadChangeTime;
        } else if(score2 > score1){
            leadTime2 += endTime - lastLeadChangeTime;
        }

        int min1 = leadTime1 / 60;
        int sec1 = leadTime1 % 60;
        int min2 = leadTime2 / 60;
        int sec2 = leadTime2 % 60;

        bw.write(String.format("%02d:%02d\n", min1, sec1));
        bw.write(String.format("%02d:%02d\n", min2, sec2));

        bw.flush();
    }
}