const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const word = input[0].split('');
const visited = Array.from({ length: word.length }, () => '');

let answer = '';
const show = (left, right) => {
  let min = 100;
  let idx = -1;
  for (let i = left; i < right; i += 1) {
    if (!visited[i] && min > word[i].charCodeAt()) {
      min = word[i].charCodeAt();
      idx = i;
    }
  }
  if (min === 100) return;
  visited[idx] = word[idx];
  answer += visited.join('') + '\n';
  show(idx + 1, right);
  show(left, idx);
};

show(0, word.length);

console.log(answer.trimEnd());
