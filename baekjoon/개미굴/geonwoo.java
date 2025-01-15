import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_G3_14725_개미굴 {
	static class Node {
		Map<String, Node> next;

		// next를 TreeMap으로 선언하여 자동으로 key를 기준으로 오름차순 정렬된다.
		public Node() {
			next = new TreeMap<String, Node>();
		}
	}
	
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// 개미굴의 입구가 될 루트 노드
		Node root = new Node();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			// 처음은 루트 노드에서 시작한다.
			Node node = root;
			
			// 1. 단어를 현재 노드에서 찾는다.
			// 2. 현재 노드에 단어가 있으면, 해당 노드를 그대로 사용한다.
			// 3. 현재 노드에 단어가 없으면, 노드를 새롭게 등록한다.
			// 4. 다음 단어가 들어오면, 방금 사용했거나 등록했던 노드부터 다시 1번을 진행한다.
			for (int j = 0; j < K; j++) {
				node = node.next.computeIfAbsent(st.nextToken(), str -> new Node());
			}
		}
		
		// 루트 노드부터 모든 단어를 탐색한다.
		dfs(root, 0);
		
		System.out.println(sb.toString());		
		
	}

	private static void dfs(Node node, int depth) {
		// 현재 노드에 달려있는 자식들을 모두 확인한다. (TreeMap으로 되어있기 때문에 자동으로 정렬된다.)
		for(String str : node.next.keySet()) {
			// 단어의 깊이만큼 "--"를 추가한다.
			for (int i = 0; i < depth; i++) {
				sb.append("--");
			}
			// 단어를 출력한다.
			sb.append(str+"\n");
			// dfs 방식으로 현재 str의 자식이 있다면 계속해서 탐색한다.
			dfs(node.next.get(str), depth+1);
		}
	}

}
