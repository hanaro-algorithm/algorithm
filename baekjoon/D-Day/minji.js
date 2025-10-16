const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const today = input[0].split(' ').map(Number);
const Dday = input[1].split(' ').map(Number);

// 천 년이상 지속되는 경우 gg 출력
if (
    today[0] + 1000 < Dday[0] ||
    (today[0] + 1000 === Dday[0] && today[1] < Dday[1]) ||
    (today[0] + 1000 === Dday[0] && today[1] === Dday[1] && today[2] <= Dday[2])
)
    return console.log('gg');

const diffTime = new Date(Dday[0], Dday[1] - 1, Dday[2]) - new Date(today[0], today[1] - 1, today[2]);
const diffDate = diffTime / (1000 * 60 * 60 * 24);
console.log('D-' + diffDate);
