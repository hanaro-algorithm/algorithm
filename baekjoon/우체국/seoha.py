import sys
input = sys.stdin.readline

N = int(input())
info = []
for _ in range(N):
    info.append(tuple(map(int, input().split())))

info.sort()

prefix = [0] * N
prefix[0] = info[0][1]

for i in range(1, N):
    prefix[i] = prefix[i-1] + info[i][1]

for i in range(N):
    left = prefix[i]
    right = prefix[N-1] - prefix[i]
    if left >= right:
        print(info[i][0])
        break