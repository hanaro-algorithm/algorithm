const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

// N: 도시의 개수, M: 도로의 개수, K: 거리 정보, X: 출발 도시 번호
const [N, M, K, X] = input[0].split(" ").map(Number);
let cities = Array.from({ length: N + 1 }, () => []);
for (let i = 1; i <= M; i += 1) {
    const [A, B] = input[i].split(" ").map(Number);
    cities[A].push(B);
}

let visited = Array.from({ length: N + 1 }).fill(false); // 방문 여부
let result = new Array(N + 1).fill(0); // 최단거리 배열

function dfs(city, depth) {
    // depth가 K 이상 혹은 기존 거리길이보다 depth의 길이가 길면 dfs 수행안함
    if (depth > K || (result[city] !== 0 && result[city] < depth)) return;
    visited[city] = true; // 방문 표시
    result[city] = depth; // 거리 길이 넣기

    // 인접해 있는 도로로 이동
    for (let c of cities[city]) {
        if (!visited[c]) dfs(c, depth + 1);
    }
    visited[city] = false;
}

dfs(X, 0);

let found = false;
let answer = "";
result.map((r, idx) => {
    if (r === K) {
        answer += idx + "\n";
        found = true;
    }
});
if (!found) answer += -1;

console.log(answer);
