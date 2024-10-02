import sys
from collections import deque

input = sys.stdin.readline

m,n = map(int, input().split())
data = [list(map(int, input().rstrip())) for _ in range(m)]
visited = [[False for _ in range(n)] for _ in range(m)]

dx = [0,0,-1,1]
dy = [1,-1,0,0]
success = False

def solution(x,y):
    global success

    queue = deque()
    queue.append((x,y))
    visited[x][y] = True

    while queue:
        xx,yy = queue.popleft()
        if xx == m - 1:
            success = True
            return

        for i in range(4):
            nx = xx + dx[i]
            ny = yy + dy[i]

            if 0 <= nx < m and 0 <= ny < n:
                if data[nx][ny] == 0 and visited[nx][ny] == False:
                    visited[nx][ny] = True
                    queue.append((nx,ny))



for j in range(n):
    if data[0][j] == 0 and visited[0][j] == False:
        solution(0,j)

if success: print('YES')
else: print('NO')