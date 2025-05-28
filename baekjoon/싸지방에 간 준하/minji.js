/**
 * 문제) 싸지방에 간 준하
 * 모든 사람이 기다리지 않고 싸지방 이용할 수 있는 컴퓨터의 최소개수와 자리별 이용 횟수 구하기
 *
 * 컴퓨터가 있는 자리에는 1번부터 순서대로 번호 매겨있음
 * 싸지방 들어왔을 때 빈 자리 중 번호가 가장 작은 자리에 앉아야함
 */
// 우선순위 큐 구현
class PriorityQueue {
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
  enqueue = (key, value) => {
    const node = { key, value };
    this.heap.push(node); // 새 원소 마지막 위치에 삽입
    this.heapifyUp(); // 정렬 수행
  };

  // 아래에서 위로 정렬
  heapifyUp = () => {
    let index = this.size() - 1; // 마지막 인덱스
    const lastNode = this.heap[index]; // 마지막 원소

    while (index > 0) {
      const parentIdx = this.getParentIndex(index); // 부모 인덱스 찾기
      // 부모 원소의 종료 시간이 자식 원소 종료시간보다 큰 경우 swap
      if (this.heap[parentIdx].key > lastNode.key) {
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
        this.heap[rightChildIdx].key < this.heap[leftChildIdx].key
          ? rightChildIdx
          : leftChildIdx;

      // 자식 노드 값이 부모 노드보다 작은 경우 swap
      if (this.heap[smallerChildIndex].key <= rootNode.key) {
        this.heap[index] = this.heap[smallerChildIndex];
        index = smallerChildIndex;
      } else break;
    }
    this.heap[index] = rootNode;
  };
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 사람의 수
const people = [];
for (let p = 1; p <= N; p++) {
  const [P, Q] = input[p].split(' ').map(Number); // P: 컴퓨터 이용 시작 시각, Q: 종료 시각
  people.push({ P: P, Q: Q });
}
people.sort((a, b) => a.P - b.P);

let number = 0;
const computers = [];
const usedComputers = new PriorityQueue(); // 사용 중인 컴퓨터
const unUsedComputers = new PriorityQueue(); // 사용이 끝난 컴퓨터
for (const p of people) {
  const { P, Q } = p;
  // 사용이 끝난 컴퓨터가 있는지 확인
  while (!usedComputers.isEmpty() && usedComputers.peek() <= P) {
    const { value: computerIdx } = usedComputers.dequeue(); // 끝난 컴퓨터 정보(종료시간, 컴퓨터 번호) 꺼내기
    unUsedComputers.enqueue(computerIdx, 0); // 사용 끝난 컴퓨터 저장 => 컴퓨터 번호 오름차순으로 정렬
  }

  // 사용이 끝난 컴퓨터가 있는 경우
  // 해당 컴퓨터 번호 이용
  if (!unUsedComputers.isEmpty()) {
    const { key: computerIdx } = unUsedComputers.dequeue();
    computers[computerIdx] += 1; // 해당 컴퓨터 이용 횟수 추가
    usedComputers.enqueue(Q, computerIdx); // 다시 이용중인 컴퓨터로 변경
  }
  // 사용이 끝난 컴퓨터가 없는 경우
  // 새로운 컴퓨터 추가
  else {
    usedComputers.enqueue(Q, number);
    computers.push(1);
    number++;
  }
}

console.log(number);
console.log(computers.join(' '));
