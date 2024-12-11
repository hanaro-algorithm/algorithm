import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_3758_KCPC {
	static class Team implements Comparable<Team> {
		// 팀 아이디
		int id;
		// 점수 총합
		int score;
		// 제출 횟수
		int trial;
		// 마지막 제출 시간
		int updated;
		
		public Team(int id, int score, int trial, int updated) {
			this.id = id;
			this.score = score;
			this.trial = trial;
			this.updated = updated;
		}

		@Override
		public int compareTo(Team o) {
			// 1순위 : 점수
			if(this.score == o.score) {
				// 2순위 : 제출 횟수
				if(this.trial == o.trial) {
					// 3순위 : 마지막 제출 시간
					return Integer.compare(this.updated, o.updated);
				} else {
					return Integer.compare(this.trial, o.trial);
				}
			} else {
				return Integer.compare(o.score, this.score);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int ID = Integer.parseInt(st.nextToken())-1;
			int M = Integer.parseInt(st.nextToken());
			
			// 팀별 각 문제에 대한 점수를 저장할 2차원 배열
			int [][] score = new int[N][K];
			// 모든 팀을 저장할 1차원 배열
			Team [] teams = new Team[N];
			
			// 모든 팀을 초기세팅 해준다.
			for (int i = 0; i < N; i++) {
				teams[i] = new Team(i, 0, 0, -1);
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int I = Integer.parseInt(st.nextToken())-1;
				int J = Integer.parseInt(st.nextToken())-1;
				int S = Integer.parseInt(st.nextToken());
				
				// J번째 문제에 대해 I팀이 더 큰 점수를 받았다면 이를 업데이트한다.
				teams[I].score += Math.max(0, S-score[I][J]);
				score[I][J] = Math.max(score[I][J], S);
				
				// I팀의 제출 횟수를 늘린다.
				teams[I].trial++;
				// I팀의 마지막 제출 시간을 업데이트한다.
				teams[I].updated = i;
			}
			
			// 모든 팀을 정해진 순서대로 정렬한다.
			Arrays.sort(teams);
			
			// 나의 팀 순위를 찾는다.
			int rank = 1;
			for (int i = 0; i < N; i++) {
				if(teams[i].id == ID) break;
				rank++;
			}
			
			sb.append(rank+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

}
