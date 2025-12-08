const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let tc = +input[0]; // 테스트 케이스 개수
let line = 1;

let answer = '';
while (tc) {
    const n = +input[line++]; // 개수
    const prev = input[line++].split(''); // 원본
    const after = input[line++].split(''); // 원하는 결과 형태

    // 원본과 결과의 W, B 개수 카운트
    let prevCnt = [0, 0];
    let afterCnt = [0, 0];

    let diff = 0;
    for (let i = 0; i < n; i++) {
        prevCnt[prev[i] === 'W' ? 0 : 1] += 1;
        afterCnt[after[i] === 'W' ? 0 : 1] += 1;

        if (prev[i] !== after[i]) diff += 1;
    }

    let lackCnt = Math.abs(prevCnt[0] - afterCnt[0]);
    answer += (diff - lackCnt) / 2 + lackCnt + '\n';
    tc -= 1;
}
console.log(answer.trimEnd());
