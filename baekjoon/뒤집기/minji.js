const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const numbers = input[0].split("").map(Number);

let oneContinueCnt = 0; // 1이 반복되는 구간 갯수
let zeroContinueCnt = 0; // 0이 반복되는 구간 갯수

let prev = -1; // 앞 숫자

numbers.map((num) => {
  if (num !== prev) {
    num === 0 ? (zeroContinueCnt += 1) : (oneContinueCnt += 1);
    prev = num;
  }
});

console.log(Math.min(oneContinueCnt, zeroContinueCnt));
