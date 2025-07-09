const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = +input[0];
const arr = [];

for (let i = 1; i <= N; i++) {
  arr.push(+input[i]);
}

arr.sort((o1, o2) => o1 - o2);

// 투포인터 알고리즘 사용
let left = 0;
let right = 0;
// 나올 수 있는 정답의 최댓값은 4이므로 4로 초기화한다.
let ans = 4;

while (right < N) {
  // 범위 내의 제일 오른쪽 값 - 제일 왼쪽 값이 5 이내라면, 정답을 갱신하고 right++
  // 제일 왼쪽 값부터 연속된 숫자 5개를 사용할건데, 몇개가 추가로 더 필요한지 알기 위해
  // 5 - (right - left)를 계산한다.
  if (arr[right] - arr[left] < 5) {
    right++;
    ans = Math.min(ans, 5 - (right - left));

    // 그 외의 경우는 left++;
  } else {
    left++;
  }
}

console.log(ans);
