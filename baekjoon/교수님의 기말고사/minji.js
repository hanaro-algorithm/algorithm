/**
 * 문제) 교수님의 기말고사
 * 기말고사 총 M분 동안 진행, C040호는 S(M<=S)분만 사용 가능(다른 시험과 겹치지 않아야함)
 * 안형찬 교수님이 시험을 시작할 수 있는 시각 출력(시험 치를 수 없으면 -1 출력)
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

// N: C040호에 예정된 시험 개수, M: 안형찬 교수님의 기말고사 시험 진행 시간, S: C040호 사용 가능한 시간
const [N, M, S] = input[0].split(' ').map(Number);

const startTime = [];
const endTime = [0]; // C040 첫 사용 가능한 시간(0분) 저장
for (let i = 1; i <= N; i++) {
  const [x, y] = input[i].split(' ').map(Number); // x: 시작시간, y: 소요시간
  startTime.push(x);
  endTime.push(x + y); // 한 시험이 끝난 종료 시간 저장
}
startTime.push(S); // C040 마지막 사용 가능한 시간(S분) 저장

startTime.sort((a, b) => a - b);
endTime.sort((a, b) => a - b);

for (let n = 0; n < startTime.length; n++) {
  // 예약된 시험들 간 빈 시간 확인
  if (startTime[n] - endTime[n] >= M) return console.log(endTime[n]);
}
console.log(-1);
