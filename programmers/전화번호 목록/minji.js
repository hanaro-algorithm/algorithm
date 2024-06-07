function solution(phone_book) {
  let answer = true;

  phone_book.sort();

  for (let i = 1; i < phone_book.length; i += 1) {
    if (phone_book[i].startsWith(phone_book[i - 1])) {
      answer = false;
      break;
    }
  }

  return answer;
}

console.log(solution(['119', '97674223', '1195524421']));
console.log(solution(['123', '456', '789']));
console.log(solution(['12', '123', '1235', '567', '88']));
