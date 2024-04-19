function solution(expression) {
  var answer = 0;

  // 나올 수 있는 우선순위 순열 구하기
  let permutationList = [];
  permutation([], ["+", "-", "*"], permutationList);

  // expression 중에 숫자만 뽑아내기
  let numbers = expression.split(/[+]|[-]|[*]/).map(Number);
  // expression 중에 연산자만 뽑아내기
  let operations = expression
    .split(/[0-9]/)
    .filter((operation) => operation !== "");

  /*
   * 100 - 200 * 300 - 500 + 20
   * numbers = [100, 200, 300, 500, 20]
   * operations = ['-', '*', '-', '+']
   * 만약, + > - > * 순 우선순위이면,
   * + 인덱스가 3이면, numbers에서도 인덱스가 3인 500과 인덱스+1인 4의 20이 연산되어
   * 해당 인덱스인 3에 연산된 결과 집어넣고 인덱스 + 1에 있는 숫자는 제거
   * 이런식으로 숫자 연산순위에 맞춰 숫자 계산
   */
  permutationList.map((permutation) => {
    let newNumbers = [...numbers];
    let newOperations = [...operations];
    while (newOperations.length !== 0) {
      if (!newOperations.includes(permutation[0])) {
        permutation.shift();
        continue;
      }
      const idx = newOperations.findIndex((item) => item === permutation[0]);
      const cal = calculate(
        newNumbers[idx],
        newNumbers[idx + 1],
        newOperations[idx]
      );
      newNumbers.splice(idx + 1, 1);
      newNumbers[idx] = cal;
      newOperations.splice(idx, 1);
    }
    answer = Math.max(answer, Math.abs(newNumbers[0])); // 가장 큰 값 저장
  });
  return answer;
}

// +, -, * 의 우선순위 순열
function permutation(permu, rests, list) {
  if (rests.length === 0) return list.push(permu);
  rests.map((r, index) => {
    const rest = [...rests.slice(0, index), ...rests.slice(index + 1)];
    permutation([...permu, r], rest, list);
  });
}

function calculate(num1, num2, oper) {
  if (oper === "+") return num1 + num2;
  else if (oper === "-") return num1 - num2;
  else if (oper === "*") return num1 * num2;
}

console.log(solution("100-200*300-500+20"));
console.log(solution("50*6-3*2"));
