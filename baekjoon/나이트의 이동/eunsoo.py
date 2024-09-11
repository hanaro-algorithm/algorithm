import sys
from collections import deque

input = sys.stdin.readline

t = int(input())
dx = [1, 2, 2, 1, -1, -2, -2, -1]
dy = [2, 1, -1, -2, -2, -1, 1, 2]

def bfs(x, y):
    queue = deque()
    queue.append((x,y))

    while queue:
        xx,yy = queue.popleft()
        for i in range(8):
            nx = xx + dx[i]
            ny = yy + dy[i]
            if 0 <= nx < l and 0 <= ny < l:
                if visited[nx][ny] == 0:
                    visited[nx][ny] = visited[xx][yy] + 1
                    queue.append((nx,ny))

for _ in range(t):
    l = int(input())
    visited = [[0]*l for _ in range(l)]
    ax,ay = map(int,input().split())
    bx,by = map(int,input().split())

    if ax == bx and ay == by:
        print(0)
        continue

    bfs(ax,ay)
    print(visited[bx][by])
