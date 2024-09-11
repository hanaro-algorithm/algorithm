const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const name = input[0].split('').sort(); // 임한수의 영어 이름(50자 이내)
const nameLen = name.length; // 영어 이름 길이

let result = '';

// 알파벳 개수 세는 함수
function countArr(value) {
  let count = 0;
  name.forEach((n) => {
    if (n === value) count += 1;
  });
  return count;
}

let arr = Array.from({ length: nameLen }, () => ''); // 팰린드롬 만들기 위한 배열
let start = 0;
let end = nameLen - 1;
while (name.length > 0) {
  let cnt = countArr(name[0]);
  // 해당 알파벳 개수가 2개 이상인 경우
  if (cnt >= 2) {
    arr[start] = name[0];
    arr[end] = name[0];
    name.splice(0, 2); // name에서 앞 2개 제거하기
    start += 1;
    end -= 1;
  } else {
    // 홀수인 경우, 팰린드롬 배열 가운데가 비어있을 때만 해당 값 집어넣기
    if (arr[parseInt(nameLen / 2)] === '') {
      arr[parseInt(nameLen / 2)] = name[0];
      name.splice(0, 1);
    }
    // 그외의 경우 팰린드롬이 나올 수 없음
    else {
      console.log(`I'm Sorry Hansoo`);
      return;
    }
  }
}

result = arr.join(''); // 문자열로 다시 합치기

console.log(result);
