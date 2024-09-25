import sys

input = sys.stdin.readline

N = int(input())
numbers = [input().rstrip() for _ in range(N)]
k = 1

while True:
    temp = []

    for number in numbers:
        temp.append(number[-1*k:])

    if len(temp) == len(set(temp)):
        break
    else:
        k += 1

    if k == 100:
        break

print(k)