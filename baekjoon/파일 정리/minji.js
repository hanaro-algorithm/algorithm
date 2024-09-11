const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 파일의 개수
const files = new Map();
for (let i = 1; i <= N; i += 1) {
  const extension = input[i].split('.')[1];
  if (files.has(extension)) files.set(extension, files.get(extension) + 1);
  else files.set(extension, 1);
}

const filesExtension = [...files].sort();
let answer = '';
filesExtension.forEach((extension, idx) => {
  answer +=
    idx !== filesExtension.length - 1
      ? `${extension[0]} ${extension[1]}\n`
      : `${extension[0]} ${extension[1]}`;
});

console.log(answer);
