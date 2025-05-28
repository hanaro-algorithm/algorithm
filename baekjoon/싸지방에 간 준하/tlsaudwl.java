import java.util.*;
import java.io.*;

public class Main {
    static class Person implements Comparable<Person> {
        int start, end;
        public Person(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Person o) {
            return this.start - o.start;
        }
    }

    static class Using {
        int end, compIdx;
        public Using(int end, int compIdx) {
            this.end = end;
            this.compIdx = compIdx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] users = new Person[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            int start = Integer.parseInt(tokens[0]);
            int end = Integer.parseInt(tokens[1]);
            users[i] = new Person(start, end);
        }

        Arrays.sort(users);

        // 종료 시간 기준으로 사용 중인 컴퓨터 관리
        PriorityQueue<Using> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        // 사용 가능한 컴퓨터 번호 관리 (항상 작은 번호 우선)
        TreeSet<Integer> available = new TreeSet<>();

        int[] usage = new int[n];
        int total = 0;

        for (Person user : users) {
            int now = user.start;

            while (!pq.isEmpty() && pq.peek().end <= now) {
                available.add(pq.poll().compIdx);
            }

            int compIdx;
            if (!available.isEmpty()) {
                compIdx = available.pollFirst();
            } else {
                compIdx = total++;
            }

            usage[compIdx]++;
            pq.offer(new Using(user.end, compIdx));
        }

        System.out.println(total);
        for (int i = 0; i < total; i++) {
            System.out.print(usage[i] + " ");
        }
    }
}
