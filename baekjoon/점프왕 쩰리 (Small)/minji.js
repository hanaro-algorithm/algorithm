const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 게임 구역 크기
let gameMap = []; // 게임판 구역
for (let i = 1; i <= N; i += 1) gameMap.push(input[i].split(' ').map(Number));

// 오른쪽, 아래 방향
const dx = [1, 0];
const dy = [0, 1];

let result = 'Hing'; // 끝점에 도달할 수 없는 경우 출력 메시지 담기

const dfs = (x, y, pos) => {
  if (pos === 0) return; // 끝점에 도달하지 않았는데 더이상 이동할 수 없을 때 리턴
  for (let i = 0; i < 2; i += 1) {
    const [nx, ny] = [x + dx[i] * pos, y + dy[i] * pos]; // 다음 영역으로 이동
    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 영역 벗어나면 패스
    // 끝점(-1)에 도달한 경우 결과에 끝점 도달 출력 메시지 담기
    if (pos === -1) {
      result = 'HaruHaru';
      return; // 해당 dfs 종료
    }
    dfs(nx, ny, gameMap[nx][ny]); // 다음 영역으로 이동
  }
};

dfs(0, 0, gameMap[0][0]); // 시작점은 항상 (0,0)
console.log(result);
