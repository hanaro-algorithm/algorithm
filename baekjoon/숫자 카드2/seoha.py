"""
이분탐색을 이용하여 여러가지 방법으로 시도해봤지만,
시간초과 오류가 계속 발생 😢
"""

import sys

N = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().rstrip().split()))

M = int(sys.stdin.readline().rstrip())
numbers = list(map(int, sys.stdin.readline().rstrip().split()))

result = {}

for a in arr:
    if a in result:
        result[a] += 1
    else:
        result[a] = 1

for number in numbers:
    if number in result:
        print(result[number], end=' ')
    else:
        print(0, end=' ')


