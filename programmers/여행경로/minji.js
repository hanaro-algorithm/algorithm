function solution(tickets) {
    let answer = [];
    let result = []; // DFS를 돌면서 방문하는 역 넣음
    let visited = []; // 방문표시

    let len = tickets.length;

    tickets.sort(); // 도착지를 알파벳 순으로 정렬하기 위한 정렬

    const dfs = (str, count) => {
        result.push(str); // 일단 해당역을 리스트에 삽입
        // 모든 경로를 다 거친 경우 종료
        if (count === len) {
            answer = result;
            return true;
        }

        for (let i = 0; i < len; i += 1) {
            if (!visited[i] && tickets[i][0] === str) {
                visited[i] = true; // 현재노드 방문 처리
                if (dfs(tickets[i][1], count + 1)) return true;
                visited[i] = false; // 현재노드 방문처리 취소
            }
        }
        result.pop(); // 다른 경로로 가지 못할 경우 최근 도착지 빼기
        return false;
    };

    dfs("ICN", 0);

    return answer;
}

console.log(
    solution([
        ["ICN", "JFK"],
        ["HND", "IAD"],
        ["JFK", "HND"],
    ])
);

console.log(
    solution([
        ["ICN", "SFO"],
        ["ICN", "ATL"],
        ["SFO", "ATL"],
        ["ATL", "ICN"],
        ["ATL", "SFO"],
    ])
);

console.log(
    solution([
        ["ICN", "SFO"],
        ["ICN", "ATL"],
        ["SFO", "ICN"],
    ])
);

console.log(
    solution([
        ["ICN", "BOO"],
        ["ICN", "COO"],
        ["COO", "DOO"],
        ["DOO", "COO"],
        ["BOO", "DOO"],
        ["DOO", "BOO"],
        ["BOO", "ICN"],
        ["COO", "BOO"],
    ])
); //["ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"]
