const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = input[0].split(' ').map(Number);
const weight = input[1].split(' ').map(Number); // 중량
const visited = Array.from({ length: N }, () => false);

let answer = 0;

const dfs = (currentWeight, depth) => {
  // N일 지남
  if (depth === N) {
    if (currentWeight >= 500) answer += 1; // 500이상일 때만 정답 카운트
    return;
  }
  for (let i = 0; i < N; i += 1) {
    const day = currentWeight - K + weight[i]; // 근손실 K와 중량 계산한 값
    // 백트래킹 수행
    if (!visited[i] && day >= 500) {
      visited[i] = true;
      dfs(day, depth + 1);
      visited[i] = false;
    }
  }
};

dfs(500, 0);

console.log(answer);
