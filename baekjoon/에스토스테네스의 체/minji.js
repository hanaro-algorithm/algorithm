const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = input[0].split(' ').map(Number);
const visited = Array.from({ length: N + 1 }, () => false); // 삭제 표시
let remove = 0; // 제거 횟수

let answer = -1;
for (let i = 2; i <= N; i += 1) {
  // 제거되지 않은 가장 작은 소수
  if (!visited[i]) {
    // i의 배수인 것들만 확인
    for (let j = i; j <= N; j += i) {
      if (!visited[j]) {
        visited[j] = true;
        remove += 1;
        // K 번째 제거한 경우 반복문 중지
        if (remove === K) {
          answer = j;
          break;
        }
      }
    }
  }
  if (answer !== -1) break;
}
console.log(answer);
