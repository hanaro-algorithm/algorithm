const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0];
const weight = input[1].split(" ").map(Number);
weight.sort((a, b) => a - b); // 오름차순정렬

let total = 1; // 만들수 없는 금액 표기

// weight에 있는 값을 하나씩 더해보며 만들 수 있는 최소값 구하기
// 1 1 2 3 6 7 30
// 1 1 -> 1~2 가능
// 1 1 2 -> 1~4 가능
// 1 1 2 3 -> 1~7 가능
// 1 1 2 3 6 -> 1~13 가능
// 1 1 2 3 6 7 -> 1~20 가능
for (let i = 0; i < N; i += 1) {
  if (total < weight[i]) break;
  total += weight[i];
}

console.log(total);
// console.log(solution(7, [3, 1, 6, 2, 7, 30, 1]));

// console.log(solution(3, [1, 1, 10]));
// console.log(solution(3, [1, 2, 5]));
