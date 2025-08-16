class Queue {
    constructor() {
        this.queue = {};
        this.headIndex = 0;
        this.tailIndex = 0;
    }
    enqueue = (value) => {
        this.queue[this.tailIndex++] = value;
    };
    dequeue = () => this.queue[this.headIndex++];
    getLength = () => this.tailIndex - this.headIndex;
}

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const coin = [];
const board = [];
for (let i = 0; i < N; i++) {
    board.push(input[i + 1].split(''));
    for (let j = 0; j < M; j++) {
        if (board[i][j] === 'o') coin.push([i, j]);
    }
}

const dx = [-1, 0, 1, 0];
const dy = [0, -1, 0, 1];

const queue = new Queue();
queue.enqueue([coin[0][0], coin[0][1], coin[1][0], coin[1][1], 0]); // 첫번째 동전 위치, 두번째 동전 위치, 버튼 누른 횟수

while (queue.getLength() > 0) {
    const [x1, y1, x2, y2, count] = queue.dequeue();

    if (count >= 10) return console.log(-1);
    for (let d = 0; d < 4; d++) {
        let nx1 = x1 + dx[d];
        let ny1 = y1 + dy[d];
        let nx2 = x2 + dx[d];
        let ny2 = y2 + dy[d];

        if (nx1 >= 0 && nx1 < N && ny1 >= 0 && ny1 < M && nx2 >= 0 && nx2 < N && ny2 >= 0 && ny2 < M) {
            // 벽 만난 경우 그 자리에 그대로 두기
            if (board[nx1][ny1] === '#') [nx1, ny1] = [x1, y1];
            if (board[nx2][ny2] === '#') [nx2, ny2] = [x2, y2];

            queue.enqueue([nx1, ny1, nx2, ny2, count + 1]);
        } else if (nx1 >= 0 && nx1 < N && ny1 >= 0 && ny1 < M)
            return console.log(count + 1); // 첫번째 동전만 떨어진 경우
        else if (nx2 >= 0 && nx2 < N && ny2 >= 0 && ny2 < M) return console.log(count + 1); // 두번째 동전만 떨어진 경우
    }
}

console.log(-1); // 두 동전 모두 떨어지지 않는 경우
