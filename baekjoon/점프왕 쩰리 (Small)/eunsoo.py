import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]
visited = [[False for _ in range(n)] for _ in range(n)]
success = False

def solution(x,y):
    global success
    if data[x][y] == -1:
        success = True
        return

    visited[x][y] = True
    nx = x + data[x][y]
    ny = y + data[x][y]
    if 0 <= nx < n and visited[nx][y] == False:
        solution(nx, y)
    if 0 <= ny < n and visited[x][ny] == False:
        solution(x, ny)

solution(0,0)
if success: print("HaruHaru")
else: print("Hing")