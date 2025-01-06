const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0]; // N개의 좌표
const coordinateX = input[1].split(' ').map(Number); // 좌표 정보 저장
const coordinatex = [...new Set(coordinateX)]; // 좌표 압축을 위한 중복 제거 배열
coordinatex.sort((a, b) => a - b); // 오름차순 정렬

const map = new Map();
coordinatex.forEach((x, idx) => map.set(x, idx)); // 좌표 압축 결과 해시 Map에 저장

let answer = '';
coordinateX.forEach((X) => (answer += map.get(X) + ' '));

console.log(answer);
