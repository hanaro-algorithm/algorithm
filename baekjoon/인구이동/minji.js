const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

// N: 땅의 크기(NXN), L<=두 나라의 인구 차이<=R
const [N, L, R] = input[0].split(" ").map(Number);
let countries = [];
for (let i = 1; i <= N; i += 1) {
    const arr = input[i].split(" ").map(Number);
    countries.push(arr);
}

let day = 0;
let dx = [-1, 0, 1, 0];
let dy = [0, -1, 0, 1];

function bfs(x, y, index, visited) {
    let united = [[x, y]]; // (x, y)의 위치와 연결된 나라 정보 담기
    let queue = [];
    queue.push([x, y]);
    visited[x][y] = index; // 현재 연합 번호 할당
    let totalPerson = countries[x][y];
    let totalCountry = 1; // 현재 연합 국가 수
    while (queue.length !== 0) {
        let [x, y] = queue.shift();
        for (let i = 0; i < 4; i += 1) {
            let nx = x + dx[i];
            let ny = y + dy[i];
            if (
                nx >= 0 &&
                nx < N &&
                ny >= 0 &&
                ny < N &&
                visited[nx][ny] == -1
            ) {
                let dif = Math.abs(countries[nx][ny] - countries[x][y]);
                if (dif >= L && dif <= R) {
                    queue.push([nx, ny]);
                    visited[nx][ny] = index; // 연합에 추가
                    totalPerson += countries[nx][ny];
                    totalCountry += 1;
                    united.push([nx, ny]);
                }
            }
        }
    }
    // 연합 국가끼리 인구 분배
    for (let unit of united) {
        let [i, j] = unit;
        countries[i][j] = parseInt(totalPerson / totalCountry);
    }
}

while (true) {
    let visited = Array.from(Array(N), () => Array(N).fill(-1));
    let index = 0;
    for (let i = 0; i < N; i += 1) {
        for (let j = 0; j < N; j += 1) {
            if (visited[i][j] == -1) {
                bfs(i, j, index, visited);
                index += 1;
            }
        }
    }
    if (index == N * N) break; // 모든 인구 이동 끝난 경우
    day += 1;
}

console.log(day);
