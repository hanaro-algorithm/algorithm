const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const [N, M] = input[0].trim().split(" ").map(Number);
const tree = input[1].trim().split(" ").map(Number);

let left = 0;
let right = Math.max(...tree);
let ans = 0;

while (left <= right) {
  const mid = Math.floor((left + right) / 2);

  const sum = cal(mid);

  if (sum >= M) {
    ans = Math.max(ans, mid);
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}

console.log(ans);

function cal(val) {
  let cut = 0;

  for (let i = 0; i < N; i++) {
    if (tree[i] > val) cut += tree[i] - val;
  }

  return cut;
}
