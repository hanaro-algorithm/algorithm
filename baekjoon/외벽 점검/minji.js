function solution(n, weak, dist) {
  const flattenWeak = [...weak, ...weak.map((elem) => elem + n)];
  const weakLen = weak.length;
  const distLen = dist.length;
  const visits = new Array(distLen).fill(0);
  let answer = distLen + 1;

  if (weakLen === 1) return 1;

  function permutation(L, arr) {
    if (L === distLen) {
      for (let i = 0; i < weakLen; i += 1) {
        const end = i + weakLen;
        let left = i;
        let cnt = 0;

        for (let elem of arr) {
          if (left >= end) break;
          cnt += 1;
          const maxDist = elem + flattenWeak[left];

          while (left < end && maxDist >= flattenWeak[left]) left += 1;
        }
        if (left < end) continue;

        answer = Math.min(answer, cnt);
      }
      return;
    }
    for (let i = 0; i < distLen; i += 1) {
      if (visits[i]) continue;
      visits[i] = 1;
      permutation(L + 1, [...arr, dist[i]]);
      visits[i] = 0;
    }
  }
  permutation(0, []);

  return answer === distLen + 1 ? -1 : answer;
}

console.log(solution(12, [1, 5, 6, 10], [1, 2, 3, 4]));
console.log(solution(12, [1, 3, 4, 9, 10], [3, 5, 7]));
