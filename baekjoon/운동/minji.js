const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [V, E] = input[0].split(' ').map(Number);

const INF = Number.MAX_SAFE_INTEGER;

const lines = Array.from({ length: V + 1 }, () => new Array(V + 1).fill(INF));

for (let i = 1; i <= E; i++) {
    const [a, b, c] = input[i].split(' ').map(Number);
    lines[a][b] = c;
}

for (let k = 1; k <= V; k++) {
    for (let i = 1; i <= V; i++) {
        for (let j = 1; j <= V; j++) {
            lines[i][j] = Math.min(lines[i][j], lines[i][k] + lines[k][j]);
        }
    }
}

let answer = Number.MAX_SAFE_INTEGER;
for (let i = 1; i <= V; i++) {
    answer = Math.min(answer, lines[i][i]);
}

console.log(answer !== Number.MAX_SAFE_INTEGER ? answer : -1);
