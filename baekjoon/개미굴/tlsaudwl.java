import java.util.*;

public class Main {

    static class Node {
        TreeMap<String, Node> children = new TreeMap<>(); // 자식 노드를 정렬하기 위해 TreeMap 사용
    }

    // 트리에 데이터 추가
    static void add(Node root, String[] foods) {
        Node current = root;
        for (String food : foods) {
            current.children.putIfAbsent(food, new Node()); // 해당 음식이 없으면 새 노드 추가
            current = current.children.get(food); // 다음 노드로 이동
        }
    }

    // 트리 구조를 출력
    static void print(Node node, int depth) {
        for (String key : node.children.keySet()) {
            // "--"를 깊이에 따라 출력
            for (int i = 0; i < depth; i++) {
                System.out.print("--");
            }
            System.out.println(key); // 현재 음식 출력
            print(node.children.get(key), depth + 1); // 자식 노드 출력
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정보 개수
        Node root = new Node(); // 트리의 루트 노드 생성

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt(); // 먹이 정보 개수
            String[] foods = new String[k];
            for (int j = 0; j < k; j++) {
                foods[j] = sc.next(); // 먹이 정보 입력
            }
            add(root, foods); // 트리에 데이터 추가
        }

        print(root, 0); // 트리 출력
    }
}
