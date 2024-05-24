import java.util.*;

class Solution {

    //정답 후보
    private static List<String> path = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        List<String[]> ticket = Arrays.asList(tickets);
        boolean[] visited = new boolean[ticket.size()];

        //dfs
        dfs(ticket, "ICN", "ICN", 0, visited );

        Collections.sort(path);

        answer = path.get(0).split(" ");
        return answer;
    }



    public static void dfs(final List<String[]> tickets, String start, String route, int index, final boolean[] visited){
        if(index == tickets.size()){
            path.add(route);
            return;
        }

        for(int i = 0; i < tickets.size(); i++){
            String[] next = tickets.get(i);
            String nextDestination = next[1];

            if(!visited[i] && next[0].equals(start)){

                visited[i] = true;
                dfs(tickets, nextDestination, route + " " + nextDestination, index + 1, visited);
                visited[i] = false;
            }
        }
    }
}