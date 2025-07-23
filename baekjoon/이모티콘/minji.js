/**
 * 문제) 이모티콘
 * 3가지 연산을 사용해 이모티콘 S개를 만드는 데 걸리는 최소 시간
 * [연산]
 * 1. 화면에 있는 이모티콘 모두 복사해 클립보드에 저장 => 1초
 * 2. 클립보드에 있는 모든 이모티콘 화면에 복붙 => 1초
 * 3. 화면에 있는 이모티콘 중 하나 삭제 => 1초
 *
 * ＊처음 화면에 이모티콘 1개 이미 존재
 */
class Queue {
  constructor() {
    this.queue = {};
    this.headIndex = 0;
    this.tailIndex = 0;
  }
  enqueue = (item) => {
    this.queue[this.tailIndex++] = item;
  };
  dequeue = () => this.queue[this.headIndex++];
  getLength = () => this.tailIndex - this.headIndex;
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const S = +input[0]; // 만들고자 하는 이모티콘 개수

const visited = Array.from({ length: 2001 }, () =>
  Array.from({ length: 2001 }, () => false)
); // display, clipboard 방문 배열

const queue = new Queue();
queue.enqueue([1, 0, 0]); // display, clipboard, time 초기값 저장
visited[1][0] = true; // 화면에는 이미 1개의 이모티콘 존재

while (queue.getLength() > 0) {
  const [display, clipboard, time] = queue.dequeue();
  // 화면에 S개의 이모티콘이 만들어졌을 때
  if (display === S) {
    console.log(time);
    break;
  }

  // 1번 과정) 화면에 있는 이모티콘 모두 복사해 클립보드에 저장
  if (!visited[display][display]) {
    visited[display][display] = true;
    queue.enqueue([display, display, time + 1]);
  }
  // 2번 과정) 클립보드에 저장된 이모티콘 화면에 붙이기(클립보드에 아무것도 없으면 붙일 수 없음)
  if (
    clipboard > 0 &&
    display + clipboard <= 2000 &&
    !visited[display + clipboard][clipboard]
  ) {
    visited[display + clipboard][clipboard] = true;
    queue.enqueue([display + clipboard, clipboard, time + 1]);
  }
  // 3번 과정) 화면에 있는 이모티콘 1개 지우기(화면에 아무것도 없으면 지울 수 없음)
  if (display > 0 && !visited[display - 1][clipboard]) {
    visited[display - 1][clipboard] = true;
    queue.enqueue([display - 1, clipboard, time + 1]);
  }
}
