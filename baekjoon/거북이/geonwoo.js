const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

let T = +input[0];
let line = 1;
let ans = "";
const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];

while (T) {
  const turtle = input[line++].trim();
  let d = 0;

  let r = 0;
  let c = 0;

  let maxR = 0;
  let maxC = 0;
  let minR = 0;
  let minC = 0;

  for (let i = 0; i < turtle.length; i++) {
    let comm = turtle[i];

    if (comm === "F") {
      r += dr[d];
      c += dc[d];
    } else if (comm === "B") {
      r -= dr[d];
      c -= dc[d];
    } else if (comm === "L") {
      d = (d + 3) % 4;
    } else if (comm === "R") {
      d = (d + 1) % 4;
    }

    maxR = Math.max(maxR, r);
    maxC = Math.max(maxC, c);
    minR = Math.min(minR, r);
    minC = Math.min(minC, c);
  }

  const cal = Math.abs(maxR - minR) * Math.abs(maxC - minC);
  ans += cal + "\n";

  T--;
}

console.log(ans);
