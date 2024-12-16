const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = +input[0]; // 카드 n장
const k = +input[1]; // 뽑을 카드 수
const cards = [];
for (let i = 2; i < 2 + n; i += 1) cards.push(input[i]);

// 백트래킹
const backtrackingSet = new Set();
const visited = Array.from({ length: 11 }, () => false);
const backtracking = (depth, selected) => {
  if (depth === k) {
    backtrackingSet.add(selected.join(''));
    return;
  }
  for (let i = 0; i < n; i += 1) {
    if (!visited[i]) {
      visited[i] = true;
      selected.push(cards[i]);
      backtracking(depth + 1, selected);
      selected.pop();
      visited[i] = false;
    }
  }
};

backtracking(0, []);
console.log(backtrackingSet.size);

// 순열
const permutationFunc = (arr, selectedNum) => {
  if (selectedNum === 1) return arr.map((a) => [a]);
  const result = [];
  arr.map((fixed, index, origin) => {
    const rest = [...origin.slice(0, index), ...origin.slice(index + 1)];
    const permutation = permutationFunc(rest, selectedNum - 1);
    const attached = permutation.map((item) => [fixed, ...item]);
    result.push(...attached);
  });
  return result;
};

const permutationResult = permutationFunc(cards, k);
const set = new Set();
permutationResult.forEach((permu) => set.add(+permu.join('')));
console.log(set.size);
