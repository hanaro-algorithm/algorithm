const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const T = +input[0];
let line = 1;
let ans = "";

for (let t = 0; t < T; t++) {
  let [N, M] = input[line++].trim().split(" ").map(Number);
  const arr = input[line++].trim().split(" ").map(Number);
  let cnt = 1;

  while (arr.length > 0) {
    const max = Math.max(...arr);
    const cur = arr.shift();

    if (cur === max) {
      if (M === 0) {
        ans += `${cnt}\n`;
        break;
      }
      cnt++;
      M--;
    } else {
      arr.push(cur);
      M = M === 0 ? arr.length - 1 : M - 1;
    }
  }
}

console.log(ans);
