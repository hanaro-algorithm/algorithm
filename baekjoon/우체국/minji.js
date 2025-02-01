const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 마을 수
const townInfo = []; // 마을 정보 담기
for (let i = 1; i <= N; i += 1) townInfo.push(input[i].split(' ').map(Number));

townInfo.sort((a, b) => a[0] - b[0]); // 마을 번호 기준 오름차순 정렬(우체국 두 곳 이상 놓을 수 있는 경우 작은 마을 출력)
const totalPeople = townInfo.reduce((acc, cur) => (acc += cur[1]), 0); // 총 인구 구하기

let sum = 0;
let result = townInfo[N - 1][0]; // 우체국 놓을 위치를 찾지 못할 경우 맨 마지막 마을 출력
for (let i = 0; i < N; i += 1) {
  sum += townInfo[i][1];
  // 총 인구의 절반보다 크거나 같을 경우 해당 위치에 우체국 놓기
  if (totalPeople / 2 <= sum) {
    result = townInfo[i][0];
    break;
  }
}

console.log(result);
