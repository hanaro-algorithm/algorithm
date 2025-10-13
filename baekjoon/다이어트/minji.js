const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const G = +input[0]; // G킬로그램 (G = 현재 몸무게^2 - 이전 몸무게^2)

/**
 * 조건
 * 1. 현재 몸무게 > 0, 이전 몸무게 > 0
 * 2. 현재 몸무게 > 이전 몸무게
 * 3. 이전 몸무게^2 = 현재 몸무게^2 - G
 * 4. 현재 몸무게 > G의 제곱근
 */

const answer = [];
let currentWeight = parseInt(Math.sqrt(G)) + 1; // 현재 몸무게 시작
while (true) {
    const prevWeight = Math.sqrt(currentWeight ** 2 - G); // 이전 몸무게 구하기
    if (parseInt(prevWeight) === prevWeight) answer.push(currentWeight); // 가능한 현재 몸무게인 추가
    if (parseInt(prevWeight) + 1 >= currentWeight) break; // 이전 몸무게가 현재 몸무게보다 크거나 같은 경우 탐색 종료
    currentWeight += 1; // 다음 현재 몸무게 탐색
}

if (answer.length === 0) return console.log(-1); // 가능한 현재 몸무게가 없는 경우 -1 리턴

console.log(answer.join('\n'));
