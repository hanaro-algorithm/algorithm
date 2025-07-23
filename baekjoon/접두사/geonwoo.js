const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0];
const arr = [];

for (let i = 1; i <= N; i++) {
  arr.push(input[i].trim());
}

arr.sort((o1, o2) => o2.length - o1.length);

const ans = [];

for (const s of arr) {
  const isIncluded = ans.some((str) => str.startsWith(s));

  if (!isIncluded) ans.push(s);
}

console.log(ans.length);
