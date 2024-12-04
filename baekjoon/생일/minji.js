const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const n = +input[0]; // 학생의 수
const info = [];
for (let i = 1; i <= n; i += 1) {
  const [name, day, month, year] = input[i].split(' ');
  info.push([name, +year, +month, +day]); // 배열에 [이름, 년도, 월, 일] 순으로 넣기
}

// 년도 순으로 오름차순 정렬, 년도 같으면 월 순으로 오름차순 정렬, 년도&월 같다면 일 순으로 오름차순 정렬
info.sort((a, b) => a[1] - b[1] || a[2] - b[2] || a[3] - b[3]);

console.log(info.at(-1)[0]); // 가장 나이가 적은 사람 출력
console.log(info[0][0]); // 가장 나이가 많은 사람 출력
