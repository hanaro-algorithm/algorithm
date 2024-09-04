const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 차량 대수
let inCars = []; // 입구 차량 리스트
let outCars = []; // 출구 차량 리스트

for (let i = 1; i <= N; i += 1) {
  inCars.push(input[i]);
  outCars.push(input[i + N]);
}

let visited = []; // 추월한 차량 리스트
let outIndex = 0; // 출구 차량 인덱스
inCars.map((car) => {
  // 추월한 차량 리스트에 존재하지 않을 경우에만
  if (!visited.includes(car)) {
    while (true) {
      if (car === outCars[outIndex]) {
        outIndex += 1;
        break;
      }
      // 추월차량 등록
      visited.push(outCars[outIndex]);
      outIndex += 1;
    }
  }
});

console.log(visited.length);
