const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let abbreviatedIPv6 = input[0].split(':');

const noZero = abbreviatedIPv6.filter((ipv6) => ipv6 !== '');

abbreviatedIPv6 = abbreviatedIPv6.map((ipv6, index, all) => {
  if (ipv6 !== '') return ipv6.padStart(4, '0');
  else if (ipv6 === '' && all[index + 1] !== '')
    return ipv6.padStart(4, '0').repeat(8 - noZero.length);
});

let answer = '';
abbreviatedIPv6.forEach((ipv6) => {
  if (ipv6) {
    if (ipv6.length === 4) answer += ipv6 + ':';
    else {
      let [start, end] = [0, 4];
      while (end <= ipv6.length) {
        answer += ipv6.slice(start, end) + ':';
        start += 4;
        end += 4;
      }
    }
  }
});

answer = answer.slice(0, answer.length - 1);
console.log(answer);
