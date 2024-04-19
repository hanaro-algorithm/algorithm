from itertools import permutations
from collections import deque


def solution(expression):
    answer = 0
    for priority in list(permutations(['+', '-', '*'], 3)):
        answer = max(answer, abs(make_result(priority, expression)))
    return answer


def make_result(priority, expression):
    # arr 만들기
    arr = deque()
    num = ''
    for k in expression:
        if k.isdigit():
            num += k
        else:
            arr.append(num)
            num = ''
            arr.append(k)
    arr.append(num)
    # 계산
    for op in priority:
        stack = []
        while len(arr) != 0:
            temp = arr.popleft()
            if temp == op:
                result = str(eval(stack.pop()+op+arr.popleft()))
                stack.append(result)
            else:
                stack.append(temp)
        arr = deque(stack)
    return int(arr.pop())