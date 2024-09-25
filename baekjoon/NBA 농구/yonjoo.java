import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int firstTeamTime = 0;
        int secondTeamTime = 0;

        int winningTeam = 0;
        int prevTime = 0;

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int team = Integer.parseInt(input[0]);
            String[] timeParts = input[1].split(":");
            int currentTime = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);

            // 이전에 이기고 있던 팀의 시간을 계산
            if (winningTeam == 1) {
                firstTeamTime += (currentTime - prevTime);
            } else if (winningTeam == 2) {
                secondTeamTime += (currentTime - prevTime);
            }


            winningTeam = team;
            prevTime = currentTime;
        }

        // 마지막으로 남은 시간 : 초로 바꿈
        int endTime = 48 * 60;
        if (winningTeam == 1) {
            firstTeamTime += (endTime - prevTime);
        } else if (winningTeam == 2) {
            secondTeamTime += (endTime - prevTime);
        }

        System.out.printf("%02d:%02d\n", firstTeamTime / 60, firstTeamTime % 60);
        System.out.printf("%02d:%02d\n", secondTeamTime / 60, secondTeamTime % 60);
    }
}
