const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = input[0].split(' ').map(Number);
let S = input[1].split(' ').map(Number);
const D = input[2].split(' ').map(Number);

const prevCards = Array.from({ length: N }, () => 0);
for (let i = 0; i < K; i++) {
  D.forEach((d, idx) => (prevCards[d - 1] = S[idx]));
  S = [...prevCards];
}

console.log(S.join(' '));
