/**
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간
 * - 걷기: 1초 소요(X-1 또는 X+1)
 * - 순간이동: 0초 소요(2*X)
 *
 * BFS 알고리즘 이용
 * - 다음 위치를 더 적은 시간으로 방문할 수 있으면 업데이트
 * - 동생에게 도달했을 때 걸린 시간 반환
 */
class Queue {
    constructor() {
        this.queue = {};
        this.headIdx = 0;
        this.tailIdx = 0;
    }
    enqueue = (pos) => {
        this.queue[this.tailIdx++] = pos;
    };
    dequeue = () => this.queue[this.headIdx++];
    getLength = () => this.tailIdx - this.headIdx;
}
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = input[0].split(' ').map(Number); // N: 수빈이 현재 위치, K: 동생 위치

const visited = Array.from({ length: 100001 }, () => Number.MAX_SAFE_INTEGER);
const queue = new Queue();
queue.enqueue(N);
visited[N] = 0;

const move = [
    { dir: -1, time: 1 },
    { dir: +1, time: 1 },
    { dir: 2, time: 0 },
];
while (queue.getLength() > 0) {
    const current = queue.dequeue();

    if (current === K) return console.log(visited[K]);

    for (const { dir, time } of move) {
        const next = dir !== 2 ? current + dir : current * dir;
        if (next < 0 || next > 100000) continue;
        if (visited[next] > visited[current] + time) {
            visited[next] = visited[current] + time;
            queue.enqueue(next);
        }
    }
}
