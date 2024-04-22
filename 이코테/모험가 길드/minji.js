function solution(N, phobias) {
  phobias.sort((a, b) => a - b); // 모험가 공포도 오름차순 정렬
  let count = 0; // 모험가 그룹 갯수
  let people = 0; // 한 그룹 내 사람 수

  let maxPhobia = phobias[0];
  phobias.map((phobia) => {
    if (phobia > maxPhobia) maxPhobia = phobia;
    people += 1;
    if (people === maxPhobia) {
      count += 1;
      people = 0;
      maxPhobia = 0;
    }
  });
  return count;
}

console.log(solution(5, [2, 3, 1, 2, 2])); // 2
console.log(solution(5, [2, 2, 1, 2, 2])); // 3
console.log(solution(7, [2, 3, 1, 2, 2, 2, 4])); // 3
console.log(solution(6, [2, 3, 1, 2, 2, 3])); // 3
console.log(solution(5, [1, 1, 2, 3, 3])); // 3
console.log(solution(5, [1, 1, 1, 1, 1])); // 5

// 2 3 1 2 2 2 4
// 1 22 232
// 2 3 1 2 2
// 1 22 23
// 2 3 1 2 2 3
// 1 22 233
// 2 2 1 2 2
// 1 22 22
