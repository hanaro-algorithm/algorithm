const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const words = [];
for (let i = 0; i < 6; i += 1) words.push(input[i]);

// 3개 선택할 순열 함수
const permutationFunc = (arr, num) => {
  if (num === 1) return arr.map((a) => [a]);
  const result = [];
  arr.map((fixed, index, origin) => {
    const rest = [...origin.slice(0, index), ...origin.slice(index + 1)];
    const permutation = permutationFunc(rest, num - 1);
    const attached = permutation.map((com) => [fixed, ...com]);
    result.push(...attached);
  });
  return result;
};

const permu = permutationFunc(words, 3);

const set = new Set();

// 가능한 순열 순회하며 가로, 세로 단어 집어넣기
permu.forEach((word) => {
  const dictionary = [];
  dictionary.push(...word);
  for (let i = 0; i < 3; i += 1) {
    dictionary.push(word[0][i] + word[1][i] + word[2][i]);
  }
  dictionary.sort();
  let result = true;
  // 정렬 후 words랑 일치하지 않으면 불가능한 경우이므로 false
  for (let i = 0; i < 6; i += 1) if (dictionary[i] !== words[i]) result = false;
  if (result) set.add(word); // 가능한 경우에만 집합에 넣기
});

const answer = [...set][0]; // 정렬된 기준에서 집어넣었으므로 맨 앞 단어들만 추출
answer
  ? console.log(`${answer[0]}\n${answer[1]}\n${answer[2]}`)
  : console.log(0);
