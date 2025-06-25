/**
 * 문제) 링크와 스타트
 * 스타트 팀과 링크 팀의 능력치의 차이의 최솟값 구하기
 * - 각 팀에 1명 이상 존재해야함
 * - S_ij != S_ji
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 사람 수
const power = [];
for (let i = 1; i <= N; i++) power.push(input[i].split(' ').map(Number)); // 능력치

const people = power.map((_, idx) => idx); // 사람 번호

// 각 팀의 능력치
const totalPower = (n, team) => {
  let total = 0;
  for (let i = 0; i < n; i++) {
    for (let j = i + 1; j < n; j++) {
      total += power[team[i]][team[j]] + power[team[j]][team[i]];
    }
  }
  return total;
};

let answer = Number.MAX_SAFE_INTEGER;
const visited = Array.from({ length: N }, () => false);
const backtracking = (person, selected) => {
  // 각 팀에 사람 2명 이상(1명인 경우 능력치는 0임) ~ N명 미만인 경우
  // 각 팀의 능력치 합 구하기
  if (selected.length > 1 && selected.length < N) {
    const linkTeam = people.filter((_, idx) => !selected.includes(idx)); // start팀이 아닌 link팀 사람 배열
    const startPower = totalPower(selected.length, selected); // start팀 능력치
    const linkPower = totalPower(linkTeam.length, linkTeam); // link팀 능력치
    answer = Math.min(answer, Math.abs(startPower - linkPower)); // 능력치 차이 최솟값 갱신
  }
  for (let p = person + 1; p < N; p++) {
    if (!visited[p]) {
      visited[p] = true;
      selected.push(p);
      backtracking(p, selected);
      selected.pop();
      visited[p] = false;
    }
  }
};
visited[0] = true;
backtracking(0, [0]);

console.log(answer);
