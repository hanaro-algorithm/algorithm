import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G3_12764_싸지방에간준하 {
    static int N;
    static List<Time> list;
    static int [] used = new int[100001];
    
    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (this.start == o.start) return Integer.compare(this.end, o.end);
            return Integer.compare(this.start, o.start);
        }
    }

    static class Com implements Comparable<Com> {
        int idx;
        int endTime;

        public Com(int idx, int endTime) {
            this.idx = idx;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Com o) {
            return Integer.compare(this.endTime, o.endTime);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        // 사람들의 시작 시간, 종료 시간을 저장할 리스트
        list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            list.add(new Time(start, end));
        }
        
        // 시작 시간이 빠른 순서대로, 종료 시간이 빠른 순서대로 정렬한다.
        Collections.sort(list);

        // 사용중인 컴퓨터를 저장할 pq
        PriorityQueue<Com> using = new PriorityQueue<>();
        // 비어있는 컴퓨터의 번호를 저장할 pq
        PriorityQueue<Integer> remain = new PriorityQueue<>();
        
        // 컴퓨터를 몇 대 이용중인지 저장할 변수
        int cnt = 0;

        for (Time now : list) {
        	// 사용중인 컴퓨터 중 현재 사람의 시작 시간보다 종료 시간이 작은 컴퓨터를 모두 remain으로 보낸다.
            while (!using.isEmpty() && using.peek().endTime < now.start) {
            	remain.add(using.poll().idx);
            }

            // 사용 가능한 컴퓨터가 있으면 정해진 시간까지 이용한다.
            // pq를 사용했기 때문에 번호가 가장 작은 컴퓨터를 사용한다.
            if (!remain.isEmpty()) {
                int idx = remain.poll();
                using.add(new Com(idx, now.end));
                used[idx]++;
            // 사용 가능한 컴퓨터가 없을 경우 새로운 자리를 만들고 그곳에서 정해진 시간까지 이용한다.
            } else {
                cnt++;
                using.add(new Com(cnt, now.end));
                used[cnt]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt+"\n");
        
        for (int i = 1; i <= cnt; i++) {
        	sb.append(used[i]+" ");
        }
        
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
        
    }
}