const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const T = +input[0]; // 테스크 케이스
const availableString = ['A', 'B', 'C', 'D', 'E', 'F'];
let line = 1; // 테스트 케이스 라인

// 연속된 중복 문자 제거 함수
const removeContinuousStr = (str) => {
  let removeStr = '';
  str.reduce((prev, cur) => {
    if (prev !== cur) removeStr += cur;
    return cur;
  }, '');
  return removeStr;
};

// A~F 이외의 문자를 포함하고 있는지 확인하는 함수
const checkInavailableStr = (str) => {
  for (let i = 0; i < str.length; i += 1) {
    if (!availableString.includes(str[i])) return false;
  }
  return true;
};

let result = '';
while (line <= T) {
  const str = input[line].split('');
  // {A, B, C, D, E, F}에 포함되지 않는 문자가 있는 경우 바로 패스
  if (!checkInavailableStr(str)) result += 'Good\n';
  else {
    // 문자 길이가 3 또는 4인 경우는 AFC만 포함하면 Infected임
    if (str.length === 3 || str.length === 4)
      result += str.join('').includes('AFC') ? 'Infected!\n' : 'Good\n';
    // 맨 앞이랑 맨 뒤 제외하고 중간 문자열의 연속된 중복 제거한 값이 AFC이면 Infected임
    else {
      result +=
        removeContinuousStr([...str.slice(1, str.length)]) === 'AFC'
          ? 'Infected!\n'
          : 'Good\n';
    }
  }
  line += 1;
}

result = result.trimEnd();
console.log(result);
