function solution(s) {
  var answer = true;
  let stack = [];
  let inCnt = 0; // '(' 카운트
  let outCnt = 0; // ')' 카운트
  s = s.split("");
  s.map((item) => {
    if (item === "(") {
      stack.push(item);
      inCnt += 1;
    } else {
      stack.pop();
      outCnt += 1;
    }
  });

  // stack에 값이 남아있거나
  // 바르게 짝지어진 것은 inCnt와 outCnt 수가 일치하기 때문에
  // 일치하지 않은 경우 false 반환
  if (stack.length || inCnt !== outCnt) answer = false;
  return answer;
}

console.log(solution("()()"));
console.log(solution("(())()"));
console.log(solution(")()("));
console.log(solution("(()("));
console.log(solution(")"));
console.log(solution("))"));
