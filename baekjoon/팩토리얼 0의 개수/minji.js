const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const M = +input[0];

// 결과는 5의 배수로 나옴 => 2*5
// N=5 => 1
// N=10 => 2
// N=15 => 3
// N=25 => 6
let result = -1;
let start = 1; // 시작값 1부터
let end = 5 * M; // 끝값은 M*5

// 이분탐색 시작
while (start <= end) {
  let mid = parseInt((start + end) / 2);
  const N = find5Count(mid); // mid!에 N이 몇개 있는지 확인

  // N이 M보다 작으면 mid 기준 오른쪽 탐색
  if (N < M) {
    start = mid + 1;
  } else {
    if (N === M) result = mid; // N이 M인 경우 결과 출력
    end = mid - 1;
  }
}

// 5의 개수 구하기
function find5Count(num) {
  let count = 0;
  // 5로 나눌 수 있을 떄까지의 몫의 합이 num!의 5의 개수와 같음
  while (num >= 5) {
    num = parseInt(num / 5);
    count += num;
  }
  return count;
}

console.log(result);
