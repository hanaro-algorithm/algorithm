function solution(board) {
  const row = board.length;
  const col = board[0].length;
  // dp 배열 만들기
  const dp = Array.from({ length: row }, () => new Array(col).fill(0));

  let maxLength = 0;

  // 1행과 1열은 board값으로 채워주기
  // 이때, 1행과 1열에서 1인 값이 존재할 수 있기 때문에 긴 배열 길이 값 확인
  for (let i = 0; i < row; i += 1) {
    dp[i][0] = board[i][0];
    if (maxLength < dp[i][0]) maxLength = dp[i][0];
  }
  for (let i = 0; i < col; i += 1) {
    dp[0][i] = board[0][i];
    if (maxLength < dp[0][i]) maxLength = dp[0][i];
  }

  for (let i = 1; i < row; i += 1) {
    for (let j = 1; j < col; j += 1) {
      if (board[i][j] === 1) {
        // 현재 board의 위치값이 1인 경우
        // 위, 왼쪽, 왼쪽위 중 가장 작은 값에 + 1
        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
      }
      if (maxLength < dp[i][j]) maxLength = dp[i][j]; // 현재까지 가장 긴 정사각형 길이 저장
    }
  }
  return maxLength ** 2;
}

console.log(
  solution([
    [0, 1, 1, 1],
    [1, 1, 1, 1],
    [1, 1, 1, 1],
    [0, 0, 1, 0],
  ])
);

console.log(
  solution([
    [0, 0, 1, 1],
    [1, 1, 1, 1],
  ])
);
console.log(
  solution([
    [0, 0, 0, 0],
    [0, 0, 0, 0],
  ])
);

console.log(
  solution([
    [0, 0, 0, 1],
    [0, 0, 0, 0],
  ])
);
