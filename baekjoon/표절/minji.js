const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // 제출한 솔루션 개수
const size = input[1].split(' ').map(Number); // 각 솔루션 파일 크기

size.sort((a, b) => a - b); // 오름차순 정렬
const size_09 = size.map((s) => s * 0.9); // 모든 솔루션 파일 크기에 0.9 곱해놓은 배열 만들기

let cnt = 0; // 검사해야할 쌍의 개수

// 이분 탐색
const binarySearch = (target, index, start, end) => {
  while (start < end) {
    const mid = parseInt((start + end) / 2);
    if (size_09[mid] <= target)
      start = mid + 1; // 조건 만족할 경우
    else end = mid; // 조건 만족하지 않을 경우
  }
  cnt += end - index - 1;
};

size.forEach((s, idx) => binarySearch(s, idx, idx, N));
console.log(cnt);
