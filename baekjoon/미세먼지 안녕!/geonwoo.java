import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
 
public class BOJ_G4_17144_미세먼지안녕 {
    static int N, M, T, top, bottom;
    static int [][] map;
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // -1인 지점을 찾아 공기청정기의 위와 아래의 좌표를 지정한다.
        for (int i = 0; i < N; i++) {
            if (map[i][0] == -1) {
                top = i;
                bottom = i+1;
                break;
            }
        }
        
        // 매 초마다 먼저 먼지가 확산되고, 공기청정기가 가동된다.
        for (int i = 0; i < T; i++) {
            dust();
            air();      
        }
        
        int ans = 0;
        
        // 모든 좌표의 먼지를 더한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans += map[i][j];
            }
        }
 
        // 공기청정기의 값이 -1이므로 모두 더한 값에서 2를 추가로 더해준다.
        System.out.println(ans+2);
    }
 
    public static void air() {
    	// 위쪽 청소(반시계)
    	for (int r = top-1; r > 0; r--) {
            map[r][0] = map[r-1][0];
        }
  
        for (int c = 0; c < M-1; c++) {
            map[0][c] = map[0][c+1];
        }
  
        for (int r = 0; r < top; r++) {
            map[r][M-1] = map[r+1][M-1];
        }
        
        for (int c = M-1; c > 1; c--) {
            map[top][c] = map[top][c-1];
        }
        
        // 공기청정기 바로 앞은 미세먼지가 0이 된다.
        map[top][1] = 0;
 
        // 아래쪽 청소(시계)
        for (int r = bottom+1; r < N-1; r++) {
            map[r][0] = map[r+1][0];
        }
 
        for (int c = 0; c < M-1; c++) {
            map[N-1][c] = map[N-1][c+1];
        }
 
        for (int r = N-1; r > bottom; r--) {
            map[r][M-1] = map[r-1][M-1];
        }
 
        for (int c = M-1; c > 1; c--) {
            map[bottom][c] = map[bottom][c-1];
        }
 
        // 공기청정기 바로 앞은 미세먼지가 0이 된다.
        map[bottom][1] = 0;
        
    }
 
    public static void dust() {
    	// 1초 뒤의 맵의 상태를 저장할 newMap
        int [][] newMap = new int[N][M];
        
        // 일단 원래 맵의 정보를 모두 옮긴다.
        for (int i = 0; i < N; i++) {
			newMap[i] = Arrays.copyOf(map[i], M);
		}
        
        // 미세먼지가 있는 좌표에 대해 확산을 진행한다.
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
            	// -1인 경우는 공기청정기이므로 확산하지 않고, 0인 경우에는 확산할 먼지가 없다.
            	if(map[r][c] <= 0) continue;
            	
            	// 4가지 방향
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
 
                    // 맵을 벗어나거나, 공기청정기 지역이라면 넘어간다.
                    if (!check(nr, nc) || map[nr][nc] == -1) continue;
 
                    // 현재 위치에서 5로 나눈 값을 뺀다.
                    newMap[r][c] -= (map[r][c]/5);
                    // 확산될 위치에 5로 나눈 값을 더한다.
                    newMap[nr][nc] += (map[r][c]/5);
                }
            }
        }
        
        // 확산한 맵으로 교체한다.
        map = newMap;
        
    }

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
    
}