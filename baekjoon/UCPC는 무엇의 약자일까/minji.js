const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const reg = /.*U.*C.*P.*C/; // U->C->P->C 순으로 존재하는지 확인

const string = input[0];
reg.test(string) ? console.log('I love UCPC') : console.log('I hate UCPC');
