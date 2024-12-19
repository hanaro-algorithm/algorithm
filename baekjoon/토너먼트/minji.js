const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, num1, num2] = input[0].split(' ').map(Number);
// 둘 중 큰 값과 작은 값 구하기
let [maxNum, minNum] = [Math.max(num1, num2), Math.min(num1, num2)];

let round = 1;
while (true) {
  // 큰 값이 짝수이고 큰값-작은값이 1일 경우 대결하는 라운드이므로 종료
  if (maxNum % 2 === 0 && maxNum - minNum === 1) break;
  // 번호 갱신
  maxNum = maxNum % 2 === 0 ? parseInt(maxNum / 2) : parseInt(maxNum / 2) + 1;
  minNum = minNum % 2 === 0 ? parseInt(minNum / 2) : parseInt(minNum / 2) + 1;
  round += 1; // 라운드 증가
}

console.log(round);
