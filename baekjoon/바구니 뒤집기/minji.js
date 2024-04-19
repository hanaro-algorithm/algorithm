const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

// N: 바구니 개수, M: 순서 바꿀 횟수
const [N, M] = input[0].split(" ").map(Number);

let numbers = [];
for (let n = 1; n <= N; n += 1) numbers.push(n);

for (let m = 1; m <= M; m += 1) {
  const [i, j] = input[m].split(" ").map(Number);

  let prev = numbers.slice(0, i - 1);
  let target = numbers.slice(i - 1, j).reverse(); // 해당 범위만 역순으로 만들기
  let next = numbers.slice(j);

  numbers = [...prev, ...target, ...next];
}

console.log(...numbers);
