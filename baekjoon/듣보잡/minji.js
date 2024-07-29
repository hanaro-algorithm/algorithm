const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number); // N: 듣도 못한 사람의 수, M: 보도 못한 사람의 수

let hear = new Set(); // 듣도 못한 사람의 이름 리스트
let see = new Set(); // 보도 못한 사람의 이름 리스트
for (let i = 1; i < N + 1; i += 1) hear.add(input[i]);
for (let i = N + 1; i < M + N + 1; i += 1) see.add(input[i]);

let hearAndSee = [];
hear.forEach((person) => {
  if (see.has(person)) {
    hearAndSee.push(person);
  }
});

hearAndSee.sort();
console.log(hearAndSee.length);
hearAndSee.forEach((person) => console.log(person));
