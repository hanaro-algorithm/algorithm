const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let tc = +input[0];
let line = 1;

let answer = '';
while (tc) {
  const N = +input[line];
  const numbers = [];
  for (let num = 1; num <= N; num += 1) numbers.push(num);
  const operation = ['+', '-', ' '];
  const result = [];
  const dfs = (current, idx, calculation) => {
    if (current === N) {
      const newCal = calculation.replaceAll(' ', '');
      const number = newCal.split(/[-,+]/g);
      const op = newCal.split(/[0-9]/g).filter((o) => o !== '');
      let cal = +number[0];
      for (let i = 1; i < number.length; i += 1) {
        if (op[i - 1] === '+') cal += +number[i];
        else if (op[i - 1] === '-') cal -= +number[i];
      }
      if (cal === 0) result.push(calculation);
      return;
    }
    for (const oper of operation) {
      if (oper === '+')
        dfs(numbers[idx + 1], idx + 1, `${calculation}+${numbers[idx + 1]}`);
      else if (oper === '-')
        dfs(numbers[idx + 1], idx + 1, `${calculation}-${numbers[idx + 1]}`);
      else dfs(numbers[idx + 1], idx + 1, `${calculation} ${numbers[idx + 1]}`);
    }
  };

  dfs(1, 0, '1');
  result.sort();
  answer += result.join('\n') + '\n\n';
  line += 1;
  tc -= 1;
}

answer = answer.trimEnd();
console.log(answer);
