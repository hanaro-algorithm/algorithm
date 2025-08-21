const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0];
const arr = Array.from(new Array(N), () => new Array(2));

for (let i = 1; i <= N; i++) {
  arr[i - 1] = input[i].trim().split(" ").map(Number);
}

const ans = [];

for (let i = 0; i < N; i++) {
  let rank = 1;
  for (let j = 0; j < N; j++) {
    if (i === j) continue;

    if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) rank++;
  }

  ans[i] = rank;
}

console.log(ans.join(" "));
