function solution(nums) {
  const numArr = nums.split("").map(Number);
  let acc = numArr[0];
  for (let i = 1; i < numArr.length; i += 1) {
    const add = acc + numArr[i];
    const mul = acc * numArr[i];
    acc = Math.max(add, mul);
  }
  return acc;
}

console.log(solution("02984"));
console.log(solution("567"));
