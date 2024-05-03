function solution(s) {
  let answer = Number.MAX_SAFE_INTEGER; // 정수 값 중 가장 큰 값로 초기화

  for (let i = 1; i <= s.length; i += 1) {
    let splitArr = splitStr(s, i); // 1부터 문자열 길이만큼 쪼개기
    let count = 1; // 반복횟수
    let newStr = ""; // 압축한 문자열
    let str = splitArr[0]; // 비교할 문자
    for (let j = 1; j < splitArr.length; j += 1) {
      // 반복된다면 반복 횟수 증가
      if (str === splitArr[j]) count += 1;
      else {
        // 압축 문자열 만들기
        if (str !== "") newStr = connectNewStr(newStr, str, count);
        str = splitArr[j]; // 비교할 문자 변경
        count = 1; // 반복횟수 리셋
      }
    }
    newStr = connectNewStr(newStr, str, count); // 남은 문자를 압축 문자열에 추가
    answer = Math.min(answer, newStr.length); // 가장 크기가 작은 문자열 반환
  }
  return answer;
}

// 문자열 쪼개는 함수
function splitStr(str, unit) {
  let newArr = [];
  let last = unit;
  for (let i = 0; i < str.length; i += unit) {
    let splitS = str.slice(i, last);
    newArr.push(splitS);
    last += unit;
  }
  return newArr;
}

function connectNewStr(newStr, str, count) {
  newStr += count > 1 ? `${count}${str}` : `${str}`;
  return newStr;
}

console.log(solution("a")); // 1
console.log(solution("aabbaccc")); // 7
console.log(solution("ababcdcdababcdcd")); // 9
console.log(solution("abcabcdede")); // 8
console.log(solution("abcabcabcabcdededededede")); // 14
console.log(solution("xababcdcdababcdcd")); // 17
