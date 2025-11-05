/**
 * 호텔 고객을 적어도 C명 늘리기 위해 투자해야하는 돈의 최솟값 구하기
 * - 돈의 정수배 만큼 투자 가능
 * - 돈을 줄여서 투자는 불가
 *
 * => 우선순위 큐 이용
 * 모집한 인원의 최소비용 갱신
 */
class Heap {
    constructor() {
        this.heap = [];
    }
    getParentIdx = (idx) => parseInt((idx - 1) / 2);
    getLeftChildIdx = (idx) => idx * 2 + 1;
    getRightChildIdx = (idx) => idx * 2 + 2;
    getLength = () => this.heap.length;

    enqueue = (cnt, cost) => {
        this.heap.push({ cnt, cost }); // 데이터 마지막에 삽입

        let lastIdx = this.getLength() - 1;
        while (lastIdx > 0) {
            const parentIdx = this.getParentIdx(lastIdx);
            if (cost >= this.heap[parentIdx].cost) break; // 부모 요소보다 크거나 같으면 종료
            [this.heap[lastIdx], this.heap[parentIdx]] = [this.heap[parentIdx], this.heap[lastIdx]];
            lastIdx = parentIdx;
        }
    };
    dequeue = () => {
        const len = this.getLength();
        if (len === 0) return undefined;
        if (len === 1) return this.heap.pop();

        const item = this.heap[0]; // 상위 아이템 빼기
        this.heap[0] = this.heap.pop(); // 마지막 요소를 루트로 이동

        let currentIdx = 0;
        while (currentIdx < this.getLength()) {
            let nextIdx = currentIdx;
            const leftIdx = this.getLeftChildIdx(currentIdx);
            const rightIdx = this.getRightChildIdx(currentIdx);
            if (leftIdx < this.getLength() && this.heap[leftIdx].cost < this.heap[nextIdx].cost) nextIdx = leftIdx;
            if (rightIdx < this.getLength() && this.heap[rightIdx].cost < this.heap[nextIdx].cost) nextIdx = rightIdx;

            if (nextIdx === currentIdx) break; // 바꿀 수 있는 자식이 없는 경우 종료

            [this.heap[currentIdx], this.heap[nextIdx]] = [this.heap[nextIdx], this.heap[currentIdx]];
            currentIdx = nextIdx;
        }
        return item;
    };
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [C, N] = input[0].split(' ').map(Number); // 늘리고자 하는 고객 수: C, 홍보 가능한 도시 수: N
const cityInfo = [];
for (let i = 1; i <= N; i++) cityInfo.push(input[i].split(' ').map(Number));
cityInfo.sort((a, b) => a[0] - b[0]); // 홍보비용 기준 오름차순 정렬

const visited = Array.from({ length: 1101 }, () => Number.MAX_SAFE_INTEGER); // C의 최댓값 1000명 + 각 도시의 모집 최대인원 100
const pq = new Heap();
for (const [cost, cnt] of cityInfo) {
    // 모집한 인원의 최소 홍보 비용 갱신 => 우선순위 큐에 삽입
    if (visited[cnt] > cost) {
        visited[cnt] = cost;
        pq.enqueue(cnt, cost);
    }
}

while (pq.getLength() > 0) {
    const { cnt: currentCnt, cost: currentCost } = pq.dequeue();
    // 현재까지 모집한 인원이 모집하고자 하는 인원 C를 넘었을 때, 최소 홍보 비용 반환
    if (currentCnt >= C) return console.log(currentCost);
    for (const [cost, cnt] of cityInfo) {
        const accCost = currentCost + cost; // 비용 더하기
        const accCnt = currentCnt + cnt; // 인원 더하기
        // 기존에 있던 필요한 홍보비용보다 더 적은 홍보비용으로 모집 가능한 경우
        // 비용 업데이트 후 우선순위 큐에 삽입
        if (visited[accCnt] > accCost) {
            visited[accCnt] = accCost;
            pq.enqueue(accCnt, accCost);
        }
    }
}
