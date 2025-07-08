const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, T] = input[0].split(' ').map(Number); // N: 버스의 개수, T: 영식이가 버스터미널에 도착하는 시간

let answer = Number.MAX_SAFE_INTEGER;
for (let i = 1; i <= N; i++) {
  const [S, I, C] = input[i].split(' ').map(Number); // 버스별 시작 시간, 간격, 대수
  // 영식이가 버스 터미널에 먼저 도착한 경우 시작 버스 탑승 가능
  if (T <= S) answer = Math.min(answer, S - T);
  else {
    const count = Math.ceil((T - S) / I); // 이미 출발한 버스 수
    if (count >= C) continue; // 해당 버스는 탈 수 없음
    const waitTime = count * I + S - T; // 영식이가 탈 버스를 기다려야 하는 시간
    answer = Math.min(answer, waitTime);
  }
}

console.log(answer === Number.MAX_SAFE_INTEGER ? -1 : answer); // 아무것도 탈 수 없는 경우 -1 출력
