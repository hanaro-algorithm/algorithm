/**
 * 문제) 감시 피하기
 * → 장애물 3개를 빈 칸에 설치했을 때 모든 학생들이 선생님의 감시로 피할 수 있으면 YES, 없으면 NO 출력
 * - 선생님은 상하좌우로 장애물로 가려지지 않는 이상 학생 찾아낼 수 있음
 */

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

function solution(N, hall) {
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];
  // 범위 벗어나는지 확인하는 함수
  const isAvailable = (y, x) => {
    if (x < 0 || x >= N || y < 0 || y >= N) return false;
    return true;
  };

  // 선생님 감시
  const checkWatch = (y, x) => {
    for (let d = 0; d < 4; d++) {
      let [ny, nx] = [y + dy[d], x + dx[d]];
      while (isAvailable(ny, nx) && hall[ny][nx] !== 'O') {
        if (hall[ny][nx] === 'S')
          return false; // 학생 발견
        else {
          ny += dy[d];
          nx += dx[d];
        }
      }
    }
    return true; // 학생 발견 X
  };

  let flag = false;
  // 장애물 3개 선택
  const choiceObstacle = (count) => {
    if (count === 3) {
      let cnt = 0;
      for (let r = 0; r < N; r++) {
        for (let c = 0; c < N; c++) {
          if (hall[r][c] === 'T') {
            if (!checkWatch(r, c)) cnt++;
          }
        }
      }
      if (cnt === 0) flag = true; // 모든 선생님이 학생을 발견하지 못한 경우
      return;
    }
    for (let r = 0; r < N; r++) {
      for (let c = 0; c < N; c++) {
        if (hall[r][c] === 'X') {
          hall[r][c] = 'O'; // 장애물 두기
          count++;
          choiceObstacle(count);
          count--;
          hall[r][c] = 'X'; // 장애물 치우기
        }
      }
    }
  };

  choiceObstacle(0);

  if (flag) return 'YES';
  else return 'NO';
}

const N = +input[0]; // NXN 복도 크기
const hall = []; // 복도 정보
for (let h = 1; h <= N; h++) hall.push(input[h].split(' '));

console.log(solution(N, hall));
