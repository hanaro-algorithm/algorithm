const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = input[0];
const splitN_1 = sum(N.slice(0, N.length / 2));
const splitN_2 = sum(N.slice(N.length / 2));

function sum(str) {
  return str
    .split("")
    .map(Number)
    .reduce((acc, cur) => (acc += cur), 0);
}

if (splitN_1 === splitN_2) console.log("LUCKY");
else console.log("READY");
