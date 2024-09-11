const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [S_L, P_L] = input[0].split(' ').map(Number); // S: DNA 문자열 길이, P: 비밀번호 부분 문자열 길이
const DNA = input[1]; // 임의로 만든 DNA 문자열
const [minA, minC, minG, minT] = input[2].split(' ').map(Number); // A, C, G, T의 최소 개수

let count = { A: 0, C: 0, G: 0, T: 0 };
let total = 0;

const checkDNA = () => {
  if (count.A >= minA && count.C >= minC && count.G >= minG && count.T >= minT)
    total += 1;
};

const countAddDNA = (d) => {
  if (DNA[d] === 'A') count.A += 1;
  else if (DNA[d] === 'C') count.C += 1;
  else if (DNA[d] === 'G') count.G += 1;
  else if (DNA[d] === 'T') count.T += 1;
};

const countMinusDNA = (d) => {
  if (DNA[d] === 'A') count.A -= 1;
  else if (DNA[d] === 'C') count.C -= 1;
  else if (DNA[d] === 'G') count.G -= 1;
  else if (DNA[d] === 'T') count.T -= 1;
};

for (let i = 0; i < P_L; i += 1) countAddDNA(i);
checkDNA();

for (let i = P_L; i < S_L; i += 1) {
  countMinusDNA(i - P_L);
  countAddDNA(i);
  checkDNA();
}

console.log(total);
