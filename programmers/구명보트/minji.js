function solution(people, limit) {
  people.sort((a, b) => b - a); // 내림차순 정렬
  let cnt = 0; // 구명보트 개수
  let start = 0;
  let end = people.length - 1;
  // 무게가 큰 사람과 무게가 가장 작은 사람의 합을 limit과 비교하며 구명보트 개수 확인
  while (start <= end) {
    if (start !== end && people[start] + people[end] <= limit) {
      start += 1;
      end -= 1;
    } else {
      start += 1;
    }
    cnt += 1;
  }
  return cnt;
}
console.log(solution([70, 50, 80, 50], 100)); // 3
console.log(solution([70, 80, 50], 100)); // 3
console.log(solution([10, 20, 70], 100)); // 2
console.log(solution([80, 70, 50, 50, 40, 10], 100)); // 4
console.log(solution([10, 20, 50, 50, 70, 80], 100)); // 3
