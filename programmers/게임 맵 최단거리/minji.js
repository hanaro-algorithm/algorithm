function solution(maps) {
  let answer = -1;
  let visited = Array.from({ length: maps.length }, () =>
    new Array(maps[0].length).fill(0)
  ); // 지나온 칸 수 체크

  const row = maps.length;
  const col = maps[0].length;

  const dx = [0, 0, -1, 1];
  const dy = [-1, 1, 0, 0];
  dfs(0, 0, 1); // 출발지점

  // (x,y) 위치와 이동한 칸수 cnt
  function dfs(x, y, cnt) {
    // 목적지에 도달한 경우 리턴
    if (x === col - 1 && y === row - 1) {
      if (answer === -1) answer = cnt;
      else answer = Math.min(answer, cnt);
      return;
    }
    visited[y][x] = cnt; // 방문 표시(누적합)

    for (let i = 0; i < 4; i += 1) {
      const nx = x + dx[i];
      const ny = y + dy[i];
      // 범위를 벗어나는 경우
      if (nx < 0 || nx >= col || ny < 0 || ny >= row) continue;
      if (maps[ny][nx] === 1 && !visited[ny][nx]) {
        dfs(nx, ny, cnt + 1);
      }
    }
    visited[y][x] = 0;
  }
  return answer;
}

console.log(
  solution([
    [1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 0, 1],
    [0, 0, 0, 0, 1],
  ])
);

/**
 *  [1, 0, 9, 10, 11],
    [2, 0, 8, 0, 12],
    [3, 0, 7, 8, 9],
    [4, 5, 6, 0, 10],
    [0, 0, 0, 0, 11],
 */

// console.log(
//   solution([
//     [1, 0, 1, 1, 1],
//     [1, 0, 1, 0, 1],
//     [1, 0, 1, 1, 1],
//     [1, 1, 1, 0, 0],
//     [0, 0, 0, 0, 1],
//   ])
// );
