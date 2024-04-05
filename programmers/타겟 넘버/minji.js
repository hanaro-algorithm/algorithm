function solution(numbers, target) {
  let cnt = 0;

  function dfs(num, depth) {
    // numbers에 있는 값들을 모두 사용할 때까지 dfs수행
    if (depth === numbers.length) {
      if (num === target) cnt += 1;
      return;
    } else {
      dfs(num + numbers[depth], depth + 1); // 이전 누적합에 현재값 더해주기
      dfs(num - numbers[depth], depth + 1); // 이전 누적합에 현재값 빼주기
    }
  }
  dfs(0, 0); // dfs(누적합, 깊이) // 깊이는 numbers배열을 모두 순회하기 위해 사용

  return cnt;
}

console.log(solution([1, 1, 1, 1, 1], 3));
console.log(solution([4, 1, 2, 1], 4));
