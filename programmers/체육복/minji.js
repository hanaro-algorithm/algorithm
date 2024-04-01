function solution(n, lost, reserve) {
  let answer = 0;
  // 오름차순 정렬
  lost.sort((a, b) => a - b);
  reserve.sort((a, b) => a - b);

  // lost와 reverse에 중복된 사람 제거
  let duplicate = reserve.filter((r) => lost.includes(r));
  duplicate.forEach((d) => {
    const idx1 = lost.indexOf(d);
    const idx2 = reserve.indexOf(d);
    lost.splice(idx1, 1);
    reserve.splice(idx2, 1);
  });

  for (let r = 0; r < reserve.length; r += 1) {
    // 현재 값보다 1작은 수가 lost에 존재하면 그 학생에게 체육복 빌려주기
    if (lost.includes(reserve[r] - 1)) {
      const idx = lost.indexOf(reserve[r] - 1);
      lost.splice(idx, 1);
      continue;
    }
    // 현재 값보다 1큰 수가 lost에 존재하면 그 학생에게 체육복 빌려주기
    else if (lost.includes(reserve[r] + 1)) {
      const idx = lost.indexOf(reserve[r] + 1);
      lost.splice(idx, 1);
      continue;
    }
  }
  // 빌리지 못한 학생 전체 학생 수에서 빼주기
  answer = n - lost.length;
  return answer;
}

console.log(solution(5, [2, 4], [1, 3, 5]));
console.log(solution(5, [2, 4], [3]));
console.log(solution(3, [3], [1]));
