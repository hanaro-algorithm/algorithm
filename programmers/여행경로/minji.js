function solution(tickets) {
    let answer = [];
    let arr = {};
    tickets.map((ticket) => {
        if (!Object.keys(arr).includes(ticket[0])) {
            arr[ticket[0]] = [ticket[1]];
        } else {
            arr[ticket[0]] = [...arr[ticket[0]], ticket[1]];
            arr[ticket[0]].sort();
        }
    });
    let startArr = Object.keys(arr);
    let endArr = Object.values(arr);

    bfs(arr, startArr, endArr, "ICN", answer);

    startArr.map((item, index) => {
        if (endArr[index].length > 0) answer.push(...endArr[index]);
    });

    return answer;
}

function bfs(arr, startArr, endArr, start, answer) {
    answer.push(start);
    let indexStart = startArr.indexOf(start);
    let items = endArr[indexStart];
    for (let item = 0; item < items.length; item += 1) {
        if (
            !startArr.includes(items[item]) ||
            endArr[startArr.indexOf(items[item])].length === 0
        )
            continue;
        else {
            let end = items.splice(item, 1);
            bfs(arr, startArr, endArr, ...end, answer);
            break;
        }
    }
    return answer;
}

console.log(
    solution([
        ["ICN", "JFK"],
        ["HND", "IAD"],
        ["JFK", "HND"],
    ])
);

console.log(
    solution([
        ["ICN", "SFO"],
        ["ICN", "ATL"],
        ["SFO", "ATL"],
        ["ATL", "ICN"],
        ["ATL", "SFO"],
    ])
);

console.log(
    solution([
        ["ICN", "SFO"],
        ["ICN", "ATL"],
        ["SFO", "ICN"],
    ])
);

console.log(
    solution([
        ["ICN", "BOO"],
        ["ICN", "COO"],
        ["COO", "DOO"],
        ["DOO", "COO"],
        ["BOO", "DOO"],
        ["DOO", "BOO"],
        ["BOO", "ICN"],
        ["COO", "BOO"],
        ,
    ])
); //["ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"]
