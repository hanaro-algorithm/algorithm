import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
arr = []
max_height = 0

for _ in range(n):
    land = list(map(int, input().split()))
    arr.append(land)
    max_height = max(max_height, max(land))

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def bfs(x,y,num):
    q = deque()
    q.append((x,y))
    visited[x][y] = True

    while q:
        a,b = q.popleft()
        for i in range(4):
            ax = a+dx[i]
            ay = b+dy[i]

            if 0 <= ax < n and 0 <= ay < n:
                if arr[ax][ay] > num and not visited[ax][ay]:
                    q.append((ax,ay))
                    visited[ax][ay] = True

result = 0

for l in range(max_height):
    cnt = 0
    visited = [[False]*n for _ in range(n)]
    for j in range(n):
        for k in range(n):
            if arr[j][k] > l and not visited[j][k]:
                bfs(j,k,l)
                cnt+=1
    result = max(result, cnt)

print(result)