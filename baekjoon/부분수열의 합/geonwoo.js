const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const [N, S] = input[0].trim().split(" ").map(Number);
const nums = input[1].trim().split(" ").map(Number);
let ans = S === 0 ? -1 : 0;

dfs(0, 0);

console.log(ans);

function dfs(depth, sum) {
  if (depth === N) {
    if (sum === S) ans++;
    return;
  }

  const num = nums[depth];

  dfs(depth + 1, sum);
  dfs(depth + 1, sum + num);
}
