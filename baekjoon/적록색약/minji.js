const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0];
let area = [];
for (let i = 1; i <= N; i += 1) {
    area.push(input[i].split(""));
}
let nonblindnessCnt = 0;
let blindnessCnt = 0;

let dx = [-1, 0, 1, 0];
let dy = [0, -1, 0, 1];

let nonblindnessVisited = Array.from({ length: N }, () =>
    new Array(N).fill(false)
);
let blindnessVisited = Array.from({ length: N }, () =>
    new Array(N).fill(false)
);

for (let i = 0; i < N; i += 1) {
    for (let j = 0; j < N; j += 1) {
        let color = area[i][j];
        if (!nonblindnessVisited[i][j]) {
            nonblindnessDfs(i, j, color);
            nonblindnessCnt += 1;
        }
        if (!blindnessVisited[i][j]) {
            blindnessDfs(i, j, color);
            blindnessCnt += 1;
        }
    }
}

function blindnessDfs(x, y, color) {
    blindnessVisited[x][y] = true;
    for (let i = 0; i < 4; i += 1) {
        let nx = x + dx[i];
        let ny = y + dy[i];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if (!blindnessVisited[nx][ny]) {
            if (color === "B") {
                if (area[nx][ny] === color) blindnessDfs(nx, ny, color);
            } else {
                if (area[nx][ny] === "R" || area[nx][ny] === "G")
                    blindnessDfs(nx, ny, color);
            }
        }
    }
}

function nonblindnessDfs(x, y, color) {
    nonblindnessVisited[x][y] = true;
    for (let i = 0; i < 4; i += 1) {
        let nx = x + dx[i];
        let ny = y + dy[i];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if (!nonblindnessVisited[nx][ny] && area[nx][ny] === color) {
            nonblindnessDfs(nx, ny, color);
        }
    }
}

console.log(nonblindnessCnt + " " + blindnessCnt);
