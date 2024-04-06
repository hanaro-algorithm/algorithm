function solution(maps) {
  let answer = -1;
  const row = maps.length;
  const col = maps[0].length;
  let visited = Array.from({ length: row }, () => new Array(col).fill(0)); // 지나온 칸 수 체크

  const dx = [0, 0, -1, 1];
  const dy = [-1, 1, 0, 0];

  let queue = [];
  queue.push([0, 0, 1]); // 스타트 위치
  visited[0][0] = 1;

  while (queue.length > 0) {
    const [cx, cy, cnt] = queue.shift();

    // 목적지에 도달한 경우
    if (cx === col - 1 && cy === row - 1) {
      answer = cnt;
      break;
    }

    for (let i = 0; i < 4; i += 1) {
      const nx = cx + dx[i];
      const ny = cy + dy[i];

      if (nx < 0 || nx >= col || ny < 0 || ny >= row) continue; // 범위 벗어나는 경우
      if (maps[ny][nx] === 1 && !visited[ny][nx]) {
        // 방문 표시(꺼낼 때 방문 표시하면, 그 사이에 많은 값들이 들어올 수 있음)
        visited[ny][nx] = cnt + 1;
        // 좌표 이동
        queue.push([nx, ny, cnt + 1]);
      }
    }
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
console.log(
  solution([
    [1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 0, 0],
    [0, 0, 0, 0, 1],
  ])
);
