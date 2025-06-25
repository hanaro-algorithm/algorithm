const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let T = +input[0];
let line = 1;
let ans = "";

while (T) {
  const N = +input[line];
  const map = new Map();

  for (let i = line + 1; i <= line + N; i++) {
    const [, type] = input[i].split(" ");
    map.set(type, (map.get(type) || 0) + 1);
  }

  let res = 1;

  for (let value of map.values()) {
    res *= value + 1;
  }

  ans += res - 1 + "\n";
  line += N + 1;
  T--;
}

console.log(ans.trim());
