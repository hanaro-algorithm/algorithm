const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = +input[0];
const signal = input[1];

const number = {
  0: "####.##.##.####",
  1: "#####",
  2: "###..#####..###",
  3: "###..####..####",
  4: "#.##.####..#..#",
  5: "####..###..####",
  6: "####..####.####",
  7: "###..#..#..#..#",
  8: "####.#####.####",
  9: "####.####..####",
};

let ans = "";

for (let i = 0; i < N / 5; i++) {
  if (signal[i] === "#") {
    if (i + 1 >= N / 5 || i + 2 >= N / 5) {
      ans += "1";
      break;
    } else {
      let [l1, l2, l3] = [i, i + 1, i + 2];
      let curSignal = signal[l1] + signal[l2] + signal[l3];
      for (let j = 0; j < 4; j++) {
        l1 += N / 5;
        l2 += N / 5;
        l3 += N / 5;
        curSignal += signal[l1] + signal[l2] + signal[l3];
      }
      if (Object.values(number).includes(curSignal)) {
        const findNum = Object.keys(number).find(
          (key) => number[key] === curSignal
        );
        ans += findNum;
        i += 3;
      } else {
        ans += "1";
        i++;
      }
    }
  }
}
console.log(ans);
