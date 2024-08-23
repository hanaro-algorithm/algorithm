const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = input[0].split(' ').map(Number);
const list = input[1].split('');

let cnt = 0;

for (let index = 0; index < N; index += 1) {
  // 현재 위치가 햄버거인 경우 K 이내에 사람있는지 확인
  if (list[index] === 'H') {
    // 햄버거 위치에서 왼쪽으로 K거리, 오른쪽으로 K거리 사이에 사람있는지 확인하기 위해 반복문 돌림
    for (let i = index - K; i <= index + K; i += 1) {
      // 현재 위치가 햄버거 위치가 아니고 사람이라면
      if (i !== index && list[i] === 'P') {
        // 먹었다고 표시
        list[i] = 'E';
        cnt += 1; // 먹은 사람 카운드 증가
        break; // 이 햄버거는 먹혔으니까 반복문 종료
      }
    }
  }
}

console.log(cnt);
