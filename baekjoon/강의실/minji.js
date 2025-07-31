class MinHeap {
  constructor() {
    this.heap = [];
  }
  getParentIndex = (childIndex) => parseInt((childIndex - 1) / 2);
  getLeftChildIndex = (parentIndex) => parentIndex * 2 + 1;
  getRightChildIndex = (parentIndex) => parentIndex * 2 + 2;
  getHeapLen = () => this.heap.length;

  enqueue = (startTime, endTime) => {
    const node = { startTime, endTime };
    this.heap.push(node);
    this.heapifyUp();
  };
  heapifyUp = () => {
    let index = this.getHeapLen() - 1;
    const lastInsertedNode = this.heap[index];

    while (index > 0) {
      const parentNodeIndex = this.getParentIndex(index);
      if (this.heap[parentNodeIndex].endTime <= lastInsertedNode.endTime) break;
      this.heap[index] = this.heap[parentNodeIndex];
      index = parentNodeIndex;
    }
    this.heap[index] = lastInsertedNode;
  };
  peek = () => this.heap[0];
  dequeue = () => {
    const len = this.getHeapLen();
    if (len <= 0) return undefined;

    const rootNode = this.heap[0];

    if (len === 1) return this.heap.pop();
    this.heap[0] = this.heap.pop();
    this.heapifyDown();
    return rootNode;
  };
  heapifyDown = () => {
    let index = 0;
    const len = this.getHeapLen();
    const rootNode = this.heap[index];
    while (this.getLeftChildIndex(index) < len) {
      const leftChildIdx = this.getLeftChildIndex(index);
      const rightChildIdx = this.getRightChildIndex(index);

      const smallerChildIndex =
        rightChildIdx < len &&
        this.heap[rightChildIdx].endTime < this.heap[leftChildIdx].endTime
          ? rightChildIdx
          : leftChildIdx;

      if (this.heap[smallerChildIndex].endTime > rootNode.endTime) break;
      this.heap[index] = this.heap[smallerChildIndex];
      index = smallerChildIndex;
    }
    this.heap[index] = rootNode;
  };
}

// 우선순위 큐 이용!
// 강의 시간이 가장 빨리 끝나는 순으로 배열에 저장해서 시작해야할 강의 시간과 비교해 강의실 개수 카운트

const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0]; // 강의의 개수
const classes = [];
for (let c = 1; c <= N; c++) classes.push(input[c].split(" ").map(Number));
classes.sort((a, b) => a[1] - b[1] || a[2] - b[2]); // 시작 시간 기준 오름차순 정렬(같으면 종료 시간 기준 오름차순 정렬)

const minHeap = new MinHeap(); // 최소 힙 객체 생성
minHeap.enqueue(classes[0][1], classes[0][2]); // 첫 강의의 시작시간과 종료시간 넣기
let classRoomCnt = 1; // 초기 강의실 1개 사용

for (let c = 1; c < N; c++) {
  const [classNum, startTime, endTime] = classes[c];

  // 가장 빨리 끝나는 강의 종료 시간보다 시작할 강의 시간이 더 작은 경우
  // 강의실 개수 1개 추가
  if (minHeap.peek().endTime > startTime) {
    minHeap.enqueue(startTime, endTime);
    classRoomCnt++;
  }
  // 가장 빨리 끝나는 강의 종료 시간보다 시작할 강의 시간이 크거나 같은 경우
  // 해당 강의실 사용
  else {
    minHeap.dequeue();
    minHeap.enqueue(startTime, endTime);
  }
}

console.log(classRoomCnt);
