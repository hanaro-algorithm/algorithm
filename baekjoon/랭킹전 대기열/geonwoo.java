import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S2_20006_랭킹전대기열 {
	static class Player implements Comparable<Player> {
		int level;
		String name;
		
		public Player(int level, String name) {
			this.level = level;
			this.name = name;
		}

		@Override
		public int compareTo(Player o) {
			return this.name.compareTo(o.name);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int P = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<ArrayList<Player>> list = new ArrayList<>();
		
		outer:
			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				int level = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				
				for(ArrayList<Player> room : list) {
					if(room.size() == M) continue;
					
					int standard = room.get(0).level;
					
					if(level >= standard-10 && level <= standard+10) {
						room.add(new Player(level, name));
						continue outer;
					}
				}
				
				list.add(new ArrayList<>());
				int idx = list.size()-1;
				list.get(idx).add(new Player(level, name));
			}
		
		for (ArrayList<Player> room : list) {
			Collections.sort(room);
			
			if(room.size() == M) {
				sb.append("Started!\n");
			} else {
				sb.append("Waiting!\n");
			}
			
			for(Player p : room) {
				sb.append(p.level+" "+p.name+"\n");
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

}


