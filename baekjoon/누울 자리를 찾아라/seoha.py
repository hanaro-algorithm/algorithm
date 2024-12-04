import sys

input = sys.stdin.readline

N = int(input())
graph = [input().rstrip() for _ in range(N)]

x, y = 0, 0

# 가로 체크
for i in range(N):
    curr = 0
    for j in range(N):
        if graph[i][j] == '.':
            curr += 1
        elif graph[i][j] == 'X':
            if curr >= 2:
                x += 1
            curr = 0
    if curr >= 2:
        x += 1

# 세로 체크
for i in range(N):
    curr = 0
    for j in range(N):
        if graph[j][i] == '.':
            curr += 1
        elif graph[j][i] == 'X':
            if curr >= 2:
                y += 1
            curr = 0
    if curr >= 2:
        y += 1

print(x, y)