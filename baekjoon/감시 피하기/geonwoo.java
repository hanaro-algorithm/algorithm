import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_18428_감시피하기 {
	static int N;
	static char [][] map;
    static ArrayList<int[]> list;
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
   
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        // 선생님들의 좌표를 저장할 리스트
        list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				// 선생님이라면 list에 좌표를 저장한다.
				if(map[i][j] == 'T') list.add(new int[] {i, j});
			}
		}
 
        // 비어있는 공간 중 장애물을 설치할 3곳을 고른다.
        pick(0, 0, 0);

        // 모든 경우의 수를 확인했는데 감시를 피할 수 없으면 NO를 출력한다.
        System.out.println("NO");
        
    }
 
    private static void pick(int cnt, int r, int c) {
    	// 장애물을 3개 설치했다면 감시를 피할 수 있는지 시뮬레이션 해본다.
    	if(cnt == 3){
    		// 감시를 피했다면 YES를 출력하고 바로 종료한다.
    		if(simul()) {
    			System.out.println("YES");
    			System.exit(0);
    		}
    		
    		return;
    	}
    	
    	// 모든 비어있는 공간 중 3곳에 장애물을 설치한다.
    	for (int i = r; i < N; i++) {
			int j = i == r ? c+1 : 0;
			for (; j < N; j++) {
				if(map[i][j] == 'X') {
					// 백트래킹 사용
					map[i][j] = 'O';
					pick(cnt+1, i, j);
					// 돌아온 후 X로 원상복구 시켜준다.
					map[i][j] = 'X';
				}
			}
		}
    }
 
   private static boolean simul() {
	   // 선생님들의 시야에 학생들이 존재하는지 확인한다.
	   for (int [] t : list) {
		   for (int d = 0; d < 4; d++) {
			   int nr = t[0];
			   int nc = t[1];
			   
			   // 맵을 벗어나거나 장애물을 만나기 전까지 학생을 마주치면 false를 리턴한다.
			   while (true) {
				   nr = nr + dr[d];
				   nc = nc + dc[d];
               
				   // 맵을 벗어난 경우
				   if(!check(nr, nc)) break;
               
				   // 학생을 발견한 경우
				   if(map[nr][nc] == 'S') return false;
				   // 장애물을 만난 경우
				   else if(map[nr][nc] == 'O') break;
			   }
		   }
	   }
 
	   // 모두 확인했지만 학생을 찾지 못하면 true를 리턴한다.
	   return true;   
   }

   private static boolean check(int r, int c) {
	   return r>=0 && r<N && c>=0 && c<N;
   }

}