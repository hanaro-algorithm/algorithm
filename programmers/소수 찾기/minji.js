function solution(numbers) {
  numbers = numbers.split("").map(Number);

  let prime = new Set(); // 중복값 제거를 위해 집합 이용

  for (let i = 0; i < numbers.length; i += 1) {
    // 방문 횟수 표시
    let visited = new Array(numbers.length).fill(false);
    dfs(prime, numbers[i], i, visited, numbers);
  }
  let answer = prime.size;
  return answer;
}

// 소수인지 판단하는 함수
function isPrime(num) {
  if (num <= 1) return false;
  if (num === 2) return true;
  for (let i = 2; i < num; i += 1) {
    if (num % i === 0) return false;
  }
  return true;
}

function dfs(prime, num, idx, visited, numbers) {
  visited[idx] = true; // 현재 위치 방문 표시
  if (isPrime(num)) prime.add(+num); // 소수이면 집합에 넣어주기

  // 방문하지 않은 곳 인덱스 확인
  const notVisited = visited
    .map((v, idx) => {
      if (v === false) return idx;
      else return -1;
    })
    .filter((v) => v !== -1);

  // 방문하지 않은 곳 dfs 수행
  notVisited.map((item) => {
    dfs(prime, +(String(num) + String(numbers[item])), item, visited, numbers);
    visited[item] = false; // 다시 방문 표시 제거
  });
}

console.log(solution("17"));
console.log(solution("011"));
console.log(solution("013"));

// 3 13 31 103
