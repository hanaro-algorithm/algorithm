import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int[] numbers = new int[M];
        for (int i = 0; i < M; i++) {
            numbers[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            int target = numbers[i];

            // 타겟의 현재 위치 확인
            int index = deque.indexOf(target);

            int halfIndex;
            if (deque.size() % 2 == 0) {
                halfIndex = deque.size() / 2 - 1;
            } else {
                halfIndex = deque.size() / 2;
            }

            // 회전 방향 선택
            if (index <= halfIndex) {
                // 2번 연산
                for (int j = 0; j < index; j++) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            } else {
                // 3번 연산
                for (int j = 0; j < deque.size() - index; j++) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }
}
