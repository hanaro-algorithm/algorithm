/**
 * 문제) 불
 * 상근이가 빌딩을 탈출하는 데 가장 빠른 시간(탈출 불가능한 경우, IMPOSSIBLE 출력)
 */
// 큐 클래스 생성
class Queue {
  constructor() {
    this.queue = {};
    this.headIndex = 0;
    this.tailIndex = 0;
  }
  enqueue = (item) => {
    this.queue[this.tailIndex++] = item;
  };
  dequeue = () => this.queue[this.headIndex++];
  getLength = () => this.tailIndex - this.headIndex;
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let t = +input[0]; // 테스트 케이스 개수
let line = 1; // 각 테스트 정보 입력 받는 라인

// 상하좌우 방향 배열
const dx = [-1, 0, 1, 0];
const dy = [0, -1, 0, 1];

let answer = '';
while (t) {
  const [w, h] = input[line].split(' ').map(Number); // w: 빌딩 너비, h: 빌딩 높이
  const building = []; // 현재 빌딩 정보
  for (let i = line + 1; i < line + h + 1; i++) {
    building.push(input[i].split(''));
  }
  const result = isAvailableExit(w, h, building);
  if (result !== -1) answer += result + '\n'; // 탈출 시간 저장
  else answer += 'IMPOSSIBLE\n'; // 탈출 불가능한 경우, IMPOSSIBLE 저장
  line += h + 1;
  t--;
}
console.log(answer.trimEnd());

// 빌딩 영역을 벗어나는지 확인하는 함수
function isOut(y, x, w, h) {
  if (y < 0 || x < 0 || y >= h || x >= w) return true;
  return false;
}

// 탈출할 수 있는지 판단하는 함수
function isAvailableExit(w, h, building) {
  const firePos = new Queue(); // 불 위치담을 큐
  const sangPos = new Queue(); // 상근이 위치담을 큐

  // 초기 상근이와 불 위치 큐에 넣기
  for (let floor = 0; floor < h; floor++) {
    for (let p = 0; p < w; p++) {
      if (building[floor][p] === '@') {
        building[floor][p] === '..'; // 재방문 하지않기 위해 표시
        sangPos.enqueue([floor, p]);
      }
      if (building[floor][p] === '*') firePos.enqueue([floor, p]);
    }
  }

  let timer = 0;
  while (true) {
    const fireCnt = firePos.getLength(); // 1초마다 퍼져나가야할 불의 개수
    for (let i = 0; i < fireCnt; i++) {
      const [curY, curX] = firePos.dequeue();
      for (let d = 0; d < 4; d++) {
        const [nextY, nextX] = [curY + dy[d], curX + dx[d]];
        if (
          isOut(nextY, nextX, w, h) ||
          building[nextY][nextX] === '#' ||
          building[nextY][nextX] === '*'
        )
          continue; // 영역 벗어나거나 불이 번질 수 없는 위치이면 다음으로 넘어감
        building[nextY][nextX] = '*'; // 불 퍼지기
        firePos.enqueue([nextY, nextX]); // 새로운 불 위치 추가
      }
    }
    const sangCnt = sangPos.getLength(); // 1초마다 움직일 수 있는 상근이 위치 개수
    for (let i = 0; i < sangCnt; i++) {
      const [curY, curX] = sangPos.dequeue();
      for (let d = 0; d < 4; d++) {
        const [nextY, nextX] = [curY + dy[d], curX + dx[d]];
        if (isOut(nextY, nextX, w, h)) return timer + 1; // 빌딩을 빠져나가면 걸린 시간 리턴
        // 다음 칸을 아직 방문하지 않았거나, 땅인 경우 이동
        if (building[nextY][nextX] === '.') {
          building[nextY][nextX] = '..';
          sangPos.enqueue([nextY, nextX]);
        }
      }
    }
    if (sangCnt === 0) return -1; // 더 이상 상근이가 이동할 수 없는 경우, 빌딩을 빠져나가지 못했으므로 -1 리턴
    timer++; // 시간 증가
  }
}
