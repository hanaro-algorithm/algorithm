const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 사람 수(짝수)
let s = []; // 능력치 배열
for (let i = 1; i <= N; i += 1) s.push(input[i].split(' ').map(Number));
const member = parseInt(N / 2);

let start = []; // 스타트 팀 멤버
let result = Number.MAX_SAFE_INTEGER;

const dfs = (index) => {
  // 팀 배정이 끝난 경우
  if (start.length === member) {
    let link = []; // 나머지 사람들을 링크 팀 멤버 할당
    for (let i = 0; i < N; i += 1) if (!start.includes(i)) link.push(i);

    let startPower = 0; // 스타트 팀 능력치
    let linkPower = 0; // 링크 팀 능력치
    // 각 팀의 능력치 구하기
    for (let i = 0; i < member; i += 1) {
      for (let j = 0; j < member; j += 1) {
        startPower += s[start[i]][start[j]];
        linkPower += s[link[i]][link[j]];
      }
    }
    // |스타트 팀 능력치 - 링크 팀 능력치| 최소 값 구하기
    result = Math.min(result, Math.abs(startPower - linkPower));

    return;
  }
  for (let i = index; i < N; i += 1) {
    start.push(i);
    dfs(i + 1);
    start.pop();
  }
};

dfs(0);
console.log(result);
