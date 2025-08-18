const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let line = 0;

let answer = '';
outer: while (true) {
    const stack = [];
    const str = input[line++].split('');
    if (str[0] === '.') break; // 입력 종료

    for (let s = 0; s < str.length; s++){
        if (str[s] === '(' || str[s] === '[') stack.push(str[s]);
        else if (str[s] === ')') {
            if (stack.length === 0 || stack.pop() !== '(') {
                answer += "no\n";
                continue outer;
            }
        } else if (str[s] === ']') {
            if (stack.length === 0 || stack.pop() !== '[') {
                answer += "no\n";
                continue outer;
            }
        }
    }
    if (stack.length !== 0) answer += 'no\n';
    else answer += 'yes\n';
}

console.log(answer.trimEnd());