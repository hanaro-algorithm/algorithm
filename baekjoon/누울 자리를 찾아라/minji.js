const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 방의 크기
const room = Array.from({ length: N }, () => []); // 기존 방 구조
const reverseRoom = Array.from({ length: N }, () => new Array(N)); // 방 구조 행<->열 변경

// 방 구조 정보 넣기
for (let i = 0; i < N; i += 1) {
  const items = input[i + 1].split('');
  room[i].push(...items);
  items.forEach((item, idx) => (reverseRoom[idx][i] = item));
}

// 누울 공간 갯수 카운트 함수
const checkFunc = (roomInfo, cnt) => {
  for (let i = 0; i < N; i += 1) {
    const arr = roomInfo[i].join('').split('X');
    arr.forEach((item) => {
      if (item !== '' && item.length >= 2) cnt += 1;
    });
  }
  return cnt;
};

let answer = '';

answer += checkFunc(room, 0) + ' ' + checkFunc(reverseRoom, 0); // 가로 체크 + '공백' + 세로 체크

console.log(answer);
