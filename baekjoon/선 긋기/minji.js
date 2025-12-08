const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 선을 그은 횟수

let lines = [];
for (let i = 1; i <= N; i++) lines.push(input[i].split(' ').map(Number));
lines.sort((a, b) => a[0] - b[0] || b[1] - a[1]); // x기준 오름차순 정렬, 같으면 y기준 내림차순 정렬

let answer = 0;
let area = [...lines[0]];
for (let line = 1; line < lines.length; line++) {
    const [x, y] = lines[line];
    // 이전에 그은 선과 겹치는지 확인
    if (x < area[1]) {
        if (area[1] < y) area[1] = y;
    } else {
        // 아예 다른 곳에 선이 그어진 경우
        answer += Math.abs(area[1] - area[0]);
        area = [x, y];
    }
}
answer += Math.abs(area[1] - area[0]);

console.log(answer);
