/**
 * 문제) 컨베이어 벨트 위의 로봇
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = input[0].split(' ').map(Number); // N: 컨베이어 벨트 길이, K: 내구도 0인 칸의 개수
const conveyor = input[1].split(' ').map(Number); // 컨베이어 벨트 각 칸의 내구도
const robots = Array.from({ length: 2 * N }, () => false); // 로봇 위치

let stage = 0;
let zeroCount = 0; // 내구도가 0인 컨베이어 개수
let [start, end] = [0, N - 1];

// 4과정) 내구도가 0인 칸의 개수가 K개 이상인 경우 과정 종료, 아니면 다음 단계 진행
while (zeroCount < K) {
  stage++; // 다음 단계 진행

  // 1과정) 벨트 위에 있는 로봇과 함께 컨베이어 벨트 한 칸 회전 (원형)
  start = (start - 1 + 2 * N) % (2 * N);
  end = (end - 1 + 2 * N) % (2 * N);
  robots[end] = false; // 내리는 위치에 로봇 있으면 내림

  // 2과정) 벨트 위에 있는 로봇 회전하는 방향으로 한 칸 이동
  // (이때, 이동하려는 칸에 로봇이 있거나, 그 칸의 내구도가 1 이상인 경우만 이동 가능)
  // 내리는 위치에 오는 로봇은 즉시 내리기
  for (let i = 1; i < N; i++) {
    // 가장 먼저 올라간 로봇부터 순서대로 처리해야 하므로 뒤에서 앞으로 순회
    const current = (end - i + 2 * N) % (2 * N);
    const next = (current + 1) % (2 * N);
    if (robots[current] && !robots[next] && conveyor[next] >= 1) {
      robots[current] = false;
      robots[next] = true;
      conveyor[next]--;
      if (conveyor[next] === 0) zeroCount++;
    }
  }
  robots[end] = false; // 내리는 위치에 로봇 있으면 내림

  // 3과정) 올리는 위치에 있는 칸의 내구도가 0이 아닌 경우 로봇 올리기
  if (!robots[start] && conveyor[start] >= 1) {
    robots[start] = true;
    conveyor[start]--;
    if (conveyor[start] === 0) zeroCount++;
  }
}
console.log(stage);
