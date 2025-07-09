class MinHeap {
  constructor() {
    this.heap = []; // 빈 배열 생성
  }

  getLeftChildIndex = (parentIndex) => parentIndex * 2 + 1; // 왼쪽 자식 인덱스
  getRightChildIndex = (parentIndex) => parentIndex * 2 + 2; // 오른쪽 자식 인덱스
  getParentIndex = (childIndex) => Math.floor((childIndex - 1) / 2); // 부모 인덱스

  peek = () => this.heap[0].key; // 루트 노드 반환
  size = () => this.heap.length; // heap 배열 크기 반환
  isEmpty = () => this.heap.length === 0;

  // 원소 삽입
  enqueue = (value) => {
    this.heap.push(value); // 새 원소 마지막 위치에 삽입
    this.heapifyUp(); // 정렬 수행
  };

  // 아래에서 위로 정렬
  heapifyUp = () => {
    let index = this.size() - 1; // 마지막 인덱스
    const lastNode = this.heap[index]; // 마지막 원소

    while (index > 0) {
      const parentIdx = this.getParentIndex(index); // 부모 인덱스 찾기
      // 부모 원소의 종료 시간이 자식 원소 종료시간보다 큰 경우 swap
      if (this.heap[parentIdx] > lastNode) {
        this.heap[index] = this.heap[parentIdx];
        index = parentIdx;
      } else break;
    }
    this.heap[index] = lastNode; // 본인 자리 찾아가기
  };

  // 원소 삭제
  dequeue = () => {
    if (this.isEmpty()) return null; // 비어있는 경우 삭제 불가능

    const rootNode = this.heap[0];
    if (this.heap.length === 1) this.heap = [];
    else {
      this.heap[0] = this.heap.pop(); // 맨 마지막에 있는 원소 루트로 이동
      this.heapifyDown(); // 정렬 수행
    }
    return rootNode; // 루트 노드 반환
  };

  // 위에서 아래로 정렬
  heapifyDown = () => {
    let index = 0;
    const heapSize = this.size();
    const rootNode = this.heap[index];

    while (this.getLeftChildIndex(index) < heapSize) {
      const leftChildIdx = this.getLeftChildIndex(index); // 왼쪽 자식 인덱스
      const rightChildIdx = this.getRightChildIndex(index); // 오른쪽 자식 인덱스

      // 부모노드가 자식 노드들보다 값이 큰 경우 swap
      // 왼쪽 자식 노드와 오른쪽 자식 노드 중 더 작은 값을 가지는 인덱스와 부모 노드랑 변경
      const smallerChildIndex =
        rightChildIdx < heapSize &&
        this.heap[rightChildIdx] < this.heap[leftChildIdx]
          ? rightChildIdx
          : leftChildIdx;

      // 자식 노드 값이 부모 노드보다 작은 경우 swap
      if (this.heap[smallerChildIndex] <= rootNode) {
        this.heap[index] = this.heap[smallerChildIndex];
        index = smallerChildIndex;
      } else break;
    }
    this.heap[index] = rootNode;
  };

  size = () => this.heap.length; // 힙 크기

  sum = () => this.heap.reduce((acc, cur) => acc + cur, 0); // 힙 내에 있는 원소의 합
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 숙제의 개수
const problems = [];
for (let i = 1; i <= N; i++) {
  const [deadline, ramen] = input[i].split(' ').map(Number); // 각 문제 당 데드라인, 최대로 받을 수 있는 컵라면 수
  problems.push({
    deadline,
    ramenCnt: ramen,
  });
}

problems.sort((a, b) => a.deadline - b.deadline); // 데드라인 기준 오름차순 정렬

const pq = new MinHeap();

for (const p of problems) {
  pq.enqueue(p.ramenCnt); // 문제 풀기
  if (pq.size() > p.deadline) pq.dequeue(); // 지금까지 푼 문제의 수가 데드라인보다 더 많을 때, 가장 컵라면 수가 적은 문제 빼기
}
console.log(pq.sum());
