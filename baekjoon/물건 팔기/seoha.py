import sys

input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
arr.sort()

result = 0
max_total = 0

for i in range(N):
    temp = 0
    curr = arr[i][0]
    for j in range(i, N):
        if curr > arr[j][1]:
            temp += curr - arr[j][1]

    if temp > max_total:
        result = curr
        max_total = temp

print(result)