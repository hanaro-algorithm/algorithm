// fees[기본 시간, 기본 요금, 단위 시간, 단위 요금]
function solution(fees, records) {
  let answer = [];
  let inCar = []; // 입차
  let outCar = []; // 출차

  // 입차, 출차 구분 짓기
  records.map((record) => {
    record = record.split(" ");
    if (record[2] === "IN") {
      inCar.push([record[0], record[1]]);
    } else if (record[2] === "OUT") {
      outCar.push([record[0], record[1]]);
    }
  });

  // 입차, 출차 차량번호를 기준으로 오름차순 정렬
  inCar.sort((a, b) => +a[1] - +b[1]);
  outCar.sort((a, b) => +a[1] - +b[1]);

  // 입차는 존재하지만, 출차가 없는 경우 23:59를 출차에 추가
  for (let i = 0; i < inCar.length; i += 1) {
    if (i < outCar.length) {
      if (inCar[i][1] !== outCar[i][1]) {
        outCar.splice(i, 0, ["23:59", inCar[i][1]]);
        i -= 1;
      }
    } else {
      outCar.push(["23:59", inCar[i][1]]);
    }
  }

  let total = new Set();
  for (let i = 0; i < inCar.length; i += 1) {
    let inCarItem = inCar[i][0].split(":");
    let inCarTime = Number(inCarItem[0]) * 60 + Number(inCarItem[1]);

    let outCarItem = outCar[i][0].split(":");
    let outCarTime = Number(outCarItem[0]) * 60 + Number(outCarItem[1]);

    let totalTime = outCarTime - inCarTime;

    // 각 차량별 누적 시간 저장
    if (Object.keys(total).includes(inCar[i][1])) {
      total[inCar[i][1]] += totalTime;
    } else {
      total[inCar[i][1]] = totalTime;
    }
  }

  // 누적시간에 대한 최종 요금 계산
  Object.entries(total).forEach((item) => {
    let resultFee = 0;
    if (item[1] <= fees[0]) {
      resultFee += fees[1];
    } else {
      resultFee = fees[1] + Math.ceil((item[1] - fees[0]) / fees[2]) * fees[3];
    }
    answer.push([item[0], resultFee]);
  });
  answer.sort((a, b) => +a[0] - +b[0]); // 차량 번호를 기준으로 오름차순 정렬

  return answer.map((item) => item[1]);
}

console.log(
  solution(
    [180, 5000, 10, 600],
    [
      "05:34 5961 IN",
      "06:00 0000 IN",
      "06:34 0000 OUT",
      "07:59 5961 OUT",
      "07:59 0148 IN",
      "18:59 0000 IN",
      "19:09 0148 OUT",
      "22:59 5961 IN",
      "23:00 5961 OUT",
    ]
  )
);
console.log(
  solution(
    [120, 0, 60, 591],
    [
      "16:00 3961 IN",
      "16:00 0202 IN",
      "18:00 3961 OUT",
      "18:00 0202 OUT",
      "23:58 3961 IN",
    ]
  )
);
console.log(solution([1, 461, 1, 10], ["00:00 1234 IN"]));
