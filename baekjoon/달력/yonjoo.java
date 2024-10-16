import java.io.*;
import java.util.*;

/*
List.sort 해서 쓰지말고 PriorityQueue 쓰기
 */
public class Main {

    class Schedule {
        int start;
        int end;
        int length;

        Schedule(int start, int end){
            this.start = start;
            this.end = end;
            this.length = end - start + 1;
        }
    }

    private static boolean[][] flag;

    private int solution(int[][] schedules){
        int answer = 0;

//        List<Schedule> list = new ArrayList<>();
        PriorityQueue<Schedule> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.start == o2.start) return Integer.compare(o2.length, o1.length); //일정순으로 정렬하라는 조건 간과 ㄴㄴ
            return Integer.compare(o1.start, o2.start);
        }); //List보다는 PriorityQueue

        flag = new boolean[schedules.length][366]; //N이 최대 1000이니까

        for(int[] sc : schedules){
            Schedule schedule = new Schedule(sc[0], sc[1]);
            pq.add(schedule);
        }

        //색칠
        while(!pq.isEmpty()){
            Schedule curr = pq.poll();
            for(int i = 0; i < flag.length; i++){
                if(isEmpty(i, curr.start, curr.end)) {
                    write(i++, curr.start, curr.end);
                    break;
                }
            }
        }


        /*
        x축 border 구하기
        
        Xcut example : [ # ###   ##### ## ]
        
        투포인터로 할 수는 있을듯?
         */
        boolean[] Xcut = new boolean[366];
        for(int i = 1; i < 366; i++){
            int row = 0;
            for(; row < flag.length; row++){
                if(flag[row][i]) break;
            }

            if(row == flag.length){
                Xcut[i] = true;
            }
        }

        Queue<Schedule> borders = new LinkedList<>(); //x축 border로 나눠지는 덩어리들
        for(int i = 1; i < 366; i++){
            int start, end;
            while(i < 366 && Xcut[i]){
                i++;
            }
            start = i; //시작 날짜

            while(i < 366 && !Xcut[i]){
                i++;
            }
            end = i - 1; //끝 날짜

            Schedule s = new Schedule(start, end);
            borders.offer(s);
        }


        /*
        y축 border 구하는 동시에 바로 시트지 넓이 구해서 answer에 더하기
         */
        while(!borders.isEmpty()){ //x축으로 나눈 border 마다 max height 구하기
            Schedule curr = borders.poll();
            int max = 0;
            for(int i = curr.start; i <= curr.end; i++){
                for(int row = flag.length - 1; row >= 0; row--){
                    if(flag[row][i]){
                        max = Math.max(max, row);
                        break;
                    }
                }
            }
            answer += (max + 1 ) * curr.length; // curr 영역에서 max height * current 영역의 x축 길이
        }

        return answer;
    }


    // 달력의 row 번째 열에 스케쥴 표시해도 되는지 확인
    private boolean isEmpty(int row, int start, int end){
        for(int i = start; i <= end; i++){
            if(flag[row][i]) return false;
        }
        return true;
    }


    // row에 스케쥴 추가
    private void write(int row, int start, int end){
        for(int i = start; i <= end; i++){
            flag[row][i] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] schedules = new int[N][2];
        for(int i = 0;i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startDate = Integer.parseInt(st.nextToken());
            int endDate = Integer.parseInt(st.nextToken());

            schedules[i][0] = startDate;
            schedules[i][1] = endDate;
        }

        System.out.println(T.solution(schedules));

    }


}
