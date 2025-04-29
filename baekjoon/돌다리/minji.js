/**
 * 문제) 돌다리
 * 동규가 주미에게 도달하기 위한 최소한의 이동 횟수 구하기
 *
 * [조건]
 * - 현 위치에서 +1, -1 칸 이동 가능
 * - 스카이 콩콩 이용해서 A나 B만큼 좌우로 이동 가능
 * - 스카이 콩콩 이용해서 A배나 B배만큼 좌우로 이동 가능
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [A, B, N, M] = input[0].split(' ').map(Number); // 스카이 콩콩 힘 A와 B, 동규 현재 위치 N, 주미 현재 위치 M

const visited = Array.from({ length: 100001 }, () => -1);
const queue = [];
queue.push(N);
let index = 0;
visited[N] = 0;

while (queue.length) {
  const current = queue[index++]; // 동규의 현재 위치
  for (const next of [
    current - 1,
    current + 1,
    current - A,
    current - B,
    current + A,
    current + B,
    current * A,
    current * B,
  ]) {
    if (next < 0 || next > 100000) continue;
    // 주미에게 도달한 경우 종료
    if (next === M) return console.log(visited[current] + 1);
    if (visited[next] === -1) {
      visited[next] = visited[current] + 1;
      queue.push(next);
    }
  }
}
