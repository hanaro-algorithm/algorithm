const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let T = +input[0];
let line = 1;

const isVPS = (brackets) => {
  const stack = [];
  for (let i = 0; i < brackets.length; i += 1) {
    if (brackets[i] === '(') stack.push('(');
    else {
      if (!stack.length) return false;
      else stack.pop();
    }
  }
  if (stack.length > 0) return false;
  return true;
};

let answer = '';
while (T) {
  if (isVPS(input[line].split(''))) answer += 'YES\n';
  else answer += 'NO\n';
  T -= 1;
  line += 1;
}

console.log(answer.trimEnd());
