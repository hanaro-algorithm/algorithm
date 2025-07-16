const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const T = +input[0];
let line = 1;
const res = [];

for (let t = 0; t < T; t++) {
  const N = +input[line++];
  // N명의 지원자의 면접 점수를 담기 위한 배열
  const arr = new Array(N);

  for (let i = 0; i < N; i++) {
    // 서류점수는 arr의 index로 사용하고 그 곳에 면접점수를 담는다.
    const [score1, score2] = input[line++].split(" ").map(Number);
    arr[score1 - 1] = score2;
  }

  // 현재까지 뽑은 사람의 면접점수 중 최저 점수
  let minScore = N + 1;
  // 선발할 지원자 수
  let cnt = 0;

  for (let i = 0; i < N; i++) {
    const curScore = arr[i];

    // 서류점수가 낮은 사람부터 확인해보며 지금까지 최저 면접점수보다 높으면 선발하고 갱신한다.
    if (curScore < minScore) {
      cnt++;
      minScore = curScore;
    }
  }

  res.push(cnt);
}

console.log(res.join("\n"));
