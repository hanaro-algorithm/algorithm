def solution(numbers, target):
    curr = [0]
    for a in numbers:
        temp = []
        for b in curr:
            temp.append(b + a)
            temp.append(b - a)
        curr = temp
    return curr.count(target)

print(solution([4, 1, 2, 1], 4))
