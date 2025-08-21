const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const T = input.length;
let ans = "";

for (let t = 0; t < T; t++) {
  const s = input[t];

  if (s === ".") break;

  const stack = [];
  let check = true;

  for (let i = 0; i < s.length; i++) {
    const c = s[i];

    if (c === "[" || c === "(") {
      stack.push(c);
    } else if (c === "]") {
      if (!stack.length || stack[stack.length - 1] !== "[") {
        check = false;
        break;
      }

      stack.pop();
    } else if (c === ")") {
      if (!stack.length || stack[stack.length - 1] !== "(") {
        check = false;
        break;
      }

      stack.pop();
    }
  }

  if (stack.length) check = false;

  if (check) ans += "yes\n";
  else ans += "no\n";
}

console.log(ans.trimEnd());
