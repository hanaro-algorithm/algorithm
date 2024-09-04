import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

car = deque()
result = 0
for _ in range(n):
    car.append(input())
for _ in range(n):
    out = input()
    if car[0] == out:
        car.popleft()
    else:
        car.remove(out)
        result += 1

print(result)