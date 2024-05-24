const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0];
let map = [];
for (let i = 1; i <= N; i += 1) {
    map.push(input[i].split("").map(Number));
}

let visited = Array.from({ length: N }, () => new Array(N).fill(false)); // 방문 표시
let dx = [-1, 0, 1, 0];
let dy = [0, -1, 0, 1];
let count = 1;
let answer = [];

for (let i = 0; i < N; i += 1) {
    for (let j = 0; j < N; j += 1) {
        if (!visited[i][j] && map[i][j] === 1) {
            count = 1;
            dfs(i, j);
            answer.push(count);
        }
    }
}

function dfs(x, y) {
    visited[x][y] = true;
    for (let i = 0; i < 4; i += 1) {
        let nx = x + dx[i];
        let ny = y + dy[i];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if (!visited[nx][ny] && map[nx][ny] === 1) {
            count += 1;
            dfs(nx, ny);
        }
    }
}

console.log(answer.length);
answer.sort((a, b) => a - b);
answer.map((a) => console.log(a));
