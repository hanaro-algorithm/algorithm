/**
 * 보석 도둑
 * 상덕이가 훔칠 수 있는 보석의 최대 가격 구하기
 * -> 가방에 최대 한 개의 보석만 넣을 수 있음!
 *
 * 우선순위 큐 + 정렬 이용!
 * 1. 보석 무게 오름차순 정렬
 * 2. 가방 무게 오름차순 정렬
 * 2. 가방에 들어갈 수 있는 보석들 중 가장 가격이 비싼 보석 택하기(우선순위 큐)
 * 3. 택한 보석은 우선순위 큐에서 제거
 */
class PriorityQueue {
    constructor() {
        this.queue = [];
    }

    getLeftChildIndex = (parentIndex) => parentIndex * 2 + 1;
    getRightChildIndex = (parentIndex) => parentIndex * 2 + 2;
    getParentIndex = (childIndex) => parseInt((childIndex - 1) / 2);

    enqueue = (priority, value) => {
        const node = { priority, value };
        this.queue.push(node);
        this.heapifyUp();
    };
    heapifyUp = () => {
        let index = this.queue.length - 1;
        const lastInsertedNode = this.queue[index];

        while (index > 0) {
            const parentIndex = this.getParentIndex(index);
            if (this.queue[parentIndex].priority >= lastInsertedNode.priority) break;
            this.queue[index] = this.queue[parentIndex];
            index = parentIndex;
        }
        this.queue[index] = lastInsertedNode;
    };

    dequeue = () => {
        const count = this.queue.length;
        if (count <= 0) return undefined;

        const rootNode = this.queue[0];

        if (count === 1) return this.queue.pop();
        this.queue[0] = this.queue.pop();
        this.heapifyDown();
        return rootNode;
    };
    heapifyDown = () => {
        let index = 0;
        const count = this.queue.length;
        const rootNode = this.queue[index];

        while (this.getLeftChildIndex(index) < count) {
            const leftChildIndex = this.getLeftChildIndex(index);
            const rightChildIndex = this.getRightChildIndex(index);

            const biggerChildIndex =
                rightChildIndex < count && this.queue[rightChildIndex].priority > this.queue[leftChildIndex].priority
                    ? rightChildIndex
                    : leftChildIndex;
            if (this.queue[biggerChildIndex].priority <= rootNode.priority) break;
            this.queue[index] = this.queue[biggerChildIndex];
            index = biggerChildIndex;
        }
        this.queue[index] = rootNode;
    };
    isEmpty = () => this.queue.length <= 0;
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const jewels = []; // 무게, 가격
const bags = []; // 가방 최대 무게

const [N, K] = input[0].split(' ').map(Number); // 보석 종류 N, 가방 수 K
for (let i = 1; i <= N; i++) {
    const [M, V] = input[i].split(' ').map(Number);
    jewels.push([M, V]);
}
jewels.sort((a, b) => a[0] - b[0]); // 무게 오름차순 정렬

for (let i = N + 1; i < N + 1 + K; i++) bags.push(+input[i]); // 가방 최대 무게
bags.sort((a, b) => a - b); // 가방 오름차순 정렬

let result = 0;
const pq = new PriorityQueue();
let j = 0; // 우선순위 큐에 넣은 보석 인덱스
for (const b of bags) {
    // 들어갈 수 있는 보석들을 우선순위 큐에 넣기(어차피 가장 작은 가방에 들어가면 뒤에 있는 가방에는 무조건 들어감)
    while (j < N && b >= jewels[j][0]) {
        pq.enqueue(jewels[j][1], jewels[j][0]);
        j += 1;
    }
    if (!pq.isEmpty()) {
        const { priority } = pq.dequeue(); // 가장 비싼 보석 먼저 넣기
        result += priority;
    }
}
console.log(result);
